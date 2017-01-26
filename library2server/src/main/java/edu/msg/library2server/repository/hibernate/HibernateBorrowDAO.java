package edu.msg.library2server.repository.hibernate;

import java.sql.Date;
/**
 * @author kiska
 * CRUDE methods for Borrow object, using Hibernate
 */
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DataAccessException;
/**
 * @author kiska
 *
 */
public class HibernateBorrowDAO implements BorrowDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateAuthorDAO.class);

	@Override
	public List<Borrow> getAll() {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Borrow> typedQuery = session.createQuery("from Borrow");
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.listPublication"),
					e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Borrow> getByName(String param) {
		// no need to implement this one
		return null;
	}

	@Override
	public boolean insert(Borrow e) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			System.out.println("session : " + session);
			transaction = session.beginTransaction();
			session.save(e);
			transaction.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.HibernateBorrowDAO.insert"), ex);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public boolean update(Borrow e) {
		boolean status = false;
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(e);
			session.flush();
			t.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateBorrowDAO.update"), ex);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
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
			Borrow borrow = getById(id);

			Transaction t = session.beginTransaction();

			session.delete(borrow);
			session.flush();
			t.commit();
			status = true;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.delete"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
		return status;
	}
	
	

	@Override
	public Borrow getById(String id) {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Borrow> typedQuery = session.createQuery("from Borrow where uuid=?");
			typedQuery.setParameter(0, id);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.getById"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;

		Borrow borrow = new Borrow(user, pub, borrowFrom, borrowUntil);
		try {
			session = HibernateConnector.getInstance().getSession();
			transaction = session.beginTransaction();
			session.save(borrow);
			transaction.commit();
			status = true;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.HibernateBorrowDAO.insert"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}
}
