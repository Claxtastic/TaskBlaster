package data;

/**
 * Class for redundant code between Student, Faculty, and Administrator
 *
 * @author Stephen Kim
 */

public class UserCommonCode implements User{

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
     * Override equals method, return true if equal
     */
    public boolean equals(Object that) {

        //If object is null, return null pointer exception

        //If object is compared with itself then true
        if (that == this) {
            return true;
        }
        //Check if object is an instance of Student,
        if (!(that instanceof Student)) {
            return false;
        }
        //Typecast object to Student to compare attributes
        UserCommonCode other = (UserCommonCode) that;
        //Compare attributes and return true if they are all the same
        return (this._name.equals(other._name)) && (this._password.equals(other._password));
    }
}
