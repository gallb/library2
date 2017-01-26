package edu.msg.library2server.repository;

import edu.msg.library2server.repository.hibernate.HibernateDaoFactory;
import edu.msg.library2server.repository.jdbc.JdbcDaoFactory;

public abstract class DaoFactory {
	public static DaoFactory getDaoFactory(){
		return new JdbcDaoFactory();
	}
	
	public static DaoFactory getHibernateDaoFactory(){
		return new HibernateDaoFactory();
	}
	
public abstract UserDao getUserDao();

public abstract PublicationDao getPublicationDao();

public abstract BorrowDAO getBorrowDao();

public abstract AuthorDAO getAuthorDao();

public abstract PublisherDAO getpublisherDao();
}
