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
 * Provides user related services
 * 
 * @author gallb
 *
 */
public interface PublicationServiceRmi extends Remote{
	public static final String RMI_NAME = "Publication";
	//public static final int RMI_PORT = 1099;

	
	/**
	 * Searches for users by person names
	 * Returns list of user object found or empty list if nothing found.
	 * 
	 * @param name - name of the person to search for
	 * @return List of user objects found by the given name
	 * @throws RemoteException
	 */
	public List<Publication> searchForPublicationByTitle (String serchString) throws RemoteException;
	
}
