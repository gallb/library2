package edu.msg.library2client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.SQLException;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;

public class RmiRegistry {
	static LoginServiceRmi loginServiceRmi;
	static Registry registry;
	static UserServiceRmi userServiceRmi;
	{
		connect();
		try {

			loginServiceRmi = (LoginServiceRmi) registry.lookup(LoginServiceRmi.RMI_NAME);
			userServiceRmi = (UserServiceRmi) registry.lookup(UserServiceRmi.RMI_NAME);
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

	public void userCrude(User user) {
		try {			
			System.out.println(userServiceRmi.addNewUser(user));
			
			System.out.println(userServiceRmi.getByUsername(user.getName()).getName());
			user.setName("testUpdate");		
			user.setUuid("23");
			System.out.println(userServiceRmi.getByUserID(user.getUuid()).getName());
			System.out.println(userServiceRmi.updateUserData(user));
		 	System.out.println(userServiceRmi.deleteUser(user.getUuid()));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
