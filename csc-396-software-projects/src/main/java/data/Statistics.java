package data;


/**
 * <p>Public view of a set of statistics.</p>
 *
 * <p>Statistics are mutable, but cannot be changed outside the package.</p>
 *
 * <p>This interface should not be implemented outside the package.</p>
 *
 * <p><code>equals</code> and <code>hashCode</code> delegate to the
 * underlying statistics object.</p>
 * @see TeamRoster
 */
public interface Statistics {
    /**
     * Returns the user.
     * <p><b>Invariant:</b> <code>user() != null</code>.</p>
     *
     * @return User      user
     */
    public User user();
    /**
     * Returns the id of current task that user is attempting.
     * Null if not working on any task.
     *
     * @return int    current task
     */
    public int currentTask();
    /**
     * Returns the number of tasks attempted by the user on the team roster.
     * Invariant: tasksAttempted() greater than or equal to 0.
     *
     * @return int    number of tasks attempted
     */
    public int tasksAttempted();
    /**
     * Returns the number of tasks completed by the user on the team roster.
     * Invariant: tasksCompleted() less than or equals to tasksAttempted().
     *
     * @return int    number of tasks completed
     */
    public int tasksCompleted();
    /**
     * Returns the tasks attempted divided by the tasks completed.
     * Invariant: completionPercentage() greater than or equal to 0.
     *
     * @return double  completion percentage - tasks attempted divided by tasks completed
     */
    public double completionPercentage();
    /**
     * Returns the total average user rating.
     * The sum of all ratings divided by the number of ratings.
     * Invariant: userRating() greater than or equal to 0.
     *
     * @return double  user rating - sum of ratings divided by number of ratings
     */
    public double userRating();
    /**
     * Returns the task blaster software rating based on total performance.
     * A combination of completion percentage and user rating.
     * Invariant: taskBlasterRating() greater than or equal to 0.
     *
     * @return double  task blaster rating - patented super secret algorithm
     */
    public double taskBlasterRating();
    /**
     *  Return a string representation of the object in the following format:
     * "user [currentTask, tasksAttempted, tasksCompleted, completionPercentage, userRating, taskBlasterRating]".
     * @return string  Statistics as a string
     */
    public String toString();
}