import React from 'react';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Button from '@material-ui/core/Button';
import { TextField } from '@material-ui/core';

class AddTaskDialog extends React.Component {
    constructor(props) {
        super(props);
        this.state = { 
            title: "",
            subTaskFields: [],
            subTasks: []
        };
    }

    // Send the task title and list of subtasks back to the Tasks component
    submitHandler = (event) => {
        event.preventDefault();
        this.props.addTask(this.state.title, this.state.subTasks);
    }

    // Handles changes to ANY of the fields (title or subtask)
    changeHandler = (event) => {
        console.log(event.target.value)
        console.log(event.target.name)
        this.setState({ 
            ...this.state,
            [event.target.name]: event.target.value, 
        });
    }

    addSubTaskText = (event) => {
        this.setState({
            subTasks: [
                ...this.state.subTasks,
                event.target.value
            ]
        })
    }

    addSubTaskField = (event) => {
        this.setState({
            subTaskFields: [
                ...this.state.subTaskFields,
                <TextField
                    name="subTaskField"
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
            <div>
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
                            <div classname="subTasks">
                                {this.state.subTaskFields}
                            </div>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={() => this.addSubTaskField()} color="primary">ADD SUBTASK</Button>
                            <Button type="submit" color="primary">
                                Save
                            </Button>
                            <Button onClick={() => this.props.hideDialog()} color="primary">
                                Close
                            </Button>
                        </DialogActions>
                    </form>
                </Dialog>
            </div>
        )
    }
}

function SubTask() {
    return (null
    )
}

export default AddTaskDialog;
