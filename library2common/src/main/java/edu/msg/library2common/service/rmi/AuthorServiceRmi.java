package edu.msg.library2common.service.rmi;
import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.Author;
/**
 * 
 * @author nagyz
 *
 */
public interface AuthorServiceRmi extends EntityServiceInterface<Author>{
	public static final String RMI_NAME = "Author";
	/**
	 * Searches for an author object by author name
	 * @param name-String
	 * @return Author object list belonging to author name
	 * @throws RemoteException
	 */
	public List<Author> serchByName(String name) throws RemoteException;
}
