package edu.msg.library2server.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.service.rmi.AuthorServiceRmi;
import edu.msg.library2server.business.AuthorHandlerInterface;
import edu.msg.library2server.business.BasicPublicationBusiness;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.repository.AuthorDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.hibernate.HibernateAuthorDAO;
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
		
		return false;
	}

	@Override
	public boolean updateEntity(Author entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Author> getByName(String name) throws BusinessLayerException{
		List<Author> authors = new ArrayList<>();
		try{
			authorDao = DaoFactory.getHibernateDaoFactory().getAuthorDao();
			authors = authorDao.getByName(name);
			return authors;
		}catch (SqlHandlerException e) {
			
		}
		return null;
	}
	

	
}
