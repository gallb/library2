package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;

public class AuthorManager implements RmiServiceManager<Author> {
	private AuthorServiceRmi authorServiceRmi;
	private RmiRegistry registry = new RmiRegistry();

	public AuthorManager() {
		authorServiceRmi = registry.getAuthorService();
	}

	@Override
	public List<Author> search(String serchString) throws ManagerException {
		List<Author> authors = new ArrayList<>();
		try {
			authors = authorServiceRmi.serchByName(serchString);
		} catch (ServiceException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.service.error"));
		} catch (RemoteException e) {
			throw new ManagerException(ClientPropertyProvider.getProperty("client.error"));
		}
		return authors;
	}

	@Override
	public boolean addNewEntity(Author entity) throws ManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) throws ManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws ManagerException {
		// TODO Auto-generated method stub
		return false;
	}

}
