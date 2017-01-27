package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BorrowHandlerInterface;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.businesslogic.BorrowHandler;

/**
 * 
 * @author kiska
 *
 */
public class BasicBorrowService extends UnicastRemoteObject implements BorrowServiceRmi {
	private BorrowHandlerInterface borrowHandler;
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicBorrowService.class);

	/**
	 * @throws RemoteException
	 * @throws ServiceException
	 */
	public BasicBorrowService() throws RemoteException, ServiceLayerException {
		super();
		System.out.println("basicborrowCosntructor");
		borrowHandler = new BorrowHandler();
	}

	/**
	 * Borrows a publication for a user
	 * 
	 * @return true -if user has right to borrow, if has access to another
	 *         publication and the borrow procedure was successful
	 * @return false -if user doesn't has right to procedure or already has
	 *         three publications borrowed or something went wrong with the
	 *         borrow procedure
	 */

	@Override
	public boolean addNewEntity(Borrow entity) throws RemoteException, ServiceLayerException {
		boolean flag = false;			
		try {			
			if (checkEligible(entity.getReader().getUuid(), entity.getPublication().getUuid())) {			
				borrowHandler.addNewEntity(entity);
				flag = true;
			}
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return flag;
	}

	@Override
	public boolean updateEntity(Borrow entity) throws RemoteException, ServiceLayerException {
		boolean flag = false;
		try {
			borrowHandler.updateEntity(entity);
			flag = true;
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return flag;
	}

	@Override
	public boolean deleteEntity(String entityID) throws RemoteException, ServiceLayerException {
		boolean flag = false;
		try {
			borrowHandler.deleteEntity(entityID);
			flag = true;
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return flag;
	}

	@Override
	public boolean insertBorrow(User user, Publication pub, Date borrowFrom, Date borrowUntil)
			throws RemoteException, ServiceLayerException {
		boolean flag = false;
		try {
			if (checkEligible(user.getUuid(), pub.getUuid())) {
				borrowHandler.insertBorrow(user, pub, borrowFrom, borrowUntil);
				flag = true;
			} else {
				throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
			}
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return flag;
	}

	@Override
	public List<Borrow> getAll() {
		List<Borrow> borrowList = new ArrayList<>();
		try {
			borrowList = borrowHandler.getAll();

		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return borrowList;
	}

	@Override
	public Borrow getById(String id) {
		Borrow borrow = new Borrow();
		try {
			borrow = borrowHandler.getById(id);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return borrow;
	}

	@Override
	public List<Borrow> getByUserId(String user_id) {
		List<Borrow> borrowList = new ArrayList<>();
		try {
			borrowList = borrowHandler.getByUserId(user_id);
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return borrowList;
	}

	private boolean checkEligible(String user_id, String pub_id) {
		if (borrowHandler.hasRightToBorrow(user_id)) {
			System.out.println("has right true");
			if (borrowHandler.isLoyal(user_id) && borrowHandler.isOnStock(pub_id)) {
				System.out.println("isloyal and stock true");
				if (!borrowHandler.isLate(user_id)){
					System.out.println("is not late");
					return true;
				}
			}		
		}
		return false;
	}
}
