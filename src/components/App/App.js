import React from 'react';
import Appbar from '../Appbar/Appbar';
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import { makeStyles } from '@material-ui/core/styles';
import logo from '../Images/logo.svg';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
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

const useStyles = makeStyles((theme) => ({
  content: {
    flewGrow: 1,
    padding: theme.spacing(8),
    backgroundColor: "#282c34",
    minHeight: "100vh",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    // justifyContent: "center",
  },
  card: {
    minWidth: 275,
    margin: "5px 0",
  },
  cardTypography: {
    fontSize: "calc(4px + 2vmin)",
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

function Tasks() {
  const classes = useStyles();

  return (
    <div className={classes.content}>
      <Appbar />
      <Card className={classes.card}>
        <CardContent>
          <Typography className={classes.cardTypography}>
            Example card
          </Typography>
        </CardContent>
      </Card>

      <Card className={classes.card}>
        <CardContent>
          <Typography className={classes.cardTypography}>
            Example card
          </Typography>
        </CardContent>
      </Card>
    </div>
  )
}

export default App;
