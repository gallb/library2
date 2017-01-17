package edu.msg.library2client.console;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;

public class RmiRegistry {
	static LoginServiceRmi loginServiceRmi;
	static Registry registry;
	static UserServiceRmi userServiceRmi;
	static PublicationServiceRmi publicationServiceRmi;
//	List<User> user;

	static {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",
					Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			userServiceRmi = (UserServiceRmi) registry.lookup(UserServiceRmi.RMI_NAME);
			publicationServiceRmi = (PublicationServiceRmi) registry.lookup(PublicationServiceRmi.RMI_NAME);
		} catch (Exception e) {

		}
	}

	public List<User> getUserByName(String userName) {
		try{
			return userServiceRmi.searchForUser(userName);
		}catch (Exception e) {
			
		}
		return null;
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

	public List<Publication> getPublicationByName(String title) {
		try {
			return publicationServiceRmi.searchForPublicationByTitle(title);
		} catch (Exception e) {
			System.out.println("Error");
		}

		return null;

	}

}
