package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.msg.library2common.service.ServiceException;

/**
 * Verifies login credentials
 * @param userName, password
 * @author gallb
 *
 */
public interface LoginServiceRmi extends Remote{
	
	public static final String RMI_NAME = "Login";
	public static final int RMI_PORT = 1099;

	public String login (String userName, String pwd) throws RemoteException;
	
	/*@ToDo
	public String logout (String token) throws RemoteException;
	*/
}
