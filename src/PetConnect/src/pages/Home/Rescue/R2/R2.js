import React, { useState, useEffect } from "react";
import axios from 'axios';


export default function R2() {

    //使用axios await.get从后端接受标题和内容
  //   const instance = axios.create({
  //     baseURL: 'http://localhost:9090', // 后端的地址
  // });

  const [title, setTitle] = useState('');
  const [paragraphs, setParagraphs] = useState([]);

  useEffect(() => {
    // 创建一个异步函数来获取后端数据
    fetch('http://localhost:9090/articles/article2')
    .then(response => response.json()) // 将响应数据解析为JSON格式
    .then(data => {
      // 在控制台中打印获取的数据
      const petRescueTitle = data[0].petRescueTitle; // 假设数据是一个数组，这里选择第一个元素
      setTitle(petRescueTitle);
      const petRescueContent = data[0].petRescueContent;
      const paragraphs = petRescueContent.split('###');
      setParagraphs(paragraphs);
    })
    .catch(error => {
      console.error('获取数据时出错：', error);
    });
    
  }, []);

  return (
    <div className="row">
      <div className='col-md-10'>
        <h2>{title}</h2><br />
        {paragraphs.map((paragraph, index) => (
        <p key={index}>{paragraph}</p>
      ))}
      </div>
      <div className='col-md-3'>
      </div>
    </div>
  );
}