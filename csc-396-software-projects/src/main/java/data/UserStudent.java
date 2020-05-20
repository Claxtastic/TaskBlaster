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
final class UserStudent extends UserCommonCode implements User {

	/**
	 * Student constructor with name and password
	 */
	UserStudent(String name, String password) {
		super(name, password);
	}


}
