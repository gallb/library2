package edu.msg.library2server.repository.jdbc;

import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;

public class JdbcDaoFactory extends DaoFactory {
	@Override
	public UserDao getUserDao() {
		return new JdbcUserDao();
	}
	

}
