package edu.msg.library2server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import org.apache.log4j.PropertyConfigurator;

import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.jdbc.SqlHandler;
import edu.msg.library2server.service.BasicLoginService;
import edu.msg.library2server.service.BasicUserService;

public class ServerMain {

	public static void main(String[] args) {
		//String log4jConfPath = "C:\\Users\\gallb\\git\\library2\\library2server\\src\\main\\java\\log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
		try {
			//Registry registry = LocateRegistry.createRegistry(LoginServiceRmi.RMI_PORT);
			Registry registry = LocateRegistry.createRegistry(Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			BasicLoginService basicLoginService = new BasicLoginService();
			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			BasicUserService basicUserService = new BasicUserService();
			registry.rebind(UserServiceRmi.RMI_NAME, basicUserService);
			
//			BasicUserService basicLoginService2 = new BasicU();
//			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
