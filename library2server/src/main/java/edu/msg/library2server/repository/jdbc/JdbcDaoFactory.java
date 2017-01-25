package edu.msg.library2server.repository.jdbc;

import edu.msg.library2server.repository.AuthorDAO;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.PublisherDAO;
import edu.msg.library2server.repository.UserDao;

public class JdbcDaoFactory extends DaoFactory {
	@Override
	public UserDao getUserDao() {
		return new JdbcUserDao();
	}

	@Override
	public PublicationDao getPublicationDao() {
		return new JdbcPublicationDao();
	}

	@Override
	public BorrowDAO getBorrowDao() {
		return new JdbcBorrowDAO();
	}

	@Override
	public AuthorDAO getAuthorDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublisherDAO getpublisherDao() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
