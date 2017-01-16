package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.Book;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.PublicationType;

/**
 * Provides publication related services
 * 
 * @author nagyz
 *
 */
public interface PublicationServiceRmi extends Remote {
	public static final String RMI_NAME = "Publication";

	/**
	 * Saves a new publication.
	 * 
	 * @param pub
	 *            - Contains the data of the new Publication object what will be
	 *            saved.
	 * @return True if the pub was saved, false if not.
	 * @throws RemoteException
	 */
	public boolean addNewPublication(Publication pub) throws RemoteException;

	/**
	 * Deletes Publication object.
	 * 
	 * @param pub
	 *            - Contains the data of the Publication object what will be
	 *            deleted.
	 * @return True if the pub was deleted, false if not.
	 * @throws RemoteException
	 */
	public boolean deletePublication(Publication pub) throws RemoteException;

	/**
	 * Updates publication data of a publication.
	 * 
	 * @param pub
	 *            - Contains the data of the Publication object what will be
	 *            updated.
	 * @return True if the pub was updated, false if not.
	 * @throws RemoteException
	 */
	public boolean updatePublication(Publication pub) throws RemoteException;

	/**
	 * Searches for publication object by publication type and title.
	 * 
	 * 
	 * @param type
	 *            - Contains the type of the Publication object what will be
	 *            needed to find.
	 * @param title
	 *            - Contains the title of the Publication object what will be
	 *            needed to find.
	 * @return Publication object.
	 * @throws RemoteException
	 */

	public Publication getPublicationByTitle(PublicationType type, String title) throws RemoteException;

	/**
	 * Searches for publication object by publication id.
	 * 
	 * 
	
	 * @param id
	 *            - Contains the id of the Publication object what will be
	 *            needed to find.
	 * @return Publication object.
	 * @throws RemoteException
	 */

	public Publication getPublicationById(String id) throws RemoteException;

	/**
	 * Searches for all publication list.
	 * 
	 * @return Publication list.
	 * @throws RemoteException
	 */

	public List<Publication> getall() throws RemoteException;

}
