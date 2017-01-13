package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Publication;

public interface DaoInterface {
	/**
	 * 
	 * @return a list containing all elements
	 */
	<X extends BaseEntity> List<X>  getAll();
	/**
	 * 
	 * @param param - a string representing a name/title of the object to search for 
	 * @return - an actual object that extends the BaseEntity
	 */
	<X extends BaseEntity> X getOne(String param);
	/**
	 * 
	 * @param e - the element to be inserted (it is an object which extends the BaseEntity class)
	 * @return - an actual object that extends the BaseEntity
	 */
	<X extends BaseEntity> X insert(X e);
	/**
	 * 
	 * @param e - the element to be updated (it is an object which extends the BaseEntity class)
	 */
	<X extends BaseEntity> void update(X e);
	/**
	 * 
	 * @param e - the element to be deleted (it is an object which extends the BaseEntity class)
	 */
	<X extends BaseEntity> void delete(X e);
	
}
