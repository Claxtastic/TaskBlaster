/**
 * 
 */
package data;

import java.util.*;

/**
 * Class that includes all members of the team.
 * Implementation of Team interface.
 * @author Stephen Kim
 * @see Data
 */
final class TeamRoster implements Team{

    private Map<User, Statistics> _data;

    /**
     * TeamRoster constructor
     */
    TeamRoster() {
        _data = new HashMap<User, Statistics>();
    }

    /**
     * If <code>Statistics</code> is null, then delete Statistics for <code>User</code>;
     * otherwise replace Statistics for <code>User</code>.
     *
     * @param user     user
     * @param stats    statistics
     */
    void replaceEntry(User user, Statistics stats) {
        _data.remove(user);
        if (stats != null)
            _data.put(user,((StatisticsSet)stats).copy());
    }

    /**
     * Overwrite the map.
     *
     * @param data inventory map
     */
    void replaceMap(Map<User, Statistics> data) {
        _data = data;
    }

    /**
     * Return the number of team members.
     *
     * @return int size of roster
     */
    @Override
    public int size() {
        return _data.size();
    }

    /**
     * Get the set of statistics for a given team member.
     *
     * @param user User object
     * @return Statistics  user object
     */
    @Override
    public Statistics get(User user) {
        return _data.get(user);
    }

    /**
     * Return an iterator over team members in the roster.
     * <p>The iterator returns objects that implement the Statistics interface.</p>
     * <p>The set of statistics are unordered.</p>
     *
     * @return Iterator   iterator for roster
     */
    @Override
    public Iterator<Statistics> iterator() {
        return Collections.unmodifiableCollection(_data.values()).iterator();
    }

    /**
     * Return an iterator over the roster, sorted according the
     * Comparator.
     * <p>The iterator returns objects that implement the
     * <code>Statistics</code> interface.</p>
     * <p>The iteration order is determined by the comparator (least first).</p>
     * <p>The comparator may assume that its arguments implement
     * <code>Statistics</code>.</p>
     *
     * @param comparator determines the order of the set of statistics returned.
     * @return Iterator    sorted iterator for team roster
     */
    @Override
    public Iterator<Statistics> iterator(Comparator<Statistics> comparator) {
        //Create list of statistics
        List<Statistics> s = new ArrayList<Statistics>(_data.values());
        //Sort list of statistics using comparator
        s.sort(comparator);
        return Collections.unmodifiableCollection(s).iterator();
    }

    /**
     * Start a new task.
     * If a user is not already present in the team roster (and taskID is valid)
     * a new StatisticsSet is created.
     * If a StatisticsSet is already present (and taskID isn't already in use),
     * set current task with task id, add 1 to the number of tasks attempted, and adjust completion percentage
     * as well as taskblasterrating.
     * @param user    user
     * @param taskID  ID of task
     * @throws NullPointerException if user is null
     * @throws IllegalArgumentException if taskID is 0 or negative
     */
    public void startTask(User user, int taskID) {
        // If user is null, throw NullPointerException
        if (user == null) {
            throw new NullPointerException("User cannot be null");
        }
        // If taskID is 0 or below, throw IllegalArgumentException
        if (taskID < 1) {
            throw new IllegalArgumentException("TaskID cannot be 0 or negative number");
        }
        // If team roster does not contain user, create new StatisticsSet
        if (!this._data.containsKey(user)) {
            StatisticsSet newStats = new StatisticsSet(user, taskID, 1, 0, 0.0, 0);
            this._data.put(user, newStats);
        }
        // If team roster contains user and taskID is already in use, throw IllegalArgumentException
        if (this._data.containsKey(user) && this._data.get(user).currentTask() == taskID) {
            throw new IllegalArgumentException("TaskID is already in use");
        }
        // If team roster contains user and taskID is not in use, update taskID, add 1 to attempted
        // task, update completion percentage, and update taskblaster rating
        if (this._data.containsKey(user)) {
            int attempts = this._data.get(user).tasksAttempted() + 1;
            int completed = this._data.get(user).tasksCompleted();
            double userRating = this._data.get(user).userRating();
            int numRating = this._data.get(user).numRating();
            StatisticsSet s = new StatisticsSet(user, taskID, attempts, completed, userRating, numRating);
            _data.replace(user, s);
        }

    }

    /**
     * Complete a task.
     * Remove the task being attempted, update completed tasks, update
     * @param user user completing task
     * @throws Exception if task is not being attempted
     */
    public void completeTask(User user) throws Exception {
        // If the current task id is 0 (no task being attempted)
        if (_data.get(user).currentTask() == 0) {
            throw new Exception("There is no task currently being attempted");
        } else {
            // If taskID is current task, complete task and update StatisticsSet
            int attempts = _data.get(user).tasksAttempted();
            int completed = _data.get(user).tasksCompleted() + 1;
            double rating = _data.get(user).userRating();
            int numRating = _data.get(user).numRating();
            StatisticsSet s = new StatisticsSet(user, 0, attempts, completed, rating, numRating);
            _data.replace(user, s);
        }
    }

    /**
     * Add new rating to user.
     * Update total rating and update taskblasterrating.
     * @param user user to change rating
     * @param rating new rating
     * @throws IllegalArgumentException if rating is below 0 or above 5
     */
    public void addNewRating(User user, double rating) {

        // If rating is below 0 or above 5, throw IllegalArgumentException
        if (rating > 5 || rating < 0) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        // Change user rating and taskblaster rating
        int attempts = _data.get(user).tasksAttempted();
        int completed = _data.get(user).tasksCompleted() + 1;
        int nr = _data.get(user).numRating() + 1;
        double ur = (_data.get(user).userRating() + rating)/nr;
        StatisticsSet s = new StatisticsSet(user, 0, attempts, completed, ur, nr);
        _data.replace(user, s);

    }


    /**
     * Remove all Statistics from the team roster.
     * @postcondition <code>size() == 0</code>
     */
    public void clear() {
        //Clear data from old map
        _data.clear();
    }

    /**
     * Return a string representation of the team roster.
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Database:\n");
        Iterator i = _data.values().iterator();
        while (i.hasNext()) {
            buffer.append("  ");
            buffer.append(i.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
