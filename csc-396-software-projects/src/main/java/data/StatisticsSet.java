package data;

public class StatisticsSet implements Statistics{

    StatisticsSet() {

    }

    /**
     * Returns the user.
     * <p><b>Invariant:</b> <code>user() != null</code>.</p>
     *
     * @return User      user
     */
    @Override
    public User user() {
        return null;
    }

    /**
     * Returns the number of tasks attempted by the user on the team roster.
     * Invariant: tasksAttempted() greater than or equal to 0.
     *
     * @return int    number of tasks attempted
     */
    @Override
    public int tasksAttempted() {
        return 0;
    }

    /**
     * Returns the number of tasks completed by the user on the team roster.
     * Invariant: tasksCompleted() less than or equals to tasksAttempted().
     *
     * @return int    number of tasks completed
     */
    @Override
    public int tasksCompleted() {
        return 0;
    }

    /**
     * Returns the tasks attempted divided by the tasks completed.
     * Invariant: completionPercentage() greater than or equal to 0.
     *
     * @return double  completion percentage - tasks attempted divided by tasks completed
     */
    @Override
    public double completionPercentage() {
        return 0;
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
        return 0;
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
        return 0;
    }
}
