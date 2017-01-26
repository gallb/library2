/**
 * 
 */
package edu.msg.library2server.business;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.Publication;

/**
 * @author gallb
 *
 */
public interface PublicationHandlerInterface extends BusinessInterface<Publication>{

	/**
	 * Returns a List<Publication> if search for publication by title was successful
	 * @param serchString-String
	 * @return List<Publication> - if publications where found for input title
	 * @throws BusinessLayerException
	 * @throws RemoteException
	 */
		public List<Publication> searchForPublicationByTitle(String serchString) throws BusinessLayerException;
}
