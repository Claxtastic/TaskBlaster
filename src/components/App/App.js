import React from 'react';
import Home from '../Home/Home';
import Tasks from '../Tasks/Tasks';
import Login from '../Login/Login';
import SignUp from '../SignUp/SignUp';
import { Route, Switch } from 'react-router-dom';

function App() {
  return (
    <Switch>
      <Route exact path="/">
        <Home />
      </Route>
      <Route exact path="/tasks">
        <Tasks />
      </Route>
      <Route exact path="/login">
        <Login />
      </Route>
      <Route exact path="/signup">
        <SignUp />
      </Route>
    </Switch>
  );
}

export default App;
