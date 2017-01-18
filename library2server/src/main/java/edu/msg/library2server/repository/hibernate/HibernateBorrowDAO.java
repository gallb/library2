package edu.msg.library2server.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;

public class HibernateBorrowDAO {
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
}
