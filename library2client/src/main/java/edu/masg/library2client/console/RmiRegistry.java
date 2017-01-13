package edu.masg.library2client.console;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.SQLException;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;

public class RmiRegistry {
	static LoginServiceRmi loginServiceRmi;
	static UserServiceRmi userServiceRmi;
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
	
	 void connect(){
		try {
			 registry = LocateRegistry.getRegistry((PropertyProvider.INSTANCE.getProperty("host")), Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserType login(String userName,String pwd) {
		try{
			return loginServiceRmi.login(userName, pwd);
		}catch (Exception e) {
			e.printStackTrace();
			return UserType.Invalid;
		}

	}
	
	
	public boolean addNewUser(User user){

			try {
				userServiceRmi=(UserServiceRmi)registry.lookup(UserServiceRmi.RMI_NAME);

			} catch (AccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		return false;
	}

}
