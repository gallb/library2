/**
 * 
 */
package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2common.util.PropertyProvider;

/**
 * Provides user related services
 * 
 * @author gallb
 *
 */
public interface UserServiceRmi extends Remote{
	public static final String RMI_NAME = PropertyProvider.INSTANCE.getProperty("user.rmi_name");
	//public static final int RMI_PORT = 1099;

	/**
	 * Saves a new user.
	 * 
	 * @param user - Contains the data of the new user object will be saved.
	 * @return True if the user was saved, false if not.
	 * @throws RemoteException
	 */
	public boolean addNewUser (User user) throws RemoteException;
	
	/**
	 * Updates user data of a user.
	 * 
	 * @param user
	 *            - Contains the data of the object that  will be updated, 
	 *            if the password didn't change it must be left blank and the
	 *            old password will remain.
	 * @return True if the changes were saved, false if not.
	 * @throws RemoteException
	 */
	public boolean updateUserData (User user) throws RemoteException;
	
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
	 * Searches for a user by user identifier.
	 * 
	 * Returns a User type object if found, null if not found 
	 * @param userName - user name we are looking for
	 * @return User object belonging to the user name
	 * @throws RemoteException
	 */
	public User getByUserID (String userID) throws RemoteException;
	
	/**
	 * Delete user object.
	 * 
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public boolean deleteUser(String userID) throws RemoteException;
	
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
