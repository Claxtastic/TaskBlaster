import React from 'react';
import Appbar from '../Appbar/Appbar';
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import { makeStyles } from '@material-ui/core/styles';
import logo from '../Images/logo.svg';
import './App.css';

function App() {
  return (
    <BrowserRouter className="App">
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path="/other">
          <Other />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

const useStyles = makeStyles((theme) => ({
  content: {
    flewGrow: 1,
    padding: theme.spacing(3),
  }
}));

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

function Other() {
  const classes = useStyles();

  return (
    <div className={classes.content}>
      <Appbar />
      <h2>Test</h2>
      <h2>Test</h2>
      <h2>Test</h2>
    </div>
  )
}

export default App;
