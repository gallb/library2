package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2client.console.RmiRegistry;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
/**
 * 
 * @author kiska
 *
 */
public class PublicationManager implements RmiServiceManager<Publication>{
	private PublicationServiceRmi publicationServiceRmi;

	public PublicationManager() {
		publicationServiceRmi = new RmiRegistry().getPublicationservice();
	}

	@Override
	public List<Publication> search(String serchString) throws RemoteException {
		return publicationServiceRmi.searchForPublicationByTitle(serchString);	
	}
}
