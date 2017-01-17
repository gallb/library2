package edu.msg.library2server.repository.hibernate;

import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.jdbc.JdbcUserDao;

public class HibernateDaoFactory extends DaoFactory {
	
	@Override
	public UserDao getUserDao(){	//should be hibernateUserDAO
		return new JdbcUserDao();
	}

	@Override
	public PublicationDao getPublicationDao() {
		return new HibernatePublicationDAO();
	}

}
