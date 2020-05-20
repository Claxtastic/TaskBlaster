/**
 * 
 */
package data;

/**
 * Administrator class with full permissions
 * 
 * @author Stephen Kim
 */
public class Administrator extends UserCommonCode implements User {

	/**
	 * Student constructor with name and password
	 */
	Administrator (String name, String password) {
		super(name, password);
	}
	
}
