import React from 'react';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import DateFnsUtils from '@date-io/date-fns';
import EventNoteIcon from '@material-ui/icons/EventNote';
import IconButton from '@material-ui/core/IconButton';
import Box from '@material-ui/core/Box';
import Task from './Task';
import { DateTimePicker, MuiPickersUtilsProvider } from '@material-ui/pickers';
import TaskService from '../api/TaskAPI';

class AddTaskDialog extends React.Component {
    constructor(props) {
        super(props);
        this.state = { 
            title: "",
            subTaskFields: [],
            // Subtasks is a map of index -> text
            subTasks: {},
            showDatePicker: false,
            selectedDate: new Date(),
        };
    }

    // Send the task data back to the Tasks component
    submitHandler = (event) => {
        event.preventDefault();
        var dueDate;
        this.state.showDatePicker ? dueDate = this.state.selectedDate : dueDate = null;
        // Create JSON to POST
        var taskJson = {
            title: this.state.title,
            subTasks: Object.values(this.state.subTasks),
            dueDate: dueDate
        };
        TaskService.postTask(taskJson)
            .then((taskId) => {
                // if we succesfully POSTed a task, lets grab its ID and render it
                var task = this.createTask(taskId, this.state.title, this.state.subTasks, dueDate);
                this.props.addTask(task);
            })
            .catch((error) => console.log(error));
    }

    // Create a Task component and return it
    createTask = (id, title, subTasks, dueDate) => {
        if (dueDate !== null) {
            const formattedDueDate = `${dueDate.toLocaleString('default', {month: 'long'})} ${dueDate.getDate()}`;
            return (<Task
                        key={id}
                        number={id} 
                        removeTask={this.props.removeTask}
                        title={title}
                        subTasks={subTasks}
                        dueDate={formattedDueDate}/>)
        } else {
            return (<Task 
                        key={id}
                        number={id}
                        removeTask={this.props.removeTask}
                        title={title}
                        subTasks={subTasks}/>)
        }
    }

    // Handles changes to title and subtask the fields 
    changeHandler = (event) => {
        this.setState({ 
            ...this.state,
            [event.target.name]: event.target.value, 
        });
    }

    // Handles selected date from date picker
    handleDateChange = (selectedDate) => {
        this.setState({
            selectedDate: selectedDate
        })
    }

    addSubTaskText = (event) => {
        this.setState({
            subTasks: {
                ...this.state.subTasks,
                [event.target.name]: event.target.value
            }
        })
    }

    addSubTaskField = () => {
        this.setState({
            subTaskFields: [
                ...this.state.subTaskFields,
                <TextField
                    key={this.state.subTaskFields.length}
                    name={`${this.state.subTaskFields.length}`}
                    margin="dense"
                    label="Sub Task"
                    onChange={this.addSubTaskText}
                    fullWidth
                    autoFocus
                />
            ]
        });
    }

    render() {
        return (
            <Box>
                <Dialog
                    open={true}
                    aria-labelledby="add-new-dialog"
                >
                    <form onSubmit={this.submitHandler}>
                        <DialogTitle>
                            Add New Task
                        </DialogTitle>
                        <DialogContent>
                            <DialogContentText>
                                <TextField
                                    name="title"
                                    margin="dense"
                                    label="Task Title"
                                    onChange={this.changeHandler}
                                    fullWidth
                                    autoFocus
                                />
                            </DialogContentText>
                            {this.state.subTaskFields}
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={() => this.addSubTaskField()} color="primary">ADD SUBTASK</Button>
                            <Button type="submit" color="primary">
                                Save
                            </Button>
                            <Button onClick={() => this.props.hideDialog()} color="primary">
                                Close
                            </Button>

                            <IconButton onClick={() => this.setState({showDatePicker: !this.state.showDatePicker})}>
                                <EventNoteIcon />
                            </IconButton>

                            {this.state.showDatePicker ? 
                                <MuiPickersUtilsProvider utils={DateFnsUtils}>     
                                    <DateTimePicker
                                        name="selectedDate"
                                        variant="inline"
                                        value={this.state.selectedDate}
                                        onChange={this.handleDateChange}
                                    />
                                </MuiPickersUtilsProvider> :
                                null
                            }
                        </DialogActions>
                    </form>
                </Dialog>
            </Box>
        )
    }
}

export default AddTaskDialog;
