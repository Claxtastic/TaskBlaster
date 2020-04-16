import React from 'react';
import Appbar from '../Appbar/Appbar';
import AddIcon from '@material-ui/icons/Add';
import Fab from '@material-ui/core/Fab';
import Box from '@material-ui/core/Box';
import Task from '../Task/Task';
import { withStyles } from '@material-ui/core/styles';

const styles = theme => ({
    content: {
        padding: theme.spacing(10),
        backgroundColor: "#282c34",
        minHeight: "100vh",
        display: "flex",
        flexGrow: 1,
        flexDirection: "column",
        alignItems: "center",
    },
    fab: {
        right: 60,
        bottom: 60,
        position: "fixed",
    },
    children: {
        display: "flex",
        flexDirection: "column",
        position: "fixed",
        left: 60,
        height: "inherit",
        overflow: "auto"
    }
});

class Tasks extends React.Component {
    constructor() {
        super();

        this.state = {
            children: []
        }

        this.removeChild = this.removeChild.bind(this);
    }

    appendChild() {
        this.setState({
            children: [
                ...this.state.children,
                <Task 
                    key={this.state.children.length} 
                    number={this.state.children.length}
                    removeChild={this.removeChild}
                />
            ]
        });
    }

    removeChild(key) {
        this.setState({
            children:
                this.state.children.filter(child => child.props.number !== key)
        })
    }

    render () {
      const { classes } = this.props;

      return (
        <div className={classes.content}>
            <Appbar />
            {/* Container for the tasks */}
            <Box className={classes.children}>
                {this.state.children.map(child => child)}
            </Box>
            <Fab 
                className={classes.fab}
                color="secondary" 
                aria-label="add task" 
                onClick={() => this.appendChild()}
            >
                <AddIcon />
            </Fab>
        </div>
        )
    }
}

export default withStyles(styles)(Tasks);
