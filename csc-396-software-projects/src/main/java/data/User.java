package data;

/**
 * Interface for all users of the program
 * 
 * @author Stephen Kim
 *
 */
public interface User {

    /**
     * Return user's name
     * @return String username
     */
    public String getName();

    /**
     * Set user's name
     */
    public void setName(String name);

    /**
     * Return user's password
     * @return String password
     */
    public String getPassword();

    /**
     * Set user's password
     */
    public void setPassword(String password);

    /**
     * Compare the attributes of this object with those of parameter object.
     * @param thatObject the Object to be compared.
     * @return true if this object is the same as the obj argument;
     *  false otherwise.
     */
    public boolean equals(Object thatObject);

    /**
     * Return a hash code value for this object using the algorithm from Bloch:
     * fields are added in the following order: title, year, director.
     */
    public int hashCode();

    /**
     * Compares the attributes of this object with those of thatObject
     * @param thatObject the Object to be compared.
     * @return a negative integer, zero, or a positive integer as this
     *  object is less than, equal to, or greater thatObject.
     * @throws ClassCastException if thatObject has an incompatible type.
     */
    public int compareTo(Object thatObject);

    /**
     * Return a string representation of the object in the following format:
     * <code>"username : password"</code>.
     */
    public String toString();
}
