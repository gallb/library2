/**
 * 
 */
package edu.msg.library2common.service.rmi;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.model.User;

/**
 * @author nagys
 *
 */
public interface AuthorServiceRmi extends EntityServiceInterface<Author>{
	public static final String RMI_NAME = "Author";
	
	public List<Author> searchForUser (String name) throws RemoteException;
	
	

}
