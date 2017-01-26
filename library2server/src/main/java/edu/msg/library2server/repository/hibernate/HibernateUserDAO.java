package edu.msg.library2server.repository.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DataAccessException;
import edu.msg.library2server.repository.UserDao;

public class HibernateUserDAO implements UserDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUserDAO.class);

	@Override
	public List<User> getAll() {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<User> typedQuery = session.createQuery("from User u");
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
	}

	/**
	 * Get's a List<User> searched by user's name
	 * 
	 * @param param-String
	 * @return List<User> if query succeed
	 */
	@Override
	public List<User> getByName(String param) {
		Session session = null;
		List<User> searchResult = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			List list = session.createCriteria(User.class).add(Restrictions.like("name", param)).list();
			if (list != null) {
				searchResult = (List<User>) list;
			}
			return searchResult;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}

	@Override
	public boolean insert(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		boolean status = false;
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			System.out.println(user.getUserName() + " " + user.getLoyalityIndex());
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(user);
			session.flush();
			t.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.update"), ex);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public boolean delete(String id) { 
		boolean status = false;
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<User> typedQuery = session.createQuery("from User where uuid=?");
			typedQuery.setParameter(0, id);
			User user = typedQuery.getSingleResult();
			Transaction t = session.beginTransaction();
			session.delete(user);
			session.flush();
			t.commit();
			status = true;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public User getById(String id) { // neeem megy meg
		Session session = null;
		User searchResult = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			User user = (User) session.createCriteria(User.class).add(Restrictions.like("uuid", id)).list();

			if (user != null) {
				searchResult = user;
				System.out.println("nem irja ki a kepernyore");
			}
			return searchResult;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}

	@Override
	public User getUserByUserName(String user_name) {
		Session session = null;
		User searchResult = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			User user = (User) session.createCriteria(User.class).add(Restrictions.like("user_name", user_name)).list();
			if (user != null) {
				searchResult = user;
			}
			return searchResult;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}

}
