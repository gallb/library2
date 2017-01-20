package edu.msg.library2client.console;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;

public class RmiRegistry {
	private static final Registry registry = createRegistry();
	private static final UserServiceRmi userServiceRmi = createUserService();
	private static final PublicationServiceRmi publicationServiceRmi = createPublicationService();
	private static final BorrowServiceRmi borrowServiceRmi = createBorrowService();

	private static final Registry createRegistry() {
		try {
			return LocateRegistry.getRegistry("localhost",
					Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
		} catch (NumberFormatException e) {
			System.err.println((PropertyProvider.INSTANCE.getProperty("error.logger.RmiRegistry")));
		} catch (RemoteException e) {
			System.err.println((PropertyProvider.INSTANCE.getProperty("error.logger.RmiRegistry")));
			e.printStackTrace();
		}
		return null;
	}
	
	private static final UserServiceRmi createUserService() {
		try {
			return (UserServiceRmi) registry.lookup(UserServiceRmi.RMI_NAME);
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
		return null;
	}
	
	private static final PublicationServiceRmi createPublicationService() {
		try {
			return (PublicationServiceRmi) registry.lookup(PublicationServiceRmi.RMI_NAME);
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
		return null;
	}
	
	private static final BorrowServiceRmi createBorrowService() {
		try {
			return (BorrowServiceRmi) registry.lookup(BorrowServiceRmi.RMI_NAME);
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
		return null;
	}

	public List<User> getUserByName(String userName) {
		try {
			return userServiceRmi.searchForUser(userName);
		} catch (Exception e) {
			System.err.println((PropertyProvider.INSTANCE.getProperty("error.logger.RmiRegistry")));
		}
		return null;
	}

	public List<Publication> getPublicationByName(String title) {
		try {
			return publicationServiceRmi.searchForPublicationByTitle(title);
		} catch (Exception e) {
			System.err.println((PropertyProvider.INSTANCE.getProperty("error.logger.RmiRegistry")));
		}
		return new ArrayList<Publication>();
	}

}
