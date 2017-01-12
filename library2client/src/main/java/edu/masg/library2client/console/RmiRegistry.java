package edu.masg.library2client.console;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import edu.msg.library2common.service.rmi.LoginServiceRmi;

public class RmiRegistry {

	public static void main(String[] arg) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", LoginServiceRmi.RMI_PORT);
			LoginServiceRmi loginServiceRmi = (LoginServiceRmi) registry.lookup(LoginServiceRmi.RMI_NAME);
			System.out.println("ez issss megy");
			System.out.println(loginServiceRmi.login("zoli", "zoli"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
