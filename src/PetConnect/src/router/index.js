import React, { Component, useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect} from "react-router-dom"
import Home from '../pages/Home/homePage';
import SignUp from '../pages/SignUp/SignUp';
import SignIn from '../pages/SignIn/SignIn';
import { AuthProvider } from '../AuthContext';
import axios from 'axios';


//自定义路由守卫
const PrivateRoute = ({ component: Component, isAuthenticated, ...rest }) => (
    <Route
      {...rest}
      render={(props) =>
        isAuthenticated ? (
          <Component {...props} />
        ) : (
          <Redirect to="/SignIn" />
        )
      }
    />
);

const userId = localStorage.getItem('userId');
console.log('路由的userId:', userId);

class index extends Component {

    //这边要默认true，如果是false那么后端传来true也会刷走
    //这边true后端传false也进不了主页
    constructor(props) {
        super(props);
        this.state = {
          isAuthenticated: true,
        };
      }

      // componentDidMount() {
      //   // 从 localStorage 中获取 isAuthenticated 状态
      //   const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';
      //   this.setState({ isAuthenticated });
      // }
    
      // componentDidUpdate(prevProps, prevState) {
      //   // 在 componentDidUpdate 中检查 isAuthenticated 的变化
      //   if (prevState.isAuthenticated !== this.state.isAuthenticated) {
      //     // 如果 isAuthenticated 变化了，你可以在这里执行相应的操作
      //   }
      // }
      
      // async componentDidMount() {
      //   // 使用 Axios 来获取后端数据
      //   try {
      //     const response = await axios.get('http://10.19.149.51:9090/log_state_check'); // 替换为实际的后端接口地址
      //     const { reason } = response.data.userState;
      //     console.log('路由的:', reason);
    
      //     if (reason === 1) {
      //       // 如果后端返回 'true'，表示用户已认证
      //       this.setState({ isAuthenticated: true });
      //     } else {
      //       // 否则用户未认证
      //       this.setState({ isAuthenticated: false });
      //     }
      //   } catch (error) {
      //     console.error('Error fetching data from the backend:', error);
      //   }
      // }

      async componentDidMount() {
        try {
          // 创建一个包含可选的 userId 字段的请求数据
          const requestData = {};
      
          // 如果 userId 存在，添加到请求数据中
          if (userId) {
            requestData.userId = userId;
          }else{
            requestData.userId = '';
          }

          console.log('路由的requestData:', requestData);
      
          // 使用 Axios 发送 POST 请求
          const response = await axios.post('http://localhost:9090/log_state_check', requestData);
          console.log('路由的后端返回:', response.data);
          
          //const reason  = response.data;
          if (response.data === 1) {
            // 如果后端返回 'true'，表示用户已认证
            this.setState({ isAuthenticated: true });
            console.log('路由的后端返回1:', response.data);
          } else {
            // 否则用户未认证
            this.setState({ isAuthenticated: false });
            console.log('路由的后端返回其他:', response.data);
          }
        } catch (error) {
          console.error('Error fetching data from the backend:', error);
        }
      }


    render() {

        return (
            <Router>
              <AuthProvider>
                <Switch>
                    {/* <Route path="/home" component={Home}></Route> */}
                    <Route path="/SignUp" component={SignUp}></Route>
                    <Route path="/SignIn" component={SignIn}></Route>

                    <PrivateRoute
                        path="/home"
                        component={Home}
                        isAuthenticated={this.state.isAuthenticated}
                    ></PrivateRoute>

                    <Redirect from="/" to="/SignIn"></Redirect>
                </Switch>
                </AuthProvider>
            </Router>
        );
    }
}

export default index;