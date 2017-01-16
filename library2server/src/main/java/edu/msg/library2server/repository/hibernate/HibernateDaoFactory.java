package edu.msg.library2server.repository.hibernate;

import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;

public class HibernateDaoFactory extends DaoFactory {

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublicationDao getPublicationDao() {
		return new HibernatePublicationDAO();
	}

}
