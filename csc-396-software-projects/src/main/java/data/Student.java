/**
 * 
 */
package data;

/**
 * Student class with the lowest permissions
 * 
 * @author Stephen Kim
 *
 */
public class Student extends UserCommonCode implements User {

	/**
	 * Student constructor with name and password
	 */
	Student(String name, String password) {
		super(name, password);
	}


}
