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
		//If name is null, throw NullPointerException
		if (name == null ) {
			throw new NullPointerException(("Name cannot be null"));
		}
		//If name is empty string, throw IllegalArgumentException
		if (name == "" || name == " ") {
			throw new IllegalArgumentException("Name cannot be empty string");
		}
		this._name = name;
		this._password = password;
	}

}
