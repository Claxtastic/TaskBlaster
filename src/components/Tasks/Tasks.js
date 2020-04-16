import React from 'react';
import Appbar from '../Appbar/Appbar';
import AddIcon from '@material-ui/icons/Add';
import Fab from '@material-ui/core/Fab';
import Box from '@material-ui/core/Box';
import Task from '../Task/Task';
import AddTaskDialog from '../AddTaskDialog/AddTaskDialog';
import Typography from '@material-ui/core/Typography';
import { withStyles, withTheme } from '@material-ui/core/styles';

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
    tasks: {
        display: "flex",
        flexDirection: "column",
        position: "fixed",
        left: 60,
        height: "inherit",
        overflow: "auto"
    },
    typography: {
        color: "white",
        fontSize: "calc(4px + 2vmin)",
        alignItems: "center",
    }
});

class Tasks extends React.Component {
    constructor() {
        super();
        this.state = { 
            tasks: [],
            showDialog: false
        }
        this.removeTask = this.removeTask.bind(this);
    }

    // Create a Task component and add it to the list of tasks
    addTask(title, subTasks) {
        this.setState({
            tasks: [
                ...this.state.tasks,
                <Task 
                    key={this.state.tasks.length} 
                    number={this.state.tasks.length}
                    removeTask={this.removeTask}
                    title={title}
                    subTasks={subTasks}
                />
            ]
        });
        this.hideDialog();
    }

    removeTask(key) {
        this.setState({
            tasks:
                this.state.tasks.filter(task => task.props.number !== key)
        })
    }

    showDialog() {
        this.setState({
            showDialog: true
        });
    }

    hideDialog() {
        this.setState({
            showDialog: false
        });
    }

    render () {
      const { classes } = this.props;

      return (
        <div className={classes.content}>
            <Appbar />
            {this.state.tasks.length === 0 ? 
                    <Typography className={classes.typography}>There are no tasks to show!</Typography> 
                    : null}
            {/* Container for the tasks */}
            <Box className={classes.tasks}>
                {this.state.tasks.map(task => task)}
            </Box>
            <Fab 
                className={classes.fab}
                color="secondary" 
                aria-label="add task" 
                onClick={() => this.showDialog()}
            >
                <AddIcon />
            </Fab>
            {/* Bind hideDialog to this Tasks reference, otherwise the close button on the dialog will be NPE */}
            {this.state.showDialog ? <AddTaskDialog addTask={this.addTask.bind(this)} hideDialog={this.hideDialog.bind(this)} /> : null}
        </div>
        )
    }
}

export default withStyles(styles)(Tasks);
