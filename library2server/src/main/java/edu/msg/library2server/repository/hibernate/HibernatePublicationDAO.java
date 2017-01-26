package edu.msg.library2server.repository.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DataAccessException;
import edu.msg.library2server.repository.PublicationDao;

public class HibernatePublicationDAO implements PublicationDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernatePublicationDAO.class);

	public List<Publication> searchPublications(String serachString) {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Publication> typedQuery = session.createQuery("from Publication where title LIKE ?");
			typedQuery.setParameter(0, '%' + serachString + '%');
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.listPublication"),e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
	}

	public List<Publication> getAll() {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Publication> typedQuery = session.createQuery("from Publication s");
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.listPublication"),e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
	}
	/**
	 * 
	 */
	public List<Publication> getByName(String param) {
		Session session = null;
		List<Publication> searchResult = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			List list = session.createCriteria(Publication.class).add(Restrictions.like("title", param))
					.list();
			if (list != null) {
				searchResult = (List<Publication>) list;
			}
			return searchResult;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.listPublication"),
					e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}

	public boolean insert(Publication e) {
		// TODO Auto-generated method stub
		return false;
	}
/**
 * 
 */
	public boolean update(Publication pub) {
		boolean status = false;
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(pub);
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

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Publication getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
