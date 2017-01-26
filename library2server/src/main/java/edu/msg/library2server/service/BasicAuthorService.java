/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2server.repository.AuthorDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;

/**
 * @author nagys
 *
 */
public class BasicAuthorService extends UnicastRemoteObject implements AuthorServiceRmi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BasicAuthorService() throws RemoteException {
		super();
	}

	@Override
	public boolean addNewEntity(Author entity) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Author> searchForAuthor(String name) throws RemoteException {
		return null;
	}

}
