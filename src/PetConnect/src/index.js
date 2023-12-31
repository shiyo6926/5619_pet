import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import MRouter from './router/index';
import { AuthProvider } from './AuthContext';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<AuthProvider>
  <MRouter></MRouter>,
  </AuthProvider>
);
//莫名其妙多出的逗号在MRouter这，为什么会这样
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
