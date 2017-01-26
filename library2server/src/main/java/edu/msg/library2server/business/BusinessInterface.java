/**
 * 
 */
package edu.msg.library2server.business;

import java.rmi.RemoteException;

import edu.msg.library2common.model.BaseEntity;

/**
 * @author gallb
 *
 */
public interface BusinessInterface<X extends BaseEntity> {
	/**
	 * Saves a new Entity.
	 * 
	 * @param entity - Contains the data of the new entity which will be saved.
	 * @return True if saved, false if not.
	 * @throws BusinessLayerException
	 */
	public boolean addNewEntity (X entity) throws BusinessLayerException;
	
	/**
	 * Updates data of an Entity.
	 * 
	 * @param entity - Contains the data of the object that  will be updated
	 * @return True if the changes were saved, false if not.
	 * @throws BusinessLayerException
	 */
	public boolean updateEntity (X entity) throws BusinessLayerException;
			
	/**
	 * Delete entity.
	 * 
	 * @param entity
	 * @return true if deleted, false if not
	 * @throws BusinessLayerException
	 */
	public boolean deleteEntity(String entityID) throws BusinessLayerException;
}
