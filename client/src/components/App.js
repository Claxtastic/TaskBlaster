import React from 'react';
import Home from './Home';
import Tasks from './Tasks';
import Login from './Login';
import SignUp from './SignUp';
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
