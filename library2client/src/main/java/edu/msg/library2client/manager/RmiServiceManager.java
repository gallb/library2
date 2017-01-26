package edu.msg.library2client.manager;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.directory.SearchControls;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Publication;
/**
 * 
 * @author kiska, gallb
 *
 * @param <X> - any object that extends BaseEntity.
 * Can be a User, Publication, Borrow object
 */
public interface RmiServiceManager <X extends BaseEntity>{
	
	List<X> search(String serchString) throws ManagerException;
	
	boolean addNewEntity (X entity) throws ManagerException;
	
	boolean updateEntity (X entity) throws ManagerException;
	
	boolean deleteEntity(String entityID) throws ManagerException;
}
