import React from 'react';
import AddIcon from '@material-ui/icons/Add';
import Fab from '@material-ui/core/Fab';
import Box from '@material-ui/core/Box';
import AddTaskDialog from '../AddTaskDialog/AddTaskDialog';
import Typography from '@material-ui/core/Typography';
import TaskService from '../../service/TaskService';
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

    componentDidMount() {
        TaskService.getAllTasks(this.removeTask.bind(this))
            .then(taskComponents => {
                this.setState({
                    tasks: taskComponents
                })
            });
    }

    // Add a newly created task to the rendered list
    addTask(task) {
        this.setState({
            tasks: [
                ...this.state.tasks,
                task
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
            {/* TODO: Once POSTing is working, change the key to be the backend id of the task */}
            {this.state.showDialog ? <AddTaskDialog 
                                        taskKey={this.state.tasks.length}
                                        addTask={this.addTask.bind(this)} 
                                        removeTask={this.removeTask.bind(this)}
                                        hideDialog={this.hideDialog.bind(this)} /> 
                                    : null}
        </div>
        )
    }
}

export default withStyles(styles)(Tasks);
