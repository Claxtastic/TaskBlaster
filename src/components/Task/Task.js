import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import { withStyles } from '@material-ui/core/styles';
import { Checkbox } from '@material-ui/core';

const styles = theme => ({
    card: {
        minWidth: 275,
        margin: "5px 0",
    },
    cardTypography: {
        fontSize: "calc(4px + 2vmin)",
    }
});

class Task extends React.Component {
  constructor() {
    super();
    this.state = {
      checked: [],
    }
  }

  handleCheck = (index) => () => {
    const currentIndex = this.state.checked.indexOf(index);
    const newChecked = [...this.state.checked];

    if (currentIndex === -1) {
      newChecked.push(index);
    } else {
      newChecked.splice(currentIndex, 1);
    }

    this.setState({
      checked: newChecked
    });
  }

  render () {
    const { classes } = this.props;

    return (
      <Card className={classes.card}>
        <CardContent>
          <Typography className={classes.cardTypography}>
            {this.props.title}
          </Typography>
          {/* TODO: make this a list */}
          <List>
            {this.props.subTasks.map((subTask, index) => { 
              return (
                <ListItem 
                  key={index}
                  dense
                  button
                  onClick={this.handleCheck(index)}>
                    <ListItemIcon>
                      <Checkbox
                        edge="start"
                        checked={this.state.checked.indexOf(index) !== -1}
                        tabIndex={-1}
                        disableRipple
                      />
                    </ListItemIcon>
                    <ListItemText primary={subTask} />
                </ListItem>
              );
            })}
          </List>
        </CardContent>
        <CardActions>
          {/* Arrow function because we don't want the function to run when the Task component is created */}
          <Button size="small" onClick={() => this.props.removeTask(this.props.number)}>REMOVE</Button>
          <Button size="small" onClick={() => null}>DONE</Button>
        </CardActions>
      </Card>
    )}
}

export default withStyles(styles)(Task);
