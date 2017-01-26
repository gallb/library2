package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;

public class AuthorManager implements RmiServiceManager<Author> {
	private AuthorServiceRmi authorServiceRmi;
	private RmiRegistry registry = new RmiRegistry();

	public AuthorManager() {
		authorServiceRmi = registry.getAuthorService();
	}

	@Override
	public List<Author> search(String serchString) throws RemoteException {
		return authorServiceRmi.serchByName(serchString); 
	}

}