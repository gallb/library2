package edu.msg.library2server.repository;

import java.util.List;

import edu.msg.library2common.model.User;

public interface UserDao {
	List<User> getAllUsers();
	boolean verifyUser(String user,String psw);
	User insertUser(User user);	
	void updateUser(User user);
	void deleteUser(User user);
}
