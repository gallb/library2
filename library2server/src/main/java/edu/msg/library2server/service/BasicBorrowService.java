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

	public boolean borrowPublication(User user, Publication pub, Date from, Date until) {
		System.out.println("belepeett fugvenybe" + " " + pub.getOnStock());
		if ((pub.getOnStock() > 0) && (user.getLoyalityIndex() > 0))  {
			System.out.println("stock & liyalty ok");
			BorrowDAO borrowDao = DaoFactory.getDaoFactory().getBorrowDao();
			System.out.println("borrow dao retrieved");
			if (borrowDao.insertBorrow(user, pub)) {
				System.out.println("borrow inserted");
				PublicationDao pubDao = DaoFactory.getHibernateDaoFactory().getPublicationDao();
				System.out.println("publication dao retrieved");
				pub.setOnStock(pub.getOnStock() -1);
				if (pubDao.update(pub)) {
					System.out.println("stock updated");
					return true;
				} else {
					System.out.println("publication stock update FAILD");
					//ToDo deleteBorrow
					return false;
				}
			}
		}
		return false;
	}
	
}
