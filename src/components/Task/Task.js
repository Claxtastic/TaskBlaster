import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemSecondaryAction from '@material-ui/core/ListItemSecondaryAction';
import ListItemText from '@material-ui/core/ListItemText';
import { withStyles } from '@material-ui/core/styles';

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
    render () {
      const { classes } = this.props;
      console.log(this.props.subTasks);
  
      return (
        <Card className={classes.card}>
          <CardContent>
            <Typography className={classes.cardTypography}>
              {this.props.title}
            </Typography>
            {/* TODO: make this a list */}
            <List className="subTasks">
              {this.props.subTasks.map(subTask => subTask)}
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
