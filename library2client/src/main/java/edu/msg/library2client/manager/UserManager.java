package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.UserServiceRmi;

public class UserManager implements RmiServiceManager<User>{
	private UserServiceRmi userServiceRmi;
	private RmiRegistry rmiRegistry = new RmiRegistry();
	
	public UserManager() {
		userServiceRmi = rmiRegistry.getUserService();
	}

	/**
	 * Get's List<User> searched by user's name
	 * 
	 * @param serchString-String as name
	 * @return List<User> if query succeed
	 * @throws RemoteException
	 */
	public List<User> searchByName(String serchString) throws RemoteException {
		return userServiceRmi.searchForUser(serchString);
	}
	
	/**
	 * Get's a List<User>
	 * 
	 * @return List<User> if query succeed
	 * @throws RemoteException
	 */
	@Override
	public List<User> search(String serchString) throws RemoteException {
		
		return userServiceRmi.searchByName(serchString);
	}
	
	/**
	 * Inserts a User object to database
	 * 
	 * @param u-User
	 * @return true-if insert query succeed
	 * @return false-if insert query didn't succeeded
	 * @throws RemoteException
	 */
	
	public boolean insert(User u) throws RemoteException {
		return userServiceRmi.insert(u);
	}
	/**
	 * Updates a User object in database
	 * 
	 * @param user-User
	 * @return true-if update query succeed
	 * @return false-if update query didn't succeeded
	 * @throws RemoteException
	 */
	
	public boolean update(User user) throws RemoteException {
		return userServiceRmi.update(user);
	}

	/**
	 * Deletes a User object from database
	 * 
	 * @param user-User
	 * @return true-if delete query succeed
	 * @return false-if delete query didn't succeeded
	 * @throws RemoteException
	 */
	
	public boolean delete(String id) throws RemoteException {
		return userServiceRmi.delete(id);
	}

	/**
	 * Searches for a User object by id in the database
	 * 
	 * @param id-String
	 * @return User-if search query by id succeed
	 * @throws RemoteException
	 */

	public User searchById(String id) throws RemoteException {
	return userServiceRmi.searchById(id);
	}

	/**
	 * Searches for a User object by userName in the database
	 * 
	 * @param user_name-String
	 * @return User-if search query by userName succeed
	 * @throws RemoteException
	 */
	
	public User searchByUserName(String user_name) throws RemoteException {
		return userServiceRmi.getByUsername(user_name);
	}
}
