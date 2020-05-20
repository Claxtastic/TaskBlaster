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
final class UserFaculty extends UserCommonCode implements User {

	/**
	 * Student constructor with name and password
	 */
	UserFaculty (String name, String password) {
		super(name, password);
	}
	
}
