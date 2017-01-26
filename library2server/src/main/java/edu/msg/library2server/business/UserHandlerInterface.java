package edu.msg.library2server.business;

import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2server.repository.DataAccessException;
/**
 * 
 * @author nagyz
 *
 */
public interface UserHandlerInterface extends BusinessInterface<User>{
	/**
	 * Gets a new User list from Data access layer
	 * 
	 * @return List<User>-if one ore more user data exist in database
	 * @throws BusinessLayerException
	 */
	public List<User> getAll() throws BusinessLayerException;	
	/**
	 * Gets a new User list from Data access layer, searched by Name
	 * 
	 * @return List<User>-if one ore more user data exist in database
	 * @throws BusinessLayerException
	 */
	public List<User> searchForUsers(String param) throws BusinessLayerException;
	/**
	 * Gets a new User object from Data access layer, searched by id
	 * 
	 * @return User-if one user matches in database
	 * @throws BusinessLayerException
	 */
	public User getById(String id) throws BusinessLayerException;
	/**
	 * Gets a new User object from Data access layer, searched by userName
	 * 
	 * @return User-if one user matches in database
	 * @throws BusinessLayerException
	 */
	public User getUserByUserName(String user_name) throws BusinessLayerException;
}
