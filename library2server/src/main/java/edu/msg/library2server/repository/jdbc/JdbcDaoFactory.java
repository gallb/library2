package edu.msg.library2server.repository.jdbc;

import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.DaoInterface;

public class JdbcDaoFactory extends DaoFactory {
	@Override
	public JdbcUserDao getUserDao() {
		return new JdbcUserDao();
	}

	@Override
	public JdbcPublicationDao getPublicationDao() {
		return new JdbcPublicationDao();
	}


	
	

}
