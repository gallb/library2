package edu.msg.library2server.repository.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DataAccessException;
import edu.msg.library2server.repository.UserDao;

public class HibernateUserDAO implements UserDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUserDAO.class);
	@Override
	public List<User> getAll() {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<User> typedQuery = session.createQuery("from User u");
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"),e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}	
	}

	@Override
	public List<User> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String user_name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
