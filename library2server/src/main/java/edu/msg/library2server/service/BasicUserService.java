/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;

/**
 * @author gallb
 *
 */
public class BasicUserService extends UnicastRemoteObject implements UserServiceRmi{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	public BasicUserService() throws RemoteException {
		super();
	}
	
	@Override
	public boolean addNewEntity(User entity) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		return userDao.insert(entity);
	}

	@Override
	public boolean updateEntity(User entity) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		return userDao.update(entity);
	}

	@Override
	public boolean deleteEntity(String entityID) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		return userDao.delete(entityID);
	}

	public User getByUsername(String userName) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		return userDao.getUserByUserName(userName);
	}

	public User getByUserID(String userID) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		return userDao.getById(userID);
	}

	public List<User> searchForUser(String name) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		return userDao.getByName(name);
	}	
}
