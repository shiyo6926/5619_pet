import { useState, useEffect } from "react";
import {
  LocalizationProvider,
  PickersDay,
  StaticDatePicker,
} from "@mui/x-date-pickers";
import { AdapterDateFns } from "@mui/x-date-pickers/AdapterDateFns";
import { Badge } from "@mui/material";
import axios from 'axios';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';

export const Calendar = () => {
  const [value, setValue] = useState(new Date());
  const [highlightedDays, setHighlightedDays] = useState([]);
  const [dates, setDates] = useState([]);
  const [values, setValues] = useState([]);

  const [items, setItems] = useState([]);

  console.log('日历选择的value',value.getDate());

  const userId = localStorage.getItem('userId');
  const userIid = {
    userId: userId,
  };

  const instance = axios.create({
    baseURL: 'http://localhost:9090', // 后端的地址
  });

  useEffect(() => {

    // 创建一个异步函数来获取后端数据
    async function fetchData() {
      try {
        const response = await instance.post('/petdiary/get', userIid); // 替换为您的后端 API 的 URL
        const newData = response.data; // 根据您的数据结构进行调整
        console.log('New data C:', newData); // 检查新数据

        // 合并所有数组项到一个新数组
        const mergedItems = newData.reduce((accumulator, currentArray) => {
          return accumulator.concat(currentArray);
        }, []);

        setItems(mergedItems);
        const dates = mergedItems.map(item => item.date);
        setDates(dates);

        const highlightedDays = [];
        for (const date of dates) {
          // 跳过 null 值
          if (date === null) continue;

          // 使用 split 函数提取日期的每一天
          const parts = date.split('/');
          const day = parseInt(parts[2], 10); // 使用parseInt()将日期字符串转换为数字
          //试试能不能用日期筛选
          //const month =parseInt(parts[1], 10);
          //console.log('month', month);
          console.log('day', day);
          
          highlightedDays.push(day);
        }
        setHighlightedDays(highlightedDays);

        const values = mergedItems.map(item => item.value);
        setValues(values);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
    fetchData();

  }, []);


  return (
    <div>
      <Typography
        style={{ color: '#C932C3' }}
        variant="h3"
        fontWeight="bold"
        marginTop={5}>
        Event Calendar
      </Typography>
      <br></br>
      <LocalizationProvider dateAdapter={AdapterDateFns}>
        <StaticDatePicker
          orientation="portrait"
          //加了这个就只能显示这个月的，有bug，下个月照样
          //disableFuture
          value={value}
          onChange={(newValue) => setValue(newValue)}
          slots={{
            day: (props) => {
              const isSelected = !props.outsideCurrentMonth && highlightedDays.indexOf(props.day.getDate()) >= 0;

              return (
                <Badge
                  key={props.day.toString()}
                  overlap="circular"
                  badgeContent={isSelected ? "❕" : undefined}
                >
                  <PickersDay {...props} />
                </Badge>
              );
            },
          }}
        />
      </LocalizationProvider>
           <Box sx={{ margin: '0 auto', width: '100%', maxWidth: 700, bgcolor: 'background.paper' }}>
             {/* 根据选择的日期显示当天的ListItem */}
               <List>
                   {items.map((item) => (
                       <ListItem key={item.id} disablePadding>
                           <ListItemButton >
                               <ListItemText
                                   primary={item.value}
                                   secondary={item.date} />
                           </ListItemButton>
                       </ListItem>
                   ))}
               </List>
           </Box>
    </div>
  );
};

export default Calendar;