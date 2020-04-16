import React from 'react';
import Appbar from '../Appbar/Appbar';
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import logo from '../Images/logo.svg';
import Tasks from '../Tasks/Tasks';
import './App.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route exact path="/tasks">
            <Tasks />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

function Home() {
  return (
    <div className="App">
      <Appbar />
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        Home
      </header>
    </div>
  );
}

export default App;
