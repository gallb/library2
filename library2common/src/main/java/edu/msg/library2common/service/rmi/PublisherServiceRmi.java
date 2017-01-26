package edu.msg.library2common.service.rmi;

import java.rmi.RemoteException;
import java.util.List;

import edu.msg.library2common.model.Publisher;
import edu.msg.library2common.service.ServiceException;

/**
 * 
 * @author nagyz
 *
 */
public interface PublisherServiceRmi extends EntityServiceInterface<Publisher> {

	public static final String RMI_NAME = "Publisher";

	/**
	 * Searches for a publisher object by publisher name
	 * 
	 * @param name-String
	 * @return Publisher object list belonging to Publisher name
	 * @throws RemoteException
	 */
	public List<Publisher> serchByName(String name) throws RemoteException, ServiceException;
}
