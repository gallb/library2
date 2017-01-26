package edu.msg.library2server.business;

import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.jdbc.SqlHandlerException;
/**
 * 
 * @author nagyz
 *
 */
public class BasicUserBusiness implements UserServiceRmi{
	private UserDao userDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicUserBusiness.class);

	public BasicUserBusiness() throws RemoteException,BusinessLayerException {
		super();
	}
/**
 * Adds new user to database
 * @param entity-User
 * @return true
 * -if insert operation was successful
 * @return false
 * -if insert operation didn't executed
 */
	@Override
	public boolean addNewEntity(User entity) throws BusinessLayerException {
		boolean flag;
		try{
		userDao = DaoFactory.getDaoFactory().getUserDao();
		flag= userDao.insert(entity);
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return flag;
	}

	/**
	 * Updates a user in database
	 * @param entity-User
	 * @return true
	 * -if update operation was successful
	 * @return false
	 * -if update operation didn't executed
	 */
	@Override
	public boolean updateEntity(User entity) throws BusinessLayerException {
		boolean flag;
		try{
		userDao = DaoFactory.getDaoFactory().getUserDao();
		flag= userDao.update(entity);
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return flag;
	}

	/**
	 * Deletes a user in database by userId
	 * @param entityID-String
	 * @return true
	 * -if delete operation was successful
	 * @return false
	 * -if delete operation didn't executed
	 */
	@Override
	public boolean deleteEntity(String entityID) throws BusinessLayerException {
		boolean flag;
		try{
		userDao = DaoFactory.getDaoFactory().getUserDao();
		flag= userDao.delete(entityID);
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return flag;
	}
	/**
	 * Get's a user in database by userName
	 * @param userName-String
	 * @return User
	 * -if user search operation was successful
	 * @return false
	 * -if user search operation didn't executed
	 */
	
	public User getByUsername(String userName) throws BusinessLayerException {
		User user;
		try{
		userDao = DaoFactory.getDaoFactory().getUserDao();
		user=userDao.getUserByUserName(userName);
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
		
	}
	/**
	 * Get's a user in database by userID
	 * @param userID-String
	 * @return User
	 * -if user search operation by id was successful
	 * @return false
	 * -if user search operation by id didn't executed
	 */
	public User getByUserID(String userID) throws BusinessLayerException {	
		User user;
		try{
		userDao = DaoFactory.getDaoFactory().getUserDao();
		user=userDao.getById(userID);
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
	}

	/**
	 * Get's a List<User> in database by name
	 * @param name-String
	 * @return List<User>
	 * -if user search operation by name was successful
	 */
	public List<User> searchForUser(String name) throws BusinessLayerException {
		List<User> user;
		try{
		userDao = DaoFactory.getDaoFactory().getUserDao();
		user=userDao.getByName(name);
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicUserBusiness"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicUserBusiness"));
		}
		return user;
	}

}