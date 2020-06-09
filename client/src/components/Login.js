import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import { CssBaseline } from '@material-ui/core';

const useStyles = makeStyles(theme => ({
    content: {
        padding: theme.spacing(10),
        backgroundColor: "#282c34",
        minHeight: "100vh",
        display: "flex",
        flexGrow: 1,
        flexDirection: "column",
        alignItems: "center",
    },
    typography: {
        color: "white"
    },
    field: {
        
    },
    submit: {
        margin: theme.spacing(3, 0, 2)
    },
    label: {
        color: "white"
    },
    controlLabel: {
        color: "white"
    }
}));

// TODO
const doLogin = () => {
    console.log("Logging in");
}

// TODO
const changeHandler = () => {
    console.log("Handle change");
}

function Login() {
    document.title = "Login | TaskBlaster"

    const classes = useStyles();
    return (
        <Box className={classes.content}>
            <CssBaseline />
            <Typography className={classes.typography} component="h1" variant="h5"> {document.title.split("|")[0]} </Typography>
            <form onSubmit={doLogin} noValidate>
                <TextField
                    className={classes.field}
                    InputLabelProps={{className: classes.label}}
                    name="email"
                    id="email"
                    label="Email Address"
                    margin="dense"
                    variant="outlined"
                    autoComplete="email"
                    onChange={changeHandler}
                    required
                    fullWidth
                    autoFocus />
                <TextField
                    className={classes.field}
                    InputLabelProps={{className: classes.label}}
                    name="password"
                    id="password"
                    label="Password"
                    margin="dense"
                    variant="outlined"
                    autoComplete="current-password"
                    onChange={changeHandler}
                    required
                    fullWidth />
                <FormControlLabel
                    className={classes.controlLabel}
                    control={<Checkbox value="remember" color="white" />}
                    label="Remember me"
                />
                <Button 
                    className={classes.submit}
                    type="submit"
                    variant="contained"
                    color="primary"
                    fullWidth
                >
                    Sign In
                </Button>
            </form>
        </Box>
    )
}

export default Login;
