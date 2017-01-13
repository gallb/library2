package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;

/**
 * Verifies login credentials
 * @param userName, password
 * @author gallb
 *
 */
public interface LoginServiceRmi extends Remote{
	
	public static final String RMI_NAME = PropertyProvider.INSTANCE.getProperty("login.rmi_name");
	public static final int RMI_PORT =Integer.parseInt(PropertyProvider.INSTANCE.getProperty("rmi_port"));

	/**
	 * Returns 'Reader' if the user type is reader, 'Admin' if the user type is administrator.
	 * 'Invalid' if the user does not exist in the database
	 * @param userName - Name of user
	 * @param pwd - password
	 * @return Returns UserType enumeration
	 * @throws RemoteException
	 */
	public UserType login(String userName, String pwd) throws RemoteException, ServiceException;
	
	/*@ToDo
	public String logout (String token) throws RemoteException;
	*/
}
