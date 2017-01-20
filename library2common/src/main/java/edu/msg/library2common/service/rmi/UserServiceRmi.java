/**
 * 
 */
package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.User;

/**
 * Provides user related services
 * 
 * @author gallb
 *
 */
public interface UserServiceRmi extends EntityServiceInterface<User>{
	public static final String RMI_NAME = "User";
	
	/**
	 * Searches for a user object by user name
	 * 
	 * Returns a User type object if found, null if not found 
	 * @param userName - user name we are looking for
	 * @return User object belonging to the user name
	 * @throws RemoteException
	 */
	public User getByUsername (String userName) throws RemoteException;

	
	/**
	 * Searches for users by person names
	 * Returns list of user object found or empty list if nothing found.
	 * 
	 * @param name - name of the person to search for
	 * @return List of user objects found by the given name
	 * @throws RemoteException
	 */
	public List<User> searchForUser (String name) throws RemoteException;
	
}
