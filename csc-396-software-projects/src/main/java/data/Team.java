/**
 * 
 */
package data;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Interface for a team
 * A collection of StatisticSets.
 * StatisticSets can only be created and destroyed using the Team
 * @author Stephen Kim
 * @see Data
 */
public interface Team {

    /**
     *  Return the number of team members.
     *
     *  @return int size of roster
     */
    public int size();

    /**
     *  Get the set of statistics for a given team member.
     *
     *  @param user     User object
     *  @return Statistics  user object
     */
    public Statistics get(User user);

    /**
     *  Return an iterator over team members in the roster.
     *  <p>The iterator returns objects that implement the Statistics interface.</p>
     *  <p>The set of statistics are unordered.</p>
     *
     *  @return Iterator   iterator for roster
     */
    public Iterator<Statistics> iterator();

    /**
     *  Return an iterator over the roster, sorted according the
     *  Comparator.
     *  <p>The iterator returns objects that implement the
     *  <code>Statistics</code> interface.</p>
     *  <p>The iteration order is determined by the comparator (least first).</p>
     *  <p>The comparator may assume that its arguments implement
     *  <code>Statistics</code>.</p>
     *  @param comparator determines the order of the set of statistics returned.
     *
     *  @return Iterator    sorted iterator for team roster
     */
    public Iterator<Statistics> iterator(Comparator<Statistics> comparator);

    /**
     * Returns the team roster as a string; one set of statistics per line.
     */
    public String toString();

}
