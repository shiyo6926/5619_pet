import React, { useState, useEffect } from "react";
import { Route, Redirect, Switch } from 'react-router-dom/cjs/react-router-dom.min';
import axios from 'axios';
import Typography from '@mui/material/Typography';
import R2 from "./R2/R2"
import R1 from "./R1/R1";
import R3 from "./R3/R3";
import R4 from "./R4/R4";
import R5 from "./R5/R5";


export default function Rescue() {

  //   //使用axios await.get从后端接受标题和内容
  //   const instance = axios.create({
  //     baseURL: 'http://demo7864709.mockable.io/', // 后端的地址
  // });

  // const [title, setTitle] = useState('');
  // const [paragraphs, setParagraphs] = useState([]);

  // useEffect(() => {
  //   // 创建一个异步函数来获取后端数据
  //   async function fetchData() {
  //       try {
  //           const response = await instance.get('/reading'); // 替换为您的后端 API 的 URL
  //           const newTitle  = response.data.title; // 根据您的数据结构进行调整
  //           const newContent = response.data.content;
  //           const paragraphs = newContent.split('###');
  //           setTitle(newTitle );
  //           setParagraphs(paragraphs);
  //           console.log('paragraphs:', paragraphs ); 
  //       } catch (error) {
  //           console.error('Error fetching data:', error);
  //       }
  //   }
  //   fetchData();
  // }, []);
  const [page, setPage] = useState(1);
  console.log("page: ", page);

  const handlePageChange = (newPage) => {
    setPage(newPage);
  };

  return (
    <div className="row">
      <div className='col-md-10'>
        <Typography
          style={{ color: '#C932C3' }}
          variant="h3"
          fontWeight="bold"
          marginTop={5}>
          Rescue
        </Typography>
        <Switch>
          <Route path="/home/Rescue/1" component={R1}></Route>
          <Route path="/home/Rescue/2" component={R2}></Route>
          <Route path="/home/Rescue/3" component={R3}></Route>
          <Route path="/home/Rescue/4" component={R4}></Route>
          <Route path="/home/Rescue/5" component={R5}></Route>
        </Switch>
        <nav aria-label="Page navigation" style={{ marginTop: '100px', marginLeft: '200px' }}>
          <ul class="pagination">
            <li>
              <a href="#" aria-label="Previous" onClick={() => handlePageChange(page - 1)}>
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li><a href="/home/Rescue/1" onClick={() => setPage(1)}>1</a></li>
            <li><a href="/home/Rescue/2" onClick={() => setPage(2)}>2</a></li>
            <li><a href="/home/Rescue/3" onClick={() => setPage(3)}>3</a></li>
            <li><a href="/home/Rescue/4" onClick={() => setPage(4)}>4</a></li>
            <li><a href="/home/Rescue/5" onClick={() => setPage(5)}>5</a></li>
            <li>
              <a href="#" aria-label="Next" onClick={() => handlePageChange(page + 1)}>
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>

      </div>
      <div className='col-md-3'>
      </div>
    </div>
  );
}