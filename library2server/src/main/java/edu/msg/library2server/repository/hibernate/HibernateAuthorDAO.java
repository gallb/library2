package edu.msg.library2server.repository.hibernate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

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
		List<Author> authors = null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Author e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Author getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
