package edu.msg.library2server.business;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.jdbc.SqlHandlerException;
/**
 * 
 * @author nagyz
 *
 */
public class BasicBorrowBusiness {
	private static User user;
	private static Publication publication;
	private static UserDao userDao = DaoFactory.getHibernateDaoFactory().getUserDao();
	private static PublicationDao publicationDao = DaoFactory.getHibernateDaoFactory().getPublicationDao();
	private static BorrowDAO borrowDao = DaoFactory.getHibernateDaoFactory().getBorrowDao();
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicBorrowBusiness.class);

	public BasicBorrowBusiness() throws BusinessLayerException  {
		super();
	}

	/**
	 * Check's if user loyalty index is ok.
	 * @param userId - String
	 * @return true
	 * - if user has right to barrow, after checks if the loyalty index is more then zero
	 * @return false
	 * - if user doesn't has right to barrow, loyalty index is zero 
	 * @throws BusinessLayerException
	 */
	public static boolean hasRightToBorrow(String userId) throws BusinessLayerException  {
		try{
		user = new User();
		user = userDao.getById(userId);
		if (user.getLoyalityIndex() > 0) {
			return true;
		} else {
			return false;
		}
		}catch (SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowBusiness_hasRightToBorrow"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowBusiness_hasRightToBorrow"));
		}
	}
/**
 * Check's the publication stock , if the chosen publication is on stock
 * @param pubId - String
 * @return true 
 * - if there are more then 0 publication is on stock
 * @return false 
 * - if there are no more publication is on stock
 * @throws BusinessLayerException
 */
	public static boolean hasPublicationInStock(String pubId) throws BusinessLayerException {
		try{
		publication = new Publication();
		publication = publicationDao.getById(pubId);
		if (publication.getOnStock() > 0) {
			return true;
		} else {
			return false;
		}
		}catch(SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowBusiness_hasRightToBorrow"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowBusiness_hasRightToBorrow"));
		}
	}
/**
 * Check's and try's to make the borrow procedure.
 * @param pubId-String
 * @param from-Date
 * @param until-until
 * @return true
 * -if everything is ok, publication can be borrowed
 * @return false
 * -if there are no more publication in stock or updating the publication table has been failed
 * @throws BusinessLayerException
 */
	public static boolean barrow(String pubId, Date from, Date until) throws BusinessLayerException {
		
		boolean flag = false;
		try{
		Publication publication = new Publication();
		if (hasPublicationInStock(pubId)) {
			BorrowDAO borrowDao = DaoFactory.getHibernateDaoFactory().getBorrowDao();
			if (borrowDao.insertBorrow(user, publication, from, until)) {
				publication.setOnStock(publication.getOnStock() - 1);
				if (publicationDao.update(publication)) {
					LOGGER.info(PropertyProvider.INSTANCE.getProperty("info_logger_BasicBarrowBusiness_update_succes"));
					flag = true;
				} else {
					LOGGER.info(PropertyProvider.INSTANCE.getProperty("info_logger_BasicBarrowBusiness_update_failed"));
					flag = false;
				}
			}
		}
		}catch(SqlHandlerException e){
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowBusiness_hasRightToBorrow"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowBusiness_hasRightToBorrow"));
		}
		return flag;
	}

	/**
	 * Check's if user has three publication's already borrowed
	 * @return true
	 * -if user can still borrow book
	 * @return false
	 * - if user has three publications already borrowed
	 * @throws BusinessLayerException
	 */
	public static boolean hasAlreadyThreeBooks() throws BusinessLayerException {
		return true; 								// meghivni hibernate metodusat
	}

	/**
	 * Check's if user has been late
	 * @return true
	 * -if user hasn't been late
	 * @return false
	 * -if user has been late with one or more borrow date's
	 * @throws BusinessLayerException
	 */
	public static boolean isLate() throws BusinessLayerException  {
		return true;								// meghivni hibernate metodusat
	}

}
