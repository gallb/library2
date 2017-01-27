package edu.msg.library2server.businesslogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BorrowHandlerInterface;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.DataAccessException;
import edu.msg.library2server.repository.PublicationDao;
import edu.msg.library2server.repository.UserDao;

/**
 * 
 * @author kiska
 *
 */
public class BorrowHandler implements BorrowHandlerInterface {

	private static BorrowDAO borrowDao = DaoFactory.getHibernateDaoFactory().getBorrowDao();
	private static UserDao userDao = DaoFactory.getHibernateDaoFactory().getUserDao();
	private static PublicationDao publicationDao = DaoFactory.getHibernateDaoFactory().getPublicationDao();
	private static final Logger LOGGER = LoggerFactory.getLogger(BorrowHandler.class);

	@Override
	public boolean addNewEntity(Borrow entity) {
		boolean flag = false;
		try {
			borrowDao.insert(entity);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return flag;
	}

	@Override
	public boolean updateEntity(Borrow entity) {
		boolean flag = false;
		try {
			borrowDao.update(entity);
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
			borrowDao.delete(entityID);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return flag;
	}

	@Override
	public boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil) {
		boolean flag = false;
		try {
			borrowDao.insertBorrow(user, pub, borrowFrom, borrowUntil);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return flag;
	}

	@Override
	public List<Borrow> getAll() {
		List<Borrow> borrowList = new ArrayList<>();
		try {
			borrowList = borrowDao.getAll();
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return borrowList;
	}

	@Override
	public List<Borrow> getByUserId(String user_id) {
		List<Borrow> borrowList = new ArrayList<>();
		try {
			borrowList = borrowDao.getByUserId(user_id);
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return borrowList;
	}
	
	@Override
	public Borrow getById(String id) {
		Borrow borrow = new Borrow();
		try {
			borrow = borrowDao.getById(id);
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return borrow;
	}

	@Override
	public boolean isLoyal(String user_id) {
		User user = userDao.getById(user_id);
		if (user.getLoyalityIndex() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isOnStock(String publication_id) {
		Publication publication = publicationDao.getById(publication_id);
		if (publication.getOnStock() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRightToBorrow(String user_id) {

		List<Borrow> borrowList = new ArrayList<>();
		try {
			borrowList = borrowDao.getByUserId(user_id);
			if (borrowList.size() < 4) {
				return true;
			}
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return false;
	}

	public boolean isLate(String user_id) {

		boolean isLate = false;
		List<Borrow> borrowList = new ArrayList<>();
		try {
			borrowList = borrowDao.getByUserId(user_id);
			java.util.Date today = new java.util.Date();
			java.sql.Date sqlToday = new java.sql.Date(today.getTime());

			for (Borrow b : borrowList) {
				// if borrowUntil is newer date than today+
				System.out.println(b.getBorrowUntil());
				if (b.getBorrowUntil().compareTo(sqlToday) > 0) {
					isLate = true;
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.data_access"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.businnes_layer"));
		}
		return isLate;
	}
}
