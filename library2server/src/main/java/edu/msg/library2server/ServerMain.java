package edu.msg.library2server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.service.BasicBorrowService;
import edu.msg.library2server.service.BasicLoginService;
import edu.msg.library2server.service.BasicPublicationService;
import edu.msg.library2server.service.BasicUserService;

public class ServerMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerMain.class);

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry
					.createRegistry(Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			BasicLoginService basicLoginService = new BasicLoginService();
			BasicUserService basicUserService = new BasicUserService();
			BasicPublicationService basicPublicationService = new BasicPublicationService();
			BasicBorrowService basicBorrowService = new BasicBorrowService();
			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			registry.rebind(UserServiceRmi.RMI_NAME, basicUserService);
			registry.rebind(PublicationServiceRmi.RMI_NAME, basicPublicationService);
			registry.rebind(BorrowServiceRmi.RMI_NAME, basicBorrowService);
		} catch (RemoteException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.ServerMain"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.logger.ServerMain"));
		}
		//DaoFactory.getHibernateDaoFactory().getHibernateDaoFactory().getUserDao().getAll().forEach(obj -> System.out.println(obj.getName()));
		//DaoFactory.getHibernateDaoFactory().getPublicationDao().getAll().forEach(obj -> System.out.println(obj.getPublisher().getName()));
		//DaoFactory.getHibernateDaoFactory().getBorrowDao().getAll().forEach(obj -> System.out.println(obj.getPublication().getTitle()));
	}

}
