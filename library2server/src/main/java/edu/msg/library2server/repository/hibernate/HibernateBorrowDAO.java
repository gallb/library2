package edu.msg.library2server.repository.hibernate;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DataAccessException;

public class HibernateBorrowDAO implements BorrowDAO{
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateAuthorDAO.class);

	public boolean addBorrow(Borrow borrow) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			System.out.println("session : " + session);
			transaction = session.beginTransaction();
			session.save(borrow);
			transaction.commit();
			status = true;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.HibernateBorrowDAO.addBorrow"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return status;
	}

	@Override
	public List<Borrow> getAll() {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Borrow> typedQuery = session.createQuery("from Borrow s");
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.listPublication"),e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Borrow> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Borrow e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Borrow e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Borrow getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		
		Borrow borrow = new Borrow(user, pub, borrowFrom, borrowUntil);
		try {
			session = HibernateConnector.getInstance().getSession();
			System.out.println("session : " + session);
			transaction = session.beginTransaction();
			session.save(borrow);
			transaction.commit();
			status = true;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.HibernateBorrowDAO.addBorrow"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		}
		return status;	
	}
}
