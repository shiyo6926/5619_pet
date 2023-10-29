import React, { useState, useEffect, Component } from 'react';
import { Link } from 'react-router-dom';
import { Box, List, Button, CssBaseline, FormLabel, TextField, Typography } from '@mui/material';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Divider from '@mui/material/Divider';
import SmartToyOutlinedIcon from '@mui/icons-material/SmartToyOutlined';
import HomeOutlinedIcon from '@mui/icons-material/HomeOutlined';
import BookOutlinedIcon from '@mui/icons-material/BookOutlined';
import AssessmentOutlinedIcon from '@mui/icons-material/AssessmentOutlined';
import ThreePOutlinedIcon from '@mui/icons-material/ThreePOutlined';
import CalendarMonthOutlinedIcon from '@mui/icons-material/CalendarMonthOutlined';
import FavoriteBorderOutlinedIcon from '@mui/icons-material/FavoriteBorderOutlined';
import LocalHospitalOutlinedIcon from '@mui/icons-material/LocalHospitalOutlined';
import ThermostatOutlinedIcon from '@mui/icons-material/ThermostatOutlined';
import axios from 'axios';

function LeftBar(params) {
    const [selectedIndex, setSelectedIndex] = React.useState(0);

    const handleListItemClick = (event, index) => {
          setSelectedIndex(index);
    };

    useEffect(() => {
      const storedIndex = localStorage.getItem('selectedIndex');
      if (storedIndex !== null) {
        setSelectedIndex(parseInt(storedIndex, 10));
      }
    }, []);

    useEffect(() => {
      localStorage.setItem('selectedIndex', selectedIndex);
    }, [selectedIndex]);

    const userName = localStorage.getItem('userName');
    const userId = localStorage.getItem('userId');

    const instance = axios.create({
      baseURL: 'http://localhost:9090', // 后端的地址
  });

    const handleLogout = async () => {
      const data = { "logout": true, "userId": userId};
      try {
        const response = await instance.post('/log_out', data);
        //具体看后端传来啥
        //console.log('log_out的后端返回:', response.data)
        if (response.data.reason === 'success') {
          // 在成功响应后执行的操作，例如跳转到登录页面
          localStorage.setItem('userId', '');
          console.log('点了登出后的userId:', userId);
          window.location.href = '/SignIn';
        } else {
          console.error('Request failed with status:', response.status);
          // 可以在此处处理其他失败情况
        }
      } catch (error) {
        console.error('Error:', error);
        // 处理网络请求错误
      }
    };

    return (
        <Box sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper'}}>
          <div style={{ display: 'flex', justifyContent: 'space-between' }}>
          <Typography fontSize={16}>Hello, {userName}</Typography>
          {/* <Typography fontSize={16} textAlign="right" component={Link} to="/SignIn" >log out</Typography> */}
          <Typography
            fontSize={16}
            textAlign="right"
            component={Link}
            to="/SignIn"
            onClick={handleLogout}
          >
            log out
          </Typography>
          </div>
            <List 
              component="nav" aria-label="main mailbox folders"
              sx={{
              '&& .Mui-selected, && .Mui-selected:hover': {
                bgcolor: '#FFA1E5',
                },
              }}>

              <ListItemButton 
                component={Link}
                to="/home/forum" 
                selected={selectedIndex === 0}
                onClick={(event) => handleListItemClick(event, 0)}>
                  <ListItemIcon>
                    <HomeOutlinedIcon />
                  </ListItemIcon>
                  <ListItemText primary="Home" />
              </ListItemButton>

              <ListItemButton
                  component={Link}
                  to="/home/chat" 
                  selected={selectedIndex === 1}
                  onClick={(event) => handleListItemClick(event, 1)}>
                  <ListItemIcon>
                    <SmartToyOutlinedIcon />
                  </ListItemIcon>
                  <ListItemText primary="AI Pet Assistant" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/weather" 
                selected={selectedIndex === 2}
                onClick={(event) => handleListItemClick(event, 2)}>
                  <ListItemIcon>
                    <ThermostatOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Weather" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/diairies" 
                selected={selectedIndex === 3}
                onClick={(event) => handleListItemClick(event, 3)}>
                  <ListItemIcon>
                    <BookOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Pet Diaries" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/product" 
                selected={selectedIndex === 4}
                onClick={(event) => handleListItemClick(event, 4)}>
                  <ListItemIcon>
                    <AssessmentOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Pet Product" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/expert" 
                selected={selectedIndex === 5}
                onClick={(event) => handleListItemClick(event, 5)}>
                  <ListItemIcon>
                    <ThreePOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Consult Expert" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/Calendar" 
                selected={selectedIndex === 6}
                onClick={(event) => handleListItemClick(event, 6)}>
                  <ListItemIcon>
                    <CalendarMonthOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Event Calendar" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/Adoption"
                selected={selectedIndex === 7}
                onClick={(event) => handleListItemClick(event, 7)}>
                  <ListItemIcon>
                    <FavoriteBorderOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Pet Adoption" />
              </ListItemButton>

              <ListItemButton 
                component={Link}
                to="/home/Rescue/1"
                selected={selectedIndex === 8}
                onClick={(event) => handleListItemClick(event, 8)} >
                  <ListItemIcon>
                    <LocalHospitalOutlinedIcon/>
                  </ListItemIcon>
                  <ListItemText primary="Rescue Animals" />
              </ListItemButton>
    
            </List>
          <Divider />
        </Box>
    
        );
    }
export default LeftBar;