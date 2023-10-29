import React, { Component, useState } from 'react';
import { Route, Redirect, Switch } from 'react-router-dom/cjs/react-router-dom.min';
import NavBar from '../../components/NavBar';
import LeftBar from '../../components/LeftBar';
import PropTypes from 'prop-types';
import Forum from './Forum/Forum';
import Chat from './Chat/chat';
import Weather from './Weather/Weather';
import Diaries from './Diaries/Diaries';
import Calendar from './Calendar/Calendar';
import Adoption from './Adoption/Adoption';
import Rescue from './Rescue/Rescue';
import RightBar from '../../components/RightBar/RightBar';

class homePage extends Component {
  // componentDidMount() {
  //   // 从本地存储中获取登录状态
  //   const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';

  //   // 如果未登录，重定向到登录页
  //   if (!isAuthenticated) {
  //     this.props.history.push('/SignIn');
  //   }
  // }

  render() {
    // 主页内容
    return (
      <div className="row">
      <NavBar />
        <div className='col-md-1'></div>
        <div className='col-md-2'>
        <LeftBar />
        </div>
        <div className='col-md-6'>
          <Switch>
            <Route path="/home/Forum" component={Forum}></Route>
            <Route path="/home/chat" component={Chat}></Route>
            <Route path="/home/weather" component={Weather}></Route>
            <Route path="/home/Diairies" component={Diaries}></Route>
            <Route path="/home/Calendar" component={Calendar}></Route>
            <Route path="/home/Adoption" component={Adoption}></Route>
            <Route path="/home/Rescue" component={Rescue}></Route>
            <Redirect from="/home" to="/home/Forum"></Redirect>
          </Switch>
        </div>
        <div className='col-md-2'>
          <RightBar />
        </div>
      </div>
    );
  }
}
// const homePage = props => {

//     return (
//       <div className="row">
//       <NavBar />
//         <div className='col-md-1'></div>
//         <div className='col-md-2'>
//         <LeftBar />
//         </div>
//         <div className='col-md-6'>
//           <Switch>
//             <Route path="/home/Forum" component={Forum}></Route>
//             <Route path="/home/chat" component={Chat}></Route>
//             <Route path="/home/notifications" component={Notification}></Route>
//             <Route path="/home/Diairies" component={Diaries}></Route>
//             <Route path="/home/Calendar" component={Calendar}></Route>
//             <Route path="/home/Adoption" component={Adoption}></Route>
//             <Redirect from="/home" to="/home/Forum"></Redirect>
//           </Switch>
//         </div>
//         <div className='col-md-3'></div>
//       </div>
//     );
// };


export default homePage;