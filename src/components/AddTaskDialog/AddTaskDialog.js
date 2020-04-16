import React from 'react';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Button from '@material-ui/core/Button';

class AddTaskDialog extends React.Component {
    constructor(props) {
        super(props);
        this.state = { open: true };
    }

    render() {
        return (
            <div>
                <Dialog
                    open={this.state.open}
                    aria-labelledby="add-new-dialog"
                >
                    <DialogTitle>
                        Add New Task
                    </DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            Click save to add a new task
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={() => this.props.addNewTask()} color="primary">
                            Save
                        </Button>
                        <Button onClick={() => this.props.hideDialog()} color="primary">
                            Close
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        )
    }
}

export default AddTaskDialog;
