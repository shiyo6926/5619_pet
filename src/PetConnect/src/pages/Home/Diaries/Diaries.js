import React, { useState, useEffect } from "react";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import TextField from '@mui/material/TextField';
import AddOutlinedIcon from '@mui/icons-material/AddOutlined';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import DoneAllOutlinedIcon from '@mui/icons-material/DoneAllOutlined';
import { DemoContainer } from "@mui/x-date-pickers/internals/demo";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DateTimePicker } from "@mui/x-date-pickers/DateTimePicker";
import axios from 'axios';



function Diaries() {
    // State Hook - `useState`
    const [newItem, setNewItem] = useState("");
    const [items, setItems] = useState([]);

    const instance = axios.create({
        baseURL: 'http://localhost:9090', // 后端的地址
    });

    const [showEdit, setShowEdit] = useState(-1);
    const [updatedText, setUpdatedText] = useState("");
    //const [secondary, setSecondary] = React.useState(true);

    const userId = localStorage.getItem('userId');
    const userIid = {
        userId: userId,
    };

    // Helper Functions
    useEffect(() => {
        // 创建一个异步函数来获取后端数据
        async function fetchData() {            
            try {
                const response = await instance.post('/petdiary/get', userIid); // 替换为您的后端 API 的 URL
                console.log('传给get口的',userId);
                const newData = response.data; // 根据您的数据结构进行调整
                console.log('New data:', newData); // 检查新数据

                // 合并所有数组项到一个新数组
                const mergedItems = newData.reduce((accumulator, currentArray) => {
                    return accumulator.concat(currentArray);
                }, []);

                setItems(mergedItems);
                //如果后端传来就一个数组比如{ id: 9998, value: "等后端",  date:"2023/10/01 01:05" }就这样 → setItems([newData]);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }

        fetchData();
    }, []);

    //给后端的 好像新增，删除和修改都要不同接口
    async function addDataToBackend(item) {
        try {
            const response = await instance.post('/petdiary/add', item); // 替换为您的后端 API 的 URL
            console.log('Data sent to backend:', response.data); // 如果需要的话，可以打印后端的响应
            //然后再把自己前端生成的id换成后端返回的petDiaryId
            const newPetDiaryId = response.data.petDiaryId;
            console.log('后端返回的:petDiaryId', newPetDiaryId);
            item.petDiaryId = newPetDiaryId;
        } catch (error) {
            console.error('Error sending data to backend:', error);
        }
    }

    async function deleteDataToBackend(item) {
        try {
            const response = await instance.post('/petdiary/delete', item); // 替换为您的后端 API 的 URL
            console.log('删除日记后的后端响应:', response.data); // 如果需要的话，可以打印后端的响应
        } catch (error) {
            console.error('Error sending data to backend:', error);
        }
    }

    async function editDataToBackend(newItem) {
        try {
            const response = await instance.post('/petdiary/edit', newItem); // 替换为您的后端 API 的 URL
            console.log('Data sent to backend:', response.data); // 如果需要的话，可以打印后端的响应
        } catch (error) {
            console.error('Error sending data to backend:', error);
        }
    }

    /* Adds a new item to the list array*/
    function addItem() {
        // ! Check for empty item
        if (!newItem) {
            alert("Press enter an item.");
            return;
        }

        if (!choseDay) {
            alert("Press chose Day.");
            return;
        }


        const item = {
            petDiaryId: Math.floor(Math.random() * 1000),
            value: newItem,
            date: choseDay,
            userId: userId,
        };

        // Add new item to items array
        setItems((oldList) => [...oldList, item]);

        // Reset newItem back to original state
        setNewItem("");
        addDataToBackend(item);
    }

    /* Deletes an item based on the `item.id` key */
    function deleteItem(petDiaryId) {
        const newArray = items.filter((item) => item.petDiaryId !== petDiaryId);
        setItems(newArray);
        const item = {
            petDiaryId: petDiaryId,
            userId: userId,
        };
        deleteDataToBackend(item);
    }

    /* Edit an item text after creating it. */
    function editItem(petDiaryId, newText, date) {
        // Get the current item
        const currentItem = items.filter((item) => item.petDiaryId === petDiaryId);

        // Create a new item with 随机 id，这样的话是原id【id: currentItem.id,】但是id传不过去后端
        const newItem = {
            //id: currentItem.id,
            //oldId: petDiaryId,
            //petDiaryId: Math.floor(Math.random() * 1000),
            petDiaryId: petDiaryId,
            value: newText,
            date: choseDay,
            userId: userId,
        };

        //deleteItem(petDiaryId);
        const newArray = items.filter((item) => item.petDiaryId !== petDiaryId);
        setItems(newArray);

        // Replace item in the item list
        setItems((oldList) => [...oldList, newItem]);
        setUpdatedText("");
        setShowEdit(-1);
        editDataToBackend(newItem);
    }

    const [selectedDate, setSelectedDate] = useState(null);
    const handleDateChange = (date) => {
        setSelectedDate(date);
    };
    const choseDay = selectedDate && (selectedDate.format("YYYY/MM/DD HH:mm"));

    // Main part of app
    return (
        <div>
            {/* 1. Header  */}
            <Typography
                style={{ color: '#C932C3' }}
                variant="h3"
                fontWeight="bold"
                marginTop={5}>
                Pet Diaries
            </Typography>
            <br></br>

            {/* 2. Add new item (input) */}

            <TextField
                sx={{ width: 600, marginLeft: '90px' }}
                id="standard-basic"
                label="In put your diary"
                variant="standard"
                type="text"
                placeholder="Add diary..."
                value={newItem}
                onChange={(e) => setNewItem(e.target.value)}
            />
            {/* Add (button) */}
            <Button>
                <AddOutlinedIcon fontSize='large' onClick={() => addItem()}></AddOutlinedIcon>
            </Button>

            <Box sx={{ margin: '0 auto', marginTop: '10px', width: '100%', maxWidth: 300, bgcolor: 'background.paper' }}>
                <LocalizationProvider dateAdapter={AdapterDayjs}>
                    <DemoContainer components={['DateTimePicker']}>
                        <DateTimePicker
                            ampm={false}
                            value={selectedDate}
                            onChange={handleDateChange}
                            renderInput={(props) => <TextField {...props} />}
                        />
                    </DemoContainer>
                </LocalizationProvider>
            </Box>

            <Box sx={{ margin: '0 auto', width: '100%', maxWidth: 700, bgcolor: 'background.paper' }}>
                <List>
                    {items.map((item) => (
                        <ListItem key={item.petDiaryId} disablePadding>
                            <ListItemButton >
                                <ListItemText
                                    primary={item.value}
                                    secondary={item.date} />
                            </ListItemButton>
                            <Button>
                                <EditOutlinedIcon onClick={() => setShowEdit(item.petDiaryId)}></EditOutlinedIcon>
                            </Button>
                            <Button>
                                <DeleteOutlineOutlinedIcon onClick={() => deleteItem(item.petDiaryId)}></DeleteOutlineOutlinedIcon>
                            </Button>
                            {showEdit === item.petDiaryId ? (
                                <div>
                                    <TextField
                                        id="outlined-basic"
                                        label="Edit"
                                        variant="outlined"
                                        type="text"
                                        defaultValue={item.value}
                                        value={updatedText}
                                        onChange={(e) => setUpdatedText(e.target.value)}
                                    />
                                    <Button>
                                        <DoneAllOutlinedIcon onClick={() => editItem(item.petDiaryId, updatedText)}></DoneAllOutlinedIcon>
                                    </Button>
                                </div>
                            ) : null}
                        </ListItem>
                    ))}
                </List>
            </Box>

            {/* {selectedDate && (
                <div>
                    <p>Time: </p>
                    <p>{choseDay}</p>
                </div>
            )} */}

        </div>
    );
}

export default Diaries;


