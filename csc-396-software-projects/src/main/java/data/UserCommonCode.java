package data;

/**
 * Class for redundant code between Student, Faculty, and Administrator
 *
 * @author Stephen Kim
 */

abstract class UserCommonCode {

    String _name;
    String _password;

    UserCommonCode(String name, String password) {
        //If name or password is null, throw NullPointerException
        if (name == null || password == null) {
            throw new NullPointerException(("Name cannot be null"));
        }
        //If name or password is empty string, throw IllegalArgumentException
        if (name == "" || name == " " || password == "" || password == " ") {
            throw new IllegalArgumentException("Name cannot be empty string");
        }
        this._name = name;
        this._password = password;
    }

    /**
     * Return user's name
     * @return String username
     */
    public String getName() {
        return this._name;
    }

    /**
     * Set user's name
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * Return user's password
     * @return String password
     */
    public String getPassword() {
        return this._password;
    }

    /**
     * Set user's password
     */
    public void setPassword(String password) {
        this._password = password;
    }

    /**
     * Compare the attributes of this object with those of parameter object.
     * @param that the Object to be compared.
     * @return true if this object is the same as the obj argument;
     *  false otherwise.
     */
    public boolean equals(Object that) {

        //If object is null, return null pointer exception

        //If object is compared with itself then true
        if (that == this) {
            return true;
        }
        //Check if object is an instance of User,
        if (!(that instanceof User)) {
            return false;
        }
        //Typecast object to Student to compare attributes
        UserCommonCode other = (UserCommonCode) that;
        //Compare attributes and return true if they are all the same
        return (this._name.equals(other._name)) && (this._password.equals(other._password));
    }

    /**
     * Return a hash code value for this object
     */
    public int hashCode() {
        //Super secret hash code
        int result = 17;
        result = 37 * result + this._name.hashCode();
        result = 37 * result + this._password.hashCode();
        return result;
    }

    /**
     * Compares the attributes of this object with those of thatObject
     * @param thatObject the Object to be compared.
     * @return a negative integer, zero, or a positive integer as this
     *  object is less than, equal to, or greater thatObject.
     * @throws ClassCastException if thatObject has an incompatible type.
     */
    public int compareTo(Object thatObject) {

        User kid = (User) thatObject;

        //If thatObject is null and this is not null, throw a NullPointerException
        if (thatObject == null && this != null)
            throw new NullPointerException();
        //If thatObject is not an instance of Student, throw ClassCastException
        if (!(thatObject instanceof User))
            throw new ClassCastException("Object is incompatible type");

        // Compare name
        int nameDiff = this._name.compareTo(kid.getName());
        if (nameDiff != 0) return nameDiff;

        // Compare password
        int pwDiff = this._password.compareTo(kid.getPassword());
        if (pwDiff != 0) return pwDiff;

        return 0; //All fields are equal

    }

    /**
     * Return a string representation of the object in the following format:
     * <code>"username : password"</code>.
     */
    public String toString() {
        String student = String.format("%s : %s", this._name, this._password);
        return student.trim();
    }
}
