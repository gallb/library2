package edu.msg.library2common.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;

/**
 * Verifies login credentials
 * 
 * @param userName,
 *            password
 * @author gallb
 *
 */
<<<<<<< HEAD
public interface LoginServiceRmi extends Remote {

	public static final String RMI_NAME = "Login";
	public static final int RMI_PORT = 1099;
=======
public interface LoginServiceRmi extends Remote{
	
	public static final String RMI_NAME = PropertyProvider.INSTANCE.getProperty("login.rmi_name");
	public static final int RMI_PORT =Integer.parseInt(PropertyProvider.INSTANCE.getProperty("rmi_port"));
>>>>>>> branch 'backend' of https://github.com/gallb/library2

	public String login(String userName, String pwd) throws RemoteException;
	/*
	 * @ToDo public String logout (String token) throws RemoteException;
	 */
}
