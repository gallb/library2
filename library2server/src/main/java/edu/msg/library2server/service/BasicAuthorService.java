package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;
/**
 * 
 * @author nagyz
 *
 */
public class BasicAuthorService extends UnicastRemoteObject implements AuthorServiceRmi {

	protected BasicAuthorService() throws  ServiceLayerException,RemoteException {
		super();
	}

	@Override
	public boolean addNewEntity(Author entity) throws ServiceLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) throws  ServiceLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws  ServiceLayerException,RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Author> serchByName(String name) throws  ServiceLayerException,RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
