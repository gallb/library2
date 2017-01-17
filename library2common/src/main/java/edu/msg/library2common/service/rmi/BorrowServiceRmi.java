package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

public interface BorrowServiceRmi extends Remote{

	public static final String RMI_NAME = "Borrow";
	
	public boolean borrowPublication (User user, Publication pub, Date from, Date until) throws RemoteException;
}
