package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.PublicationType;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.hibernate.HibernatePublicationDao;

public class BasicPublicationService extends UnicastRemoteObject implements PublicationServiceRmi {
	private static final long serialVersionUID = 1L;

	
	private DaoFactory publicationInHiperlink;
	
	private PublicationDao publicationDAO;

	protected BasicPublicationService() throws RemoteException {
		super();
	}

	public boolean addNewPublication(Publication pub) throws RemoteException {
		publicationDAO = (PublicationDao) DaoFactory.getDaoFactory().getPublicationDao();
		return publicationDAO.insert(pub);
	}

	public boolean deletePublication(Publication pub) throws RemoteException {
		publicationDAO = (PublicationDao) DaoFactory.getDaoFactory().getPublicationDao();
		return publicationDAO.delete(pub.getUuid());
	}

	public boolean updatePublication(Publication pub) throws RemoteException {
		publicationDAO = (PublicationDao) DaoFactory.getDaoFactory().getPublicationDao();
		return publicationDAO.update(pub);
	}

//	public Publication getPublicationByTitle(PublicationType type, String title) throws RemoteException {
//		publicationDAO = (PublicationDao) DaoFactory.getDaoFactory().getPublicationDao();
//		return Publication.getSerialversionuid();
//	}

	public Publication getPublicationById(String id) throws RemoteException {
		publicationDAO = (PublicationDao) DaoFactory.getDaoFactory().getPublicationDao();
		return publicationDAO.getById(id);
	}

//	public List<Publication> getall() throws RemoteException {
//		publicationInHiperlink = DaoFactory.getDaoFactory();
//		return publicationInHiperlink.listPublications();
//	}

	public Publication getPublicationByTitle(PublicationType type, String title) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

public List<Publication> getall() throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

	
	
//	public List<Publication> searchPublicationByTitle(String title) throws RemoteException {		
//		return null;
//	}
	
	
}
