package edu.msg.library2server.repository.hibernate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.AuthorDAO;
import edu.msg.library2server.repository.DataAccessException;
import edu.msg.library2server.repository.jdbc.JdbcUserDao;

public class HibernateAuthorDAO implements AuthorDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateAuthorDAO.class);

	// public List<Author> listAuthors() {
	// Session session = null;
	// List author=new ArrayList<Author>();
	// try {
	// session = HibernateConnector.getInstance().getSession();
	// Query query = session.createQuery("from Author s");
	// System.out.println(query.list().size());
	// List queryList = query.list();
	// System.out.println("list utan " + query.list().size());
	// if (!(queryList != null && queryList.isEmpty())) {
	// System.out.println("list " + queryList);
	// author=(List<Author>) queryList;
	// }
	// return author;
	// } catch (Exception e) {
	// LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.hibernateAuthorDAO.getAll"),
	// e);
	// throw new
	// ServiceException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
	// } finally {
	// session.close();
	// }
	// }

	@Override
	public List<Author> getAll() {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Author> typedQuery = session.createQuery("from Author");
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateAuthorDAO.getAll"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_acces"), e);
		} finally {
			session.close();
		}

	}

	@Override
	public List<Author> getByName(String param) {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Author> typedQuery = session.createQuery("from Author where name LIKE ?");
			typedQuery.setParameter(0, '%' + param + '%');
			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateAuthorDAO.getByName"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_acces"), e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean insert(Author e) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			transaction = session.beginTransaction();
			session.save(e);
			transaction.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.HibernateAuthorDao.insert"), ex);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public boolean update(Author e) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(e);
			session.flush();
			transaction.commit();
			status = true;
		} catch (Exception ex) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateAuthorDAO.update"), ex);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.internal_server"));
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public boolean delete(String id) {
		Session session = null;
		boolean status = false;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			Author author = getById(id);
			transaction = session.beginTransaction();
			session.delete(author);
			session.flush();
			transaction.commit();
			status = true;
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernateAuthorDAO.delete"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public Author getById(String id) {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			TypedQuery<Author> typedQuery = session.createQuery("from Author where uuid=?");
			typedQuery.setParameter(0, id);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.HibernatePublicationDAO.getById"), e);
			throw new DataAccessException(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
		} finally {
			session.close();
		}

	}
}
