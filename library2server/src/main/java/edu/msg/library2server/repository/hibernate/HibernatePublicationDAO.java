package edu.msg.library2server.repository.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.PublicationDao;

public class HibernatePublicationDAO implements PublicationDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernatePublicationDAO.class);

	public List<Publication> listPublications() {
		Session session = null;
		List publications = new ArrayList<Publication>();
		try {
			session = HibernateConnector.getInstance().getSession();
			Query query = session.createQuery("from Publication s");

			// System.out.println(query.toString());
			// System.out.println(query.getQueryString() + " " +
			// query.getFetchSize());
			// System.out.println(query.list().size());
			List queryList = query.list();
			/*
			 * List <Publication> queryList = new ArrayList(); for (Object
			 * oneObject : query.getResultList()) { queryList.add((oneObject. }
			 */
			if (!(queryList != null && queryList.isEmpty())) {
				publications = (List<Publication>) queryList;
			}
			return publications;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.listPublication"),
					e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
	}

	public List<Publication> searchPublications(String regularExpression) {
		Session session = null;
		List<Publication> searchResult = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			List list = session.createCriteria(Publication.class).add(Restrictions.like("title", regularExpression))
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

	public <X extends BaseEntity> List<X> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> List<X> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> boolean insert(X e) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> boolean update(X e) {
		Publication pub = (Publication) e;
		boolean status = false;
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			System.out.println(pub.getTitle() + " " + pub.getOnStock());
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(pub);
			session.flush();
			t.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.update"), ex);
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

	public <X extends BaseEntity> X getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Publication getPublicationByTitleAndType(String publication_title, Publication pub_type) {
		// TODO Auto-generated method stub
		return null;
	}
}
