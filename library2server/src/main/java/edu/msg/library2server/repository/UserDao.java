package edu.msg.library2server.repository;

import edu.msg.library2common.model.User;

public interface UserDao extends DaoInterface<User> {
	/**
	 * Returns a User that was searched by the user_name Can return null if no
	 * match was found
	 * 
	 * @param user_name
	 *            - the user_name to search for
	 * @return - the user requested by the {@link user_name}}
	 */
	User getUserByUserName(String user_name);
}
