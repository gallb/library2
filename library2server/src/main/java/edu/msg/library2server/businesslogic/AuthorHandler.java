package edu.msg.library2server.businesslogic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.AuthorHandlerInterface;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.repository.AuthorDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.DataAccessException;
import edu.msg.library2server.repository.jdbc.SqlHandlerException;
import edu.msg.library2server.service.BasicAuthorService;

/**
 * 
 * @author nagys
 *
 */
public class AuthorHandler implements AuthorHandlerInterface {

	private AuthorDAO authorDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthorService.class);

	@Override
	public boolean addNewEntity(Author entity) {
		boolean flag = false;
		try {
			authorDao.insert(entity);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return flag;
	}

	@Override
	public boolean updateEntity(Author entity) {
		boolean flag = false;
		try {
			authorDao.update(entity);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return flag;
	}

	@Override
	public boolean deleteEntity(String entityID) {
		boolean flag = false;
		try {
			authorDao.delete(entityID);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return flag;
	}

	@Override
	public List<Author> getByName(String name) throws BusinessLayerException {
		List<Author> authors = new ArrayList<>();
		try {
			authorDao = DaoFactory.getHibernateDaoFactory().getAuthorDao();
			authors = authorDao.getByName(name);
		} catch (SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicAuthorService"));
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicAuthorService"), e);
		}
		return authors;
	}

}
