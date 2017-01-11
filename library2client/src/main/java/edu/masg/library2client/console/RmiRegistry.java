package edu.masg.library2client.console;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import edu.msg.library2common.service.rmi.LoginServiceRmi;

public class RmiRegistry {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",LoginServiceRmi.RMI_PORT);
			try {
				LoginServiceRmi loginServiceRmi = (LoginServiceRmi)registry.lookup(LoginServiceRmi.RMI_NAME);
				System.out.println(loginServiceRmi.login("zoli", "zoli"));
				System.out.println("beleptem");
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
