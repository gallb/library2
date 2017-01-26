package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BasicBorrowBusiness;
import edu.msg.library2server.business.BusinessLayerException;

/**
 * 
 * @author nagyz
 *
 */
public class BasicBorrowService extends UnicastRemoteObject implements BorrowServiceRmi {
	private BasicBorrowBusiness borrowBusiness;
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicBorrowService.class);
/**
 * @throws RemoteException
 * @throws ServiceException
 */
	public BasicBorrowService() throws RemoteException, ServiceLayerException {
		super();
	}
/**Borrows a publication for a user
 *@return true
 *-if user has right to borrow, if has access to another publication and the borrow procedure was successful
 *@return false
 *-if user doesn't has right to procedure or already has three publications borrowed or something went wrong with the borrow procedure
 */
	
	public boolean borrowPublication(String userID, String pubID, Date from, Date until) throws ServiceLayerException {
		boolean flag = false;
		try {
			if (borrowBusiness.hasRightToBorrow(userID)) {
				if (borrowBusiness.hasAlreadyThreeBooks() && borrowBusiness.isLate()) {
					if (borrowBusiness.barrow(pubID, from, until)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_logger_BasicBorrowService"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error_BasicBorrowService"));
		}
		return flag;

	}
@Override
public boolean addNewEntity(Borrow entity) throws RemoteException {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean updateEntity(Borrow entity) throws RemoteException {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean deleteEntity(String entityID) throws RemoteException {
	// TODO Auto-generated method stub
	return false;
}
}
