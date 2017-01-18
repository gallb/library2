package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.BaseEntity;

public interface DaoInterface<X extends BaseEntity> {
	/**
	 * 
	 * @return a list containing all elements Can return null if no elements
	 *         were found
	 */
	List<X> getAll();

	/**
	 * Returns a list of BaseEntity sub-type objects, that match the name or
	 * title given by the {@link param}} Can return null if no matches were
	 * found
	 * 
	 * @param param
	 *            - a string representing a name/title of the object to search
	 *            for
	 * @return - an actual object that extends the BaseEntity
	 */
	List<X> getByName(String param);

	/**
	 * Inserts the element given by {@link e}} Returns the object that was
	 * inserted Can return null in case of failed insertion or if the insertion
	 * object is already there
	 * 
	 * @param e
	 *            - the element to be inserted (it is an object which extends
	 *            the BaseEntity class)
	 * @return - true if successful, false otherwise
	 */
	boolean insert(X e);

	/**
	 * Updates the element given by {@link e}}
	 * 
	 * @param e
	 *            - the element to be updated (it is an object which extends the
	 *            BaseEntity class)
	 * @return - true if successful, false otherwise
	 */
	boolean update(X e);

	/**
	 * Deletes the element given by {@link e}}
	 * 
	 * @param e
	 *            - the element to be deleted (it is an object which extends the
	 *            BaseEntity class)
	 * @return - true if successful, false otherwise
	 */
	boolean delete(String id);

	/**
	 * Returns an object searched by {@link id}
	 * 
	 * @param id
	 *            - the id that represents the object to search for
	 * @return - an actual object that extends the BaseEntity
	 */
	X getById(String id);

}
