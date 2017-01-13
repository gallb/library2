package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.User;

public interface UserDao extends DaoInterface{
	/**
	 * 
	 * @param user_name - the user_name to search for
	 * @return - the user requested by the {@param}
	 */
	User getUserByUserName(String user_name);
}
