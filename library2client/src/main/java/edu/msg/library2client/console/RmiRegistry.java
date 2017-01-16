package edu.msg.library2client.console;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;

public class RmiRegistry {
	static LoginServiceRmi loginServiceRmi;
	static Registry registry;
	static UserServiceRmi userServiceRmi;
	
	static{
		try{
			Registry registry = LocateRegistry.getRegistry("localhost",Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			userServiceRmi = (UserServiceRmi) registry.lookup(UserServiceRmi.RMI_NAME);
		}catch (Exception e) {
			
		}
	}
	
	

	public void getUserByName(String userName){
		try {
			List<User> user = userServiceRmi.searchForUser(userName);
			if(user.isEmpty()){
				System.out.println("nincs");
			}
			user.forEach(u->System.out.println(u.getName()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

}
