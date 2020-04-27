import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { CssBaseline } from '@material-ui/core';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Link from '@material-ui/core/Link';
import Login from '../Login/Login';
import FormControlLabel from '@material-ui/core/FormControlLabel';

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
const doSignUp = () => {
    console.log("Signed up user");
}

// TODO
const changeHandler = () => {
    console.log("Handle change");
}

function SignUp() {
    const classes = useStyles();
    return (
        <Box className={classes.content}>
            <CssBaseline />
            <Typography className={classes.typography} component="h1" variant="h5">
                Sign up
            </Typography>
            <form onSubmit={doSignUp} noValidate>
                <Grid container spacing={2}>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            className={classes.field}
                            InputLabelProps={{className: classes.label}}
                            name="firstName"
                            id="firstName"
                            label="First Name"
                            margin="dense"
                            variant="outlined"
                            autoComplete="fname"
                            onChange={changeHandler}
                            required
                            fullWidth
                            autoFocus />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            className={classes.field}
                            InputLabelProps={{className: classes.label}}
                            name="lastName"
                            id="lastName"
                            label="Last Name"
                            margin="dense"
                            variant="outlined"
                            autoComplete="lname"
                            required
                            fullWidth />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            className={classes.field}
                            InputLabelProps={{className: classes.label}}
                            name="email"
                            id="email"
                            label="Email Address"
                            margin="dense"
                            variant="outlined"
                            autoComplete="email"
                            required
                            fullWidth />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField 
                            className={classes.field}
                            InputLabelProps={{className: classes.label}}
                            name="password"
                            id="password"
                            label="Password"
                            margin="dense"
                            variant="outlined"
                            required
                            fullWidth />
                    </Grid>
                    <Button
                        className={classes.submit}
                        type="submit"
                        variant="contained"
                        color="primary"
                        fullWidth
                    >
                        Sign Up
                    </Button>
                    <Grid container justify="flex-end">
                        <Grid item>
                            <Link to="/login" variant="body2">
                                Already have an account? Sign in
                            </Link>
                        </Grid>
                    </Grid>
                </Grid>
            </form>
        </Box>
    )
}

export default SignUp;
