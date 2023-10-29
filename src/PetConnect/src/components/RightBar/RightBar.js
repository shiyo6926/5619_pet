import React, { useState, useEffect, Component } from 'react';
import { Link } from 'react-router-dom';
import { Box, List, Button, Hidden , FormLabel, TextField, Typography } from '@mui/material';
import axios from 'axios';
import { useHistory } from 'react-router-dom';


export default function RightBar() {

    const history = useHistory()

    const [titles, setTitles] = useState([]);
    const [newTitle, setNewTitle] = useState('');

    const instance = axios.create({
        baseURL: 'http://localhost:9090', // 后端的地址
    });

    useEffect(() => {
        // 创建一个异步函数来获取后端数据
        async function fetchData() {
            try {
                const response = await instance.get('/articles'); // 替换为您的后端 API 的 URL
                const newTitle  = response.data; // 根据您的数据结构进行调整
                const titles = newTitle.map(item => item.petRescueTitle);
                setTitles(titles);
                setNewTitle(newTitle);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }
        fetchData();
      }, []);


    const changeIndex = (param) => {
        localStorage.setItem('selectedIndex', 8);
        history.push(`/home/Rescue/${param}`);
        window.location.reload();
        history.push(`/home/Rescue/${param}`);
    }

    return (
        <Hidden mdDown>
        <div>
            <Box sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
            
                <Typography fontSize={16}>Suggestion Reading</Typography>
                {titles.map((title, index) => (
                    <Box sx={{ width: 300, height: 80, bgcolor: '#F8F8F8', display: 'flex' }} spacing={2} marginTop={2}>
                        <Typography
                            fontSize={18}
                            component={Link}
                            to="/home/Rescue"
                            onClick={() => changeIndex(index + 1)} // 传递 index + 1 作为参数
                        >
                            <Box sx={{
                                width: 300,
                                height: 80,
                                textAlign: 'center',
                                display: 'flex',
                                flexDirection: 'column',
                                justifyContent: 'center',
                                alignItems: 'center',
                            }}>
                                {title}
                            </Box>
                        </Typography>
                    </Box>
                ))}

            </Box>
        </div>
        </Hidden>
    );

}

