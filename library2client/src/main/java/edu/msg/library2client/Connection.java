package edu.msg.library2client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.util.PropertyProvider;


public class Connection {
	static LoginServiceRmi loginServiceRmi;
	static Registry registry;
	{
		connect();
		try {

			loginServiceRmi = (LoginServiceRmi) registry.lookup(LoginServiceRmi.RMI_NAME);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void connect() {
		try {
			registry = LocateRegistry.getRegistry((PropertyProvider.INSTANCE.getProperty("host")),
					Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserType login(String userName, String pwd) {
		try {
			return loginServiceRmi.login(userName, pwd);
		} catch (Exception e) {
			return UserType.Invalid;
		}
	}

	


}
