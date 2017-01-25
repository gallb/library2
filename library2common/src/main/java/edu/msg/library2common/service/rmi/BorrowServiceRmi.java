package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

/**
 * Provides publication borrowing related services
 * 
 * @author gallb
 *
 */

public interface BorrowServiceRmi  extends EntityServiceInterface<Borrow>{

	public static final String RMI_NAME = "Borrow";
	
	/**
	 * 
	 * @param user - User object representing the person who borrows the book
	 * @param pub - publication object to be borrowed
	 * @param from - sql date containing the value when the book is borrowed
	 * @param until - sql date containing the value until the book must be returned
	 * @return true if the borrow was succesfull false if not
	 * @throws RemoteException
	 */
	public boolean borrowPublication (String userID, String pubID, Date from, Date until) throws RemoteException;
}
