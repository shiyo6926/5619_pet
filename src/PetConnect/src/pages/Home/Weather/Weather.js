import React, { useState, useEffect } from "react";
import axios from 'axios';
import UmbrellaOutlinedIcon from '@mui/icons-material/UmbrellaOutlined';
import WaterDropOutlinedIcon from '@mui/icons-material/WaterDropOutlined';
import WbCloudyOutlinedIcon from '@mui/icons-material/WbCloudyOutlined';
import WbSunnyOutlinedIcon from '@mui/icons-material/WbSunnyOutlined';
import ThunderstormOutlinedIcon from '@mui/icons-material/ThunderstormOutlined';
import AirOutlinedIcon from '@mui/icons-material/AirOutlined';
import FormatAlignJustifyOutlinedIcon from '@mui/icons-material/FormatAlignJustifyOutlined';
import { Box, Typography } from '@mui/material';
import Stack from '@mui/material/Stack';
import { styled } from '@mui/material/styles';
import Paper from '@mui/material/Paper';

export default function Weather() {

  const [temperature, setTemperature] = useState();
  const [windSpeed, setWindSpeed] = useState();
  const [weatherClear, setWeatherClear] = useState();

  const instance = axios.create({
    baseURL: 'http://localhost:9090', // 后端的地址
});

  function getDogWalkingSuggestion(weatherClear) {
    if (weatherClear === "Rain" || weatherClear === "Fog" || weatherClear === "Thunderstorm" || weatherClear === "Drizzle" || weatherClear === "Mist" || weatherClear === "Haze" || windSpeed > 17 || temperature > 30 || temperature < 10) {
      return "Not suitable for walking dogs.";
    } else if (weatherClear === "Rain shower"){
      return "Watching a rainbow together with the dog.";
    }else {
      return "Suitable for dog walking.";
    }
  }
  const suggestion = getDogWalkingSuggestion(weatherClear);


  function getWeatherLogo(weatherClear) {

    if (weatherClear === "Rain") {
      return <div style={{ display: 'inline-block' }}><WaterDropOutlinedIcon style={{ fontSize: '18px' }} /><UmbrellaOutlinedIcon style={{ fontSize: '24px' }} /></div>;
    } else if (weatherClear === "Clouds") {
      return <WbCloudyOutlinedIcon style={{ fontSize: '24px' }} />;
    } else if (weatherClear === "Clear") {
      return <WbSunnyOutlinedIcon style={{ fontSize: '24px' }} />;
    } else if (weatherClear === "Mist" || weatherClear === "Fog" || weatherClear === "Haze") {
      return <div style={{ display: 'inline-block' }}><FormatAlignJustifyOutlinedIcon style={{ fontSize: '24px' }} /></div>;
    } else if (weatherClear === "Thunderstorm") {
      return <ThunderstormOutlinedIcon style={{ fontSize: '24px' }} />;
    } else if (weatherClear === "Rain shower") {
      return <div style={{ display: 'inline-block' }}><WbSunnyOutlinedIcon style={{ fontSize: '24px' }} /><WbCloudyOutlinedIcon style={{ fontSize: '24px' }} /><WaterDropOutlinedIcon style={{ fontSize: '18px' }} /></div>;
    } else {
      return;
    }
  }
  const weatherLogo = getWeatherLogo(weatherClear);


  function getWindSpeedSuggestion(windSpeed) {
    if (windSpeed > 17) {
      return "In case of high wind speeds, it is not advisable to go outside.";
    } else {
      return "The wind speed is suitable.";
    }
  }
  const windSpeedSuggestion = getWindSpeedSuggestion(windSpeed);

  function getTemperatureSuggestion(temperature) {
    if (temperature > 30) {
      return "Too hot.";
    } else if(temperature < 10){
      return "Too cold.";
    }else{
      return "The temperature is okay.";
    }
  }
  const temperatureSuggestion = getTemperatureSuggestion(temperature);

  const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  }));

useEffect(() => {
//   // 创建一个异步函数来获取后端数据
  async function fetchData() {            
      try {
          const response = await instance.get('/weather'); // 替换为您的后端 API 的 URL
          const temperature = response.data.temperature; // 根据您的数据结构进行调整
          const windSpeed = response.data.windSpeed;
          const weatherClear = response.data.weatherClear;
          setTemperature(temperature);
          setWindSpeed(windSpeed);
          setWeatherClear(weatherClear);
          // console.log('temperature:', temperature); // 检查新数据
          // console.log('windSpeed:', windSpeed);
          // console.log('weatherClear:', weatherClear);

      } catch (error) {
          console.error('Error fetching data:', error);
      }
  }

  fetchData();
}, []);



  return (
    <div className="row">
      <div className='col-md-6'>
        <Typography
          style={{ color: '#C932C3' }}
          variant="h3"
          fontWeight="bold"
          marginTop={5}>
          Weather
        </Typography>
        <br></br>
        <Box sx={{ width: '170%', display: 'flex' }} marginTop={2}>
        <Stack spacing={3}>
        <Item>
        <h3>Temperature: {temperature} ℃</h3>
        <h4>{temperatureSuggestion}</h4>
        </Item>
        <Item>
        <AirOutlinedIcon style={{ fontSize: '24px'}}/><h3 style={{ display: 'inline-block', padding: '10px'}}>Wind Speed: {windSpeed} m/s</h3>
        <h4>{windSpeedSuggestion}</h4>
        </Item>
        <Item>
        <h3>Weather: {weatherClear} {weatherLogo}</h3>
        <h4>Suggestion: {suggestion}</h4>
        </Item>
        </Stack>
        </Box>

      </div>
      <div className='col-md-3'>
      </div>
    </div>
  );
};

