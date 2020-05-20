package data;

/**
 * Implementation of Statistics interface.
 *
 * <p>This is a utility class for TeamRoster.  Fields are mutable and
 * package-private.</p>
 *
 * <p><b>Class Invariant:</b> No two instances may reference the same User.</p>
 *
 * @see Statistics
 */
final class StatisticsSet implements Statistics{

    User user;
    int currentTask;
    int tasksAttempted;
    int tasksCompleted;
    double completionPercentage;
    double userRating;
    int numRating;
    double taskBlasterRating;

    /**
     * StatisticsSet constructor
     */
    StatisticsSet(User u, int ct, int ta, int tc, double ur, int num) {
        this.user = u;
        this.currentTask = ct;
        this.tasksAttempted = ta;
        this.tasksCompleted = tc;
        this.completionPercentage = this.tasksAttempted/this.tasksCompleted;
        this.userRating = ur;
        this.numRating = num;
        this.taskBlasterRating = this.completionPercentage * this.userRating;
    }

    /**
     * Returns the user.
     * <p><b>Invariant:</b> <code>user() != null</code>.</p>
     *
     * @return User      user
     */
    @Override
    public User user() {
        return user;
    }

    /**
     * Returns the id of current task that user is attempting.
     * Null if not working on any task.
     *
     * @return int    current task
     */
    @Override
    public int currentTask() {
        return currentTask;
    }

    /**
     * Returns the number of tasks attempted by the user on the team roster.
     * Invariant: tasksAttempted() greater than or equal to 0.
     *
     * @return int    number of tasks attempted
     */
    @Override
    public int tasksAttempted() {
        return tasksAttempted;
    }

    /**
     * Returns the number of tasks completed by the user on the team roster.
     * Invariant: tasksCompleted() less than or equals to tasksAttempted().
     *
     * @return int    number of tasks completed
     */
    @Override
    public int tasksCompleted() {
        return tasksCompleted;
    }

    /**
     * Returns the tasks attempted divided by the tasks completed.
     * Invariant: completionPercentage() greater than or equal to 0.
     *
     * @return double  completion percentage - tasks attempted divided by tasks completed
     */
    @Override
    public double completionPercentage() {
        return completionPercentage;
    }

    /**
     * Returns the total average user rating.
     * The sum of all ratings divided by the number of ratings.
     * Invariant: userRating() greater than or equal to 0.
     *
     * @return double  user rating - sum of ratings divided by number of ratings
     */
    @Override
    public double userRating() {
        return userRating;
    }
    /**
     * Returns the total number of ratings.
     * Invariant: numRating() greater than 0 or less than 5.
     *
     * @return int  num rating - number of ratings
     */
    public int numRating() {
        return numRating;
    }
    /**
     * Returns the task blaster software rating based on total performance.
     * A combination of completion percentage and user rating.
     * Invariant: taskBlasterRating() greater than or equal to 0.
     *
     * @return double  task blaster rating - patented super secret algorithm
     */
    @Override
    public double taskBlasterRating() {
        return taskBlasterRating;
    }

    /**
     *  Return a string representation of the object in the following format:
     * "user [currentTask, tasksAttempted, tasksCompleted, completionPercentage, userRating, taskBlasterRating]".
     * @return string  Statistics as a string
     */
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(user);
        buffer.append(" [");
        buffer.append(currentTask);
        buffer.append(",");
        buffer.append(tasksAttempted);
        buffer.append(",");
        buffer.append(tasksCompleted);
        buffer.append(",");
        buffer.append(completionPercentage);
        buffer.append(",");
        buffer.append(userRating);
        buffer.append(",");
        buffer.append(taskBlasterRating);
        buffer.append("]");
        return buffer.toString();
    }

    /**
     * Compare this object's with parameter object's user.
     * @param that the Object to be compared.
     * @return true if this object is the same as the obj argument;
     * false otherwise.
     */
    public boolean equals(Object that) {
        return user.equals(((StatisticsSet)that).user());
    }

    /**
     * Return the hash code of the user for the StatisticsSet
     */
    public int hashCode() {
        return user.hashCode();
    }

    /**
     * Return a copy of the StatisticsSet
     * @return StatisticsSet copy of statisticsset
     */
    StatisticsSet copy() { return new StatisticsSet(user, currentTask, tasksAttempted, tasksCompleted, userRating, numRating);}
}
