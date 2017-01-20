package edu.msg.library2server.repository.hibernate;

import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.jdbc.JdbcBorrowDAO;
import edu.msg.library2server.repository.jdbc.JdbcUserDao;

public class HibernateDaoFactory extends DaoFactory {

	@Override
	public UserDao getUserDao() { // should be hibernateUserDAO
		return new HibernateUserDAO();
	}

	@Override
	public PublicationDao getPublicationDao() {
		return new HibernatePublicationDAO();
	}

	@Override
	public BorrowDAO getBorrowDao() {
		return new HibernateBorrowDAO(); // should be hibernateBorrowDAO
	}

}
