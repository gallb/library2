package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.AuthorHandlerInterface;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.businesslogic.AuthorHandler;

/**
 * 
 * @author nagyz
 *
 */
public class BasicAuthorService extends UnicastRemoteObject implements AuthorServiceRmi {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthorService.class);
	private AuthorHandlerInterface authorHandlerInterface;

	public BasicAuthorService() throws RemoteException {
		super();
		authorHandlerInterface = new AuthorHandler();
	}

	@Override
	public boolean addNewEntity(Author entity) throws ServiceException, RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) throws ServiceException, RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws ServiceException, RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Author> serchByName(String name) throws ServiceException, RemoteException {
		List<Author> authors = new ArrayList<>();
		try {
			authors = authorHandlerInterface.getByName(name);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicAuthorService"));
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error_BasicAuthorService"));
		}
		return authors;
	}

}
