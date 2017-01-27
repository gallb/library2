/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BasicUserBusiness;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.repository.UserDao;

/**
 * @author gallb,nagyz
 *
 */
public class BasicUserService extends UnicastRemoteObject implements UserServiceRmi {

	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	private BasicUserBusiness basicUser;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicUserService.class);

	public BasicUserService() throws RemoteException,ServiceException {
		super();
	}

	/**
	 * Adds new user to database
	 * 
	 * @param entity-User
	 * @return true -if insert operation was successful
	 * @return false -if insert operation didn't executed
	 */
	@Override
	public boolean addNewEntity(User entity) throws ServiceException, RemoteException {
		boolean flag = false;
		try {
			basicUser = new BasicUserBusiness();
			flag = basicUser.addNewEntity(entity);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return flag;
	}

	/**
	 * Updates a user in database
	 * 
	 * @param entity-User
	 * @return true -if update operation was successful
	 * @return false -if update operation didn't executed
	 */
	@Override
	public boolean updateEntity(User entity) throws ServiceException, RemoteException {
		boolean flag = false;
		try {
			basicUser = new BasicUserBusiness();
			flag = basicUser.updateEntity(entity);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return flag;
	}

	/**
	 * Deletes a user in database by userId
	 * 
	 * @param entityID-String
	 * @return true -if delete operation was successful
	 * @return false -if delete operation didn't executed
	 */
	@Override
	public boolean deleteEntity(String entityID) throws ServiceException, RemoteException {
		boolean flag = false;
		try {
			basicUser = new BasicUserBusiness();
			flag = basicUser.deleteEntity(entityID);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return flag;
	}

	/**
	 * Get's a user in database by userName
	 * 
	 * @param userName-String
	 * @return User -if user search operation was successful
	 * @return false -if user search operation didn't executed
	 */
	public User getByUsername(String userName) throws ServiceException, RemoteException {
		User user;
		try {
			basicUser = new BasicUserBusiness();
			user = basicUser.getUserByUserName(userName);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
	}

	/**
	 * Get's a user in database by userID
	 * 
	 * @param userID-String
	 * @return User -if user search operation by id was successful
	 * @return false -if user search operation by id didn't executed
	 */
	public User searchById(String userID) throws ServiceException, RemoteException {
		User user;
		try {
			basicUser = new BasicUserBusiness();
			user = basicUser.getById(userID);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
	}

	/**
	 * Get's a List<User> in database by name
	 * 
	 * @param name-String
	 * @return List<User> -if user search operation by name was successful
	 */
	public List<User> searchByName(String name) throws ServiceException, RemoteException {
		List<User> user;
		try {
			basicUser = new BasicUserBusiness();
			user = basicUser.searchForUsers(name);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
	}

	

	/**
	 * Get's a List<User> in database by name
	 * 
	 * @param name-String
	 * @return List<User> -if user search operation by name was successful
	 */
	@Override
	public List<User> searchForUser(String name) throws ServiceException, RemoteException {
		List<User> user;
		try {
			basicUser = new BasicUserBusiness();
			user = basicUser.searchForUsers(name);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
	}

	@Override
	public List<User> searchByName(String serchString) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User u) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User searchById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
