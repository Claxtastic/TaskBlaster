/**
 * 
 */
package data;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Class that includes all members of the team jbh
 * 
 * @author Stephen Kim
 *
 */
public class TeamRoster implements Team{

    /**
     * Return the number of team members.
     *
     * @return int size of roster
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Get the set of statistics for a given team member.
     *
     * @param user User object
     * @return Statistics  user object
     */
    @Override
    public Statistics get(User user) {
        return null;
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
        return null;
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
        return null;
    }
}
