package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUserByName(String user_name);
	User insertUser(User user);	
	void updateUser(User user);
	void deleteUser(User user);
}
