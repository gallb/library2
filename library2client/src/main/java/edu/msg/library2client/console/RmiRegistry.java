package edu.msg.library2client.console;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;

public class RmiRegistry {
	static LoginServiceRmi loginServiceRmi;
	static Registry registry;
	static UserServiceRmi userServiceRmi;

	static {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",
					Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			userServiceRmi = (UserServiceRmi) registry.lookup(UserServiceRmi.RMI_NAME);
		} catch (Exception e) {

		}
	}

	public void getUserByName(String userName) {
		try {
			List<User> user = userServiceRmi.searchForUser(userName);
			if (user.isEmpty()) {
				System.out.println("nincs");
			}
			for (int i = 1; i < user.size(); ++i) {
				System.out.println(i + " " + user.get(i).getName());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public boolean insertUser(String name, String userName, UserType userType, int index, String password) {
		User user = new User();

		user.setName(name);
		user.setUserName(userName);
		user.setLoyalityIndex(index);
		user.setUserType(userType);
		user.setPassword(password);
		try {
			return userServiceRmi.addNewUser(user);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}


}
