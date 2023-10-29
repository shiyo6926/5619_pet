import React, { useState, useEffect } from "react";
import Typography from '@mui/material/Typography';
import axios from 'axios';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';

export default function Forum() {

  const [newItem, setNewItem] = useState("");
  const [items, setItems] = useState([]);
  const [userNames, setUserNames] = useState([]);
  const [postUserId, setPostUserId] = useState([]);
  const [newData, setNewData] = useState([]);
  const [currentTime, setCurrentTime] = useState(new Date());

  const userId = parseInt(localStorage.getItem('userId'), 10);
  const userName = localStorage.getItem('userName');

  const instance = axios.create({
    baseURL: 'http://localhost:9090/posts', // 后端的地址
  });


  function sendPost() {
    // ! Check for empty item
    if (!newItem) {
        alert("Press enter your message.");
        return;
    }

    const item = {
        postId: Math.floor(Math.random() * 1000),
        postContent: newItem,
        date: currentTime.toLocaleString(),
        userId: userId,
        userName: userName,
    };

    // Add new item to items array, 这里不管他了吧，发了帖子就刷新直接从后端拿新列表
    //setItems((oldList) => [...oldList, item]);

    // Reset newItem back to original state
    setNewItem("");
    addDataToBackend(item);
}

async function addDataToBackend(item) {
  try {
      const response = await instance.post('/createPost', item); // 替换为您的后端 API 的 URL
      console.log('Data sent to backend:', response.data); // 如果需要的话，可以打印后端的响应
      //然后再把自己前端生成的id换成后端返回的petDiaryId
      const newPostId = response.data.postId;
      console.log('后端返回的:petDiaryId', newPostId);
      item.postId = newPostId;
      window.location.reload();
  } catch (error) {
      console.error('Error sending data to backend:', error);
  }
}

const handleDeleteItem = async (postId) => {

  const item = {
    postId: postId,
    userId: userId,
};

  try {
    // 发送删除请求到后端
    await deleteDataToBackend(item);
    // 请求成功后刷新页面
    window.location.reload();
  } catch (error) {
    console.error('Error deleting data:', error);
  }
};

async function deleteDataToBackend(item) {
  try {
      const response = await instance.post('/deletePost', item); // 替换为您的后端 API 的 URL
      console.log('删除帖子后的后端响应:', response.data); // 如果需要的话，可以打印后端的响应
  } catch (error) {
      console.error('Error sending data to backend:', error);
  }
}


  useEffect(() => {
    // 创建一个异步函数来获取后端数据
    async function fetchData() {
      try {
        const response = await instance.get('/getAllPosts'); // 替换为您的后端 API 的 URL
        const newData = response.data; // 根据您的数据结构进行调整
        console.log('New 帖子:', newData); // 检查新数据
        const userNames = newData.map(item => item.userName);
        //const postUserId = newData.map(item => item.userId);
        //setPostUserId(postUserId);
        console.log('User Name list:', userNames);//得到了
        setUserNames(userNames);
        setNewData(newData);

        // 合并所有数组项到一个新数组
        const mergedItems = newData.reduce((accumulator, currentArray) => {
          return accumulator.concat(currentArray);
        }, []);
        setItems(mergedItems);
      
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }

    fetchData();
  }, []);

  useEffect(() => {
    const intervalId = setInterval(() => {
      setCurrentTime(new Date());
    }, 1000); // 每秒钟更新一次时间

    // 清除定时器以避免内存泄漏
    return () => {
      clearInterval(intervalId);
    };
  }, []);

  return (
    <div className="row">
      <div className='col-md-10'>
        <Typography
          style={{ color: '#C932C3' }}
          variant="h3"
          fontWeight="bold"
          marginTop={5}>
          Home page forum
        </Typography>
        <br></br>
        {userNames.map((userName, index) => (
          <div class="panel panel-default">
            <div class="panel-heading" style={{ display: 'flex', alignItems: 'center' }}>
              <h3 class="panel-title" key={index}>{userName}</h3>
              <h6 style={{ marginLeft: '50%' }}>{newData[index].postDate}</h6>
              {userId === newData[index].userId && (
                <div style={{ display: 'flex', marginLeft: 'auto' }}>
                  <Button>
                    <DeleteOutlineOutlinedIcon onClick={() => handleDeleteItem(newData[index].postId)}></DeleteOutlineOutlinedIcon>
                  </Button>
                </div>
              )}
            </div>
            <div class="panel-body">
              {newData[index].postContent}
            </div>
          </div>
        ))}
        <br />
        <Stack direction="row" spacing={2} marginTop={2}>
          <TextField
            sx={{
              width: 700,
              "& .MuiInputBase-root": {
                height: 100
              }
            }}
            id="outlined-multiline-static"
            multiline
            defaultValue="Create your post..."
            placeholder="Create your post..."
            value={newItem}
            onChange={(e) => setNewItem(e.target.value)}
          />

          <Button variant="contained" style={{ backgroundColor: '#C932C3' }} onClick={() => sendPost()}>Post</Button>
        </Stack>
      </div>
      <div className='col-md-3'>
      </div>
    </div>
  );
}
