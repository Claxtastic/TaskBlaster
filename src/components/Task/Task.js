import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
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
  
      return (
        <Card className={classes.card}>
          <CardContent>
            <Typography className={classes.cardTypography}>
              {this.props.value}
            </Typography>
          </CardContent>
          <CardActions>
              {/* Arrow function because we don't want the function to run when the Task component is created */}
              <Button size="small" onClick={() => this.props.removeTask(this.props.number)}>REMOVE</Button>
          </CardActions>
        </Card>
      )}
}

export default withStyles(styles)(Task);
