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
/**
 * 
 * @author nagyz
 *
 */
public class HibernateUserDAO implements UserDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUserDAO.class);

	/**
	 * Get's a List<User>
	 * 
	 * @return List<User> if query succeed
	 */
	@Override
	public List<User> getAll() throws DataAccessException {
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
	 * @param param-String as name
	 * @return List<User> if query succeed
	 */
	@Override
	public List<User> getByName(String param) throws DataAccessException { //nem bizotos h jo
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

	/**
	 * Inserts a User object to database
	 * 
	 * @param u-User
	 * @return true-if insert query succeed
	 * @return false-if insert query didn't succeeded
	 */
	@Override
	public boolean insert(User u) throws DataAccessException {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			System.out.println("session : " + session);
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.update"), ex);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}

	/**
	 * Updates a User object in database
	 * 
	 * @param user-User
	 * @return true-if update query succeed
	 * @return false-if update query didn't succeeded
	 */
	@Override
	public boolean update(User user) throws DataAccessException {
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

	/**
	 * Deletes a User object from database
	 * 
	 * @param user-User
	 * @return true-if delete query succeed
	 * @return false-if delete query didn't succeeded
	 */
	@Override
	public boolean delete(String id) throws DataAccessException {
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

	/**
	 * Searches for a User object by id in the database
	 * 
	 * @param id-String
	 * @return User-if search query by id succeed
	 */
	@Override
	public User getById(String id) throws DataAccessException {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<User> typedQuery = session.createQuery("from User where uuid=?");
			typedQuery.setParameter(0, id);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}

	/**
	 * Searches for a User object by userName in the database
	 * 
	 * @param user_name-String
	 * @return User-if search query by userName succeed
	 */
	@Override
	public User getUserByUserName(String user_name) throws DataAccessException {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<User> typedQuery = session.createQuery("from User where uuid=?");
			typedQuery.setParameter(0, user_name);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateUserDAO.getAll"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}
}