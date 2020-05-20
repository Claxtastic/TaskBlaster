/**
 * 
 */
package data;

/**
 * Administrator class with full permissions
 * 
 * @author Stephen Kim
 */
final class UserAdministrator extends UserCommonCode implements User {

	/**
	 * Student constructor with name and password
	 */
	UserAdministrator (String name, String password) {
		super(name, password);
	}
	
}
