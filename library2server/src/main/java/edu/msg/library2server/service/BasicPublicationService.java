package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.hibernate.HibernateDaoFactory;

public class BasicPublicationService extends UnicastRemoteObject implements PublicationServiceRmi {

	public BasicPublicationService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Publication> searchForPublicationByTitle(String serchString) throws RemoteException {

		PublicationDao pubDAO  = DaoFactory.getHibernateDaoFactory().getPublicationDao();
		return pubDAO.searchPublications(serchString);
	}
}
