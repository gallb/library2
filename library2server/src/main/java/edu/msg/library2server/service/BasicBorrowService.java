package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.PublicationDao;

public class BasicBorrowService extends UnicastRemoteObject implements BorrowServiceRmi{

	public BasicBorrowService() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean borrowPublication(String userID, String pubID, Date from, Date until) {		
		//authorize
		//	bl user handler - if hasRightToBorrof
		//validate
			//bl user handler - isLate()
							//bl borrow handler borrow
		
		
		
		
	/*	if ((pub.getOnStock() > 0) && (user.getLoyalityIndex() > 0))  {
			BorrowDAO borrowDao = DaoFactory.getDaoFactory().getBorrowDao();
			if (borrowDao.insertBorrow(user, pub, from, until)) {
				PublicationDao pubDao = DaoFactory.getHibernateDaoFactory().getPublicationDao();
				pub.setOnStock(pub.getOnStock() -1);
				if (pubDao.update(pub)) {
					return true;
				} else {				
					//ToDo deleteBorrow
					return false;
				}
			}
		}*/
		return false;
	}
}
