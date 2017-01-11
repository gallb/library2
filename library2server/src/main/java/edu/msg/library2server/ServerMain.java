package edu.msg.library2server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2server.repository.jdbc.SqlHandler;
import edu.msg.library2server.service.BasicLoginService;

public class ServerMain {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(LoginServiceRmi.RMI_PORT);
			BasicLoginService basicLoginService = new BasicLoginService();
			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SqlHandler cHandler;
		
		while(true){
		cHandler = SqlHandler.getInstance();
		}

	}

}
