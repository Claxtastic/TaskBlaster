/**
 * 
 */
package data;

/**
 * Student class with the lowest permissions
 * 
 * @author Team6
 *
 */
public class Student implements User {

	//Create variables
	private final String _name;
	private final String _password;

	//Student constructor with name and password
	Student(String name, String password) {
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

}
