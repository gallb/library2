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
	 * @throws 
	 */
	public boolean addNewEntity (X entity);
	
	/**
	 * Updates data of an Entity.
	 * 
	 * @param entity - Contains the data of the object that  will be updated
	 * @return True if the changes were saved, false if not.
	 * @throws 
	 */
	public boolean updateEntity (X entity);
			
	/**
	 * Delete entity.
	 * 
	 * @param entity
	 * @return true if deleted, false if not
	 * @throws 
	 */
	public boolean deleteEntity(String entityID);
}
