import React from 'react';
import ReactDOM from 'react-dom';
import * as serviceWorker from './serviceWorker';
import './index.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import App from './components/App/App';
import Appbar from './components/Appbar/Appbar';
import Tasks from './components/Tasks/Tasks';
import Login from './components/Login/Login';

ReactDOM.render(
  <BrowserRouter>
    {/* Appbar shows above whatever the component is, chosen by Switch */}
    <Appbar />
    <App />
  </BrowserRouter>,
  document.getElementById('root')
);


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
