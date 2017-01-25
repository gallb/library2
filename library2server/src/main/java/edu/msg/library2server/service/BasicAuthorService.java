/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.UserServiceRmi;

/**
 * @author nagys
 *
 */
public class BasicAuthorService extends UnicastRemoteObject implements UserServiceRmi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BasicAuthorService() throws RemoteException {
		super();
	}

	@Override
	public boolean addNewEntity(User entity) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(User entity) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getByUsername(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchForUser(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
