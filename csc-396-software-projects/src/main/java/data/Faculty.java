/**
 * 
 */
package data;

/**
 * Faculty class has more permissions than the student but less than administrator 
 * 
 * @author Stephen Kim
 *
 */
public class Faculty extends UserCommonCode implements User {

	/**
	 * Student constructor with name and password
	 */
	Faculty (String name, String password) {
		super(name, password);
	}
	
}
