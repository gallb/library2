package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.UserServiceRmi;

public class UserManager implements RmiServiceManager<User> {
	private UserServiceRmi userServiceRmi;
	private RmiRegistry rmiRegistry = new RmiRegistry();

	public UserManager() {
		userServiceRmi = rmiRegistry.getUserService();
	}

	/**
	 * Get's User searched by user's name
	 * 
	 * @param serchString-String
	 *            as name
	 * @return User if query succeed
	 * @throws ManagerException
	 */
	public User searchByName(String serchString) throws ManagerException {
		try {
			return userServiceRmi.getByUsername(serchString);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}
	}

	/**
	 * Get's a List<User>
	 * 
	 * @return List<User> if query succeed
	 * @throws ManagerException
	 */
	@Override
	public List<User> search(String serchString) throws ManagerException {
		try {
			return userServiceRmi.searchByName(serchString);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}
	}

	/**
	 * Inserts a User object to database
	 * 
	 * @param u-User
	 * @return true-if insert query succeed
	 * @return false-if insert query didn't succeeded
	 * @throws ManagerException
	 */

	@Override
	public boolean addNewEntity(User entity) throws ManagerException {
		try {
			return userServiceRmi.insert(entity);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}
	}

	/**
	 * Updates a User object in database
	 * 
	 * @param user-User
	 * @return true-if update query succeed
	 * @return false-if update query didn't succeeded
	 * @throws ManagerException
	 */

	@Override
	public boolean updateEntity(User entity) throws ManagerException {
		try {
			return userServiceRmi.update(entity);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}
	}

	/**
	 * Deletes a User object from database
	 * 
	 * @param user-User
	 * @return true-if delete query succeed
	 * @return false-if delete query didn't succeeded
	 * @throws ManagerException
	 */

	@Override
	public boolean deleteEntity(String entityID) throws ManagerException {
		try {
			return userServiceRmi.delete(entityID);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}
	}

	/**
	 * Searches for a User object by id in the database
	 * 
	 * @param id-String
	 * @return User-if search query by id succeed
	 * @throws ManagerException
	 */

	public User searchById(String id) throws ManagerException {

		try {
			return userServiceRmi.searchById(id);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}

	}

	/**
	 * Searches for a User object by userName in the database
	 * 
	 * @param user_name-String
	 * @return User-if search query by userName succeed
	 * @throws ManagerException
	 */

	public User searchByUserName(String user_name) throws ManagerException {

		try {
			return userServiceRmi.getByUsername(user_name);
		} catch (RemoteException e) {
			throw new ManagerException("Error! Communication with server faild.");
		} catch (ServiceException e) {
			throw new ManagerException("Error! Server internal error.");
		}
	}

}
