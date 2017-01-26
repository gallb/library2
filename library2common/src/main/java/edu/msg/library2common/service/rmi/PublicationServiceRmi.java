/**
 * 
 */
package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

/**
 * Provides publication related services
 * 
 * @author gallb
 *
 */
public interface PublicationServiceRmi extends EntityServiceInterface<Publication>{
	public static final String RMI_NAME = "Publication";
	
	/**
	 * Searches for publications by title
	 * Returns list of publication objects found or empty list if nothing found.
	 * 
	 * @param serchString - string to search for 
	 * @return List of publication objects found by the given string
	 * @throws RemoteException
	 */
	public List<Publication> searchForPublicationByTitle (String serchString) throws RemoteException;
	
}
