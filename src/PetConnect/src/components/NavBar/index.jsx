import React, { useState, useEffect, Component } from 'react';
import "./style.css"
import NotificationsNoneOutlinedIcon from '@mui/icons-material/NotificationsNoneOutlined';
import axios from 'axios';
import Divider from '@mui/material/Divider'
import { SearchBar } from '../SearchBar/SearchBar';
import { SearchResultsList } from '../SearchBar/SearchResultsList';
import Hidden from '@mui/material/Hidden';

export default function NavBar() {

  const [isHovered, setIsHovered] = useState(false);

  const handleMouseEnter = () => {
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
  };

  const [items, setItems] = useState([]);
  const [dates, setDates] = useState([]);
  const [newData, setNewData] = useState([]);
  const [daysDiff, setDaysDiff] = useState();
  const [daysDiffArray, setDaysDiffArray] = useState([]);
  const [results, setResults] = useState([]);
  console.log("搜索栏ResultsList: ", results);

  const instance = axios.create({
    baseURL: 'http://localhost:9090', // 后端的地址
  });

  const userId = localStorage.getItem('userId');
  const userIid = {
    userId: userId,
  };

  useEffect(() => {

    // 创建一个异步函数来获取后端数据
    async function fetchData() {
      try {
        const response = await instance.post('/petdiary/get', userIid); // 替换为您的后端 API 的 URL
        console.log('传给get口的', userId);
        const newData = response.data; // 根据您的数据结构进行调整
        console.log('New data:', newData); // 检查新数据
        setNewData(newData);

        // 合并所有数组项到一个新数组
        const mergedItems = newData.reduce((accumulator, currentArray) => {
          return accumulator.concat(currentArray);
        }, []);

        setItems(mergedItems);
        console.log('mergedItems', mergedItems);

        const dates = mergedItems.map(item => item.date);
        const currentDate = new Date();
        const daysDiffArray = [];
        
        // 创建一个对象，将日期作为键，将对应的value作为值
        const dateValueMap = {};
        mergedItems.forEach(item => {
          dateValueMap[item.date] = item.value;
        });
        
        dates.forEach(dateStr => {
          const date = new Date(dateStr); // 将日期字符串转换为日期对象
          // 设置时间部分为午夜，以便只比较日期部分
          //date.setHours(0, 0, 0, 0);
        
          if (date < currentDate) {
            console.log(`${dateStr} 过期了`);
          } else {
            const timeDiff = date - currentDate;
            const daysDiff = Math.floor(timeDiff / (1000 * 3600 * 24));
            console.log(`日期 ${dateStr} 与当前日期相差 ${daysDiff} 天`);
            daysDiffArray.push({ date: dateStr, daysDiff, value: dateValueMap[dateStr] });
          }
        });
        
        // 在daysDiffArray中每个元素包含了日期、daysDiff和相应的value
        console.log('daysDiffArray', daysDiffArray);
        setDaysDiffArray(daysDiffArray);

      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
    fetchData();

  }, []);


  return (

    <nav className="navbar navbar-default">
      <div className="container-fluid">
        <div className="navbar-header" style={{ marginLeft: '20px' }}>
          <a className="navbar-brand" href="/home">
            <img alt="Brand" src="/4.png" width={90} height={25} ></img>
          </a>
        </div>
        <Hidden mdDown>
        <div style={{ display: 'flex', justifyContent: 'center', marginTop: '12px', }}><SearchBar setResults={setResults} /></div>
        <SearchResultsList results={results} />
        <div className="navbar-right" style={{ marginRight: '20px' }}> {/* 调整右边距 */}
          <div
            className="icon-container"
            onMouseEnter={handleMouseEnter}
            onMouseLeave={handleMouseLeave}
          >
            <NotificationsNoneOutlinedIcon style={{ fontSize: '24px' }} /> {/* 调整图标大小 */}
            {isHovered && (
              <div className="hover-box">
                {daysDiffArray.map((item, index) => (
                  <div key={index}>
                    <Divider />
                    {item.daysDiff < 1 ? (
                      <p>Less than 1 day left!</p>
                    ) : (
                      <p>{item.daysDiff} day to go</p>
                    )}
                    <p>{item.value}</p>
                    <Divider />
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>
        </Hidden>
      </div>
    </nav>

  );

}




