/**
 * 
 */
package edu.msg.library2common.service.rmi;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;

/**
 * Provides user related services
 * 
 * @author gallb,nagyz
 *
 */
public interface UserServiceRmi extends EntityServiceInterface<User> {
	public static final String RMI_NAME = "User";

	/**
	 * Searches for a user object by user name
	 * 
	 * Returns a User type object if found, null if not found
	 * 
	 * @param userName
	 *            - user name we are looking for
	 * @return User object belonging to the user name
	 * @throws ServiceException,RemoteException
	 */
	public User getByUsername(String userName) throws ServiceException,RemoteException;

	/**
	 * Searches for users by person names Returns list of user object found or
	 * empty list if nothing found.
	 * 
	 * @param name
	 *            - name of the person to search for
	 * @return List of user objects found by the given name
	 * @throws ServiceException,RemoteException
	 */
	public List<User> searchForUser(String name) throws ServiceException,RemoteException;

	/**
	 * Get's List<User> searched by user's name
	 * 
	 * @param serchString-String
	 *            as name
	 * @return List<User> if query succeed
	 * @throws ServiceException,RemoteException
	 */
	public List<User> searchByName(String serchString) throws ServiceException,RemoteException;

	/**
	 * Searches for a User object by id in the database
	 * 
	 * @param id-String
	 * @return User-if search query by id succeed
	 * @throws ServiceException,RemoteException
	 */
	public User searchById(String id) throws ServiceException,RemoteException;

}
