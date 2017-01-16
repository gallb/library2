package edu.msg.library2server.repository;

import edu.msg.library2server.repository.hibernate.HibernateDaoFactory;

public abstract class DaoFactory {
	public static DaoFactory getDaoFactory(){
		return new HibernateDaoFactory(); //
//		return new JdbcDaoFactory(); //
	}
	
public abstract DaoInterface getUserDao();

public abstract DaoInterface getPublicationDao();


}
