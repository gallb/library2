package edu.msg.library2server.repository;

import edu.msg.library2server.repository.jdbc.JdbcDaoFactory;

public abstract class DaoFactory {
	public static DaoFactory getDaoFactory(){
		return new JdbcDaoFactory();
	}
	
public abstract UserDao getUserDao();
}
