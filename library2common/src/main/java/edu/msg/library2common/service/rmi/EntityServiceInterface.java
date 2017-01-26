package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.ServiceLayerException;

public interface EntityServiceInterface<X extends BaseEntity> extends Remote{
	
	/**
	 * Saves a new Entity.
	 * 
	 * @param entity - Contains the data of the new entity which will be saved.
	 * @return True if saved, false if not.
	 * @throws RemoteException
	 */
	public boolean addNewEntity (X entity) throws RemoteException, ServiceException;
	
	/**
	 * Updates data of an Entity.
	 * 
	 * @param entity - Contains the data of the object that  will be updated
	 * @return True if the changes were saved, false if not.
	 * @throws RemoteException
	 */
	public boolean updateEntity (X entity) throws RemoteException, ServiceException;
			
	/**
	 * Delete entity.
	 * 
	 * @param entity
	 * @return true if deleted, false if not
	 * @throws RemoteException
	 */
	public boolean deleteEntity(String entityID) throws RemoteException, ServiceException;
}