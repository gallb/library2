package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.Publication;
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
		return publicationServiceRmi.searchForPublicationByTitle(serchString);	
	}

	@Override
	public boolean addNewEntity(Publication entity) throws ManagerException {
		return publicationServiceRmi.addNewEntity(entity);
	}

	@Override
	public boolean updateEntity(Publication entity) throws ManagerException {
		return publicationServiceRmi.updateEntity(entity);
	}

	@Override
	public boolean deleteEntity(String entityID) throws ManagerException {
		return publicationServiceRmi.deleteEntity(entityID);
	}
	
	
}
