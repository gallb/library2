package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.BaseEntity;

public interface DaoInterface {
	/**
	 * 
	 * @return a list containing all elements
	 * Can return null if no elements were found
	 */
	<X extends BaseEntity> List<X>  getAll();
	
	/**
	 * Returns a BaseENtity sub-type object, that matches the name or title 
	 * given by the {@link e}}
	 * Can return null if no matches were found
	 * @param param - a string representing a name/title of the object to search for 
	 * @return - an actual object that extends the BaseEntity
	 */
	<X extends BaseEntity> X getOne(String param);
	
	/**
	 * Inserts the element given by {@link e}}
	 * Returns the object that was inserted
	 * Can return null in case of failed insertion or if the insertion object is already there
	 * @param e - the element to be inserted (it is an object which extends the BaseEntity class)
	 * @return - an actual object that extends the BaseEntity
	 */
	<X extends BaseEntity> X insert(X e);
	
	/**
	 * Updates the element given by {@link e}}
	 * @param e - the element to be updated (it is an object which extends the BaseEntity class)
	 */
	<X extends BaseEntity> void update(X e);
	
	/**
	 * Deletes the element given by {@link e}}
	 * @param e - the element to be deleted (it is an object which extends the BaseEntity class)
	 */
	<X extends BaseEntity> void delete(X e);
	
}
