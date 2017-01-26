package edu.msg.library2server.business;

import java.rmi.RemoteException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.jdbc.SqlHandlerException;
import edu.msg.library2server.service.BasicPublicationService;
/**
 * 
 * @author nagyz
 *
 */
public class BasicPublicationBusiness {
	private static final long serialVersionUID = 1L;
	private PublicationDao pubDAO;
	private List<Publication> publist;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicPublicationBusiness.class);

	public BasicPublicationBusiness() throws BusinessLayerException {
		super();
	}
/**
 * Returns a List<Publication> if search for publication by title was successful
 * @param serchString-String
 * @return List<Publication> - if publications where found for input title
 * @throws BusinessLayerException
 * @throws RemoteException
 */
	public List<Publication> searchForPublicationByTitle(String serchString) throws BusinessLayerException, RemoteException {
		try{
		pubDAO = DaoFactory.getHibernateDaoFactory().getPublicationDao();
		publist= pubDAO.searchPublications(serchString);
		}catch (SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicPublicationService"),e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicPublicationService"));
		}
		return publist;
	}
}
