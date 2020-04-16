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
        };
    }

    submitHandler = (event) => {
        event.preventDefault();
        this.props.addTask(this.state.title);
    }

    changeHandler = (event) => {
        this.setState({ title: event.target.value });
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
                                    autoFocus
                                    margin="dense"
                                    id="name"
                                    label="Task Title"
                                    onChange={this.changeHandler}
                                    fullWidth
                                />
                            </DialogContentText>
                        </DialogContent>
                        <DialogActions>
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

export default AddTaskDialog;
