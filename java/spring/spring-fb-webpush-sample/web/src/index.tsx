import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import firebase from 'firebase';

const firebaseConfig = {
  apiKey: "AIzaSyBMcrD2iLG2kB_OAp4S-tjVfJOH4RbMjzE",
  authDomain: "test-push-app-5adb2.firebaseapp.com",
  projectId: "test-push-app-5adb2",
  storageBucket: "test-push-app-5adb2.appspot.com",
  messagingSenderId: "485081917445",
  appId: "1:485081917445:web:f6d1f71ee76b7349b2546c"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
