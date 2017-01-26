/**
 * 
 */
package edu.msg.library2server.businesslogic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BasicPublicationBusiness;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.business.PublicationHandlerInterface;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.jdbc.SqlHandlerException;

/**
 * @author gallb
 *
 */
public class PublicationHandler implements PublicationHandlerInterface{

	private PublicationDao pubDAO;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicPublicationBusiness.class);
	
	@Override
	public boolean addNewEntity(Publication entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Publication entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String entityID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Publication> searchForPublicationByTitle(String serchString) throws BusinessLayerException {
		List<Publication> publist = new ArrayList<>();
		try{
			pubDAO = DaoFactory.getHibernateDaoFactory().getPublicationDao();
			publist= pubDAO.searchPublications(serchString);
			}catch (SqlHandlerException e) {
				LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicPublicationService"));
				throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicPublicationService"), e);
			}
		return publist;
	}

}
