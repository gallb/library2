/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

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
	
	protected BasicUserService() throws RemoteException {
	}
	
	public boolean addNewUser(User user) throws RemoteException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		userDao.insert(user);
		return false;
	}

	public boolean updateUserData(User user) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public User getByUsername(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public User getByUserID(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(String userID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> searchForUser(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
