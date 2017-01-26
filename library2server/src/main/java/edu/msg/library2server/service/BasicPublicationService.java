package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BasicPublicationBusiness;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.hibernate.HibernateDaoFactory;

/**
 * 
 * @author nagyz
 *
 */
public class BasicPublicationService extends UnicastRemoteObject implements PublicationServiceRmi {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicPublicationService.class);
	private BasicPublicationBusiness basicPubBis;

	private static final long serialVersionUID = 1L;

	public BasicPublicationService() throws RemoteException {
		super();
	}
	
	/**
	 * Returns a List<Publication> if search for publication by title was successful
	 * @param serchString-String
	 * @return List<Publication> - if publications where found for input title
	 * @throws ServiceLayerException
	 * @throws RemoteException
	 */
	public List<Publication> searchForPublicationByTitle(String serchString) throws ServiceException, RemoteException {
		List<Publication> listPub;
		try {
			listPub = basicPubBis.searchForPublicationByTitle(serchString);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicPublicationService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicPublicationService"));
		}
		return listPub;
	}

	@Override

	public boolean addNewEntity(Publication entity) throws RemoteException, ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Publication entity) throws RemoteException, ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) throws RemoteException, ServiceException {
		// TODO Auto-generated method stub
		return false;
	}
}
