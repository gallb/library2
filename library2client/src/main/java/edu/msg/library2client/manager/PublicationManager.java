package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
/**
 * 
 * @author gallb
 *
 */
public class PublicationManager implements RmiServiceManager<Publication>{
	private PublicationServiceRmi publicationServiceRmi;
	private RmiRegistry rmiRegistry = new RmiRegistry();
	
	public PublicationManager() {
		publicationServiceRmi = rmiRegistry.getPublicationservice();
	}

	@Override
	public List<Publication> search(String serchString) throws ManagerException {
		try {
			return publicationServiceRmi.searchForPublicationByTitle(serchString);
		} catch (RemoteException e) {
			throw new ManagerException("client.service.error");
		} catch (ServiceException e) {
			throw new ManagerException("client.error");
		}
	}

	@Override
	public boolean addNewEntity(Publication entity) throws ManagerException {
		try {
			return publicationServiceRmi.addNewEntity(entity);
		} catch (RemoteException e) {
			throw new ManagerException("client.service.error");
		} catch (ServiceException e) {
			throw new ManagerException("client.error");
		}
	}

	@Override
	public boolean updateEntity(Publication entity) throws ManagerException {
		try {
			return publicationServiceRmi.updateEntity(entity);
		} catch (RemoteException e) {
			throw new ManagerException("client.service.error");
		} catch (ServiceException e) {
			throw new ManagerException("client.error");
		}
	}

	@Override
		public boolean deleteEntity(String entityID) throws ManagerException {
			try {
				return publicationServiceRmi.deleteEntity(entityID);
			} catch (RemoteException e) {
				throw new ManagerException("client.service.error");
			} catch (ServiceException e) {
				throw new ManagerException("client.error");
		}
	}	
}
