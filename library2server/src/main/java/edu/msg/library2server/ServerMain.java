package edu.msg.library2server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.Publisher;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;

//import org.apache.log4j.PropertyConfigurator;

import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.hibernate.AuthorDAO;
import edu.msg.library2server.repository.hibernate.BorrowDAO;
import edu.msg.library2server.repository.hibernate.HibernatePublicationDAO;
import edu.msg.library2server.repository.jdbc.SqlHandler;
import edu.msg.library2server.service.BasicLoginService;
import edu.msg.library2server.service.BasicPublicationService;
import edu.msg.library2server.service.BasicUserService;

public class ServerMain {

	public static void main(String[] args) {
		//String log4jConfPath = "C:\\Users\\gallb\\git\\library2\\library2server\\src\\main\\java\\log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
		try {
			/*Date tempDate = new Date(2017,01,01);
			Publisher pub = new Publisher("Dummy");
			Publication testPub = new Publication("hibernatetest", tempDate, pub, 10, 10);
			System.out.println(testPub.getTitle());
			testPub.setTitle("modified");
			System.out.println(testPub.getTitle());*/
			//HibernatePublicationDAO pubDAO = new HibernatePublicationDAO();
		//	pubDAO.listPublications().forEach(p -> System.out.println(p.getTitle()));
//			List<Publication> pubList = pubDAO.listPublications();
//			for (int i = 0; i < pubList.size(); i++) {
//				System.out.println(pubList.get(i).getTitle());
//			}
//			pubList.get(0).setOnStock(pubList.get(0).getOnStock() - 1);
//			pubDAO.updatePublication(pubList.get(0));
			
			
			/*List<Publication> pubList2 =pubDAO.searchPublications("%fiuk");
			for (int i = 0; i < pubList2.size(); i++) {
				System.out.println("sesrver " + pubList2.get(i).getTitle());
			}*/
			
		/*	BorrowDAO br = new BorrowDAO();
			User us = new User("dummy", "dummy", 10, "dummy", UserType.Admin);
			us.setUuid("23");
			Publication pb = new Publication("dummy",  new Date(2012, 01, 10), new Publisher("dummy"), 10, 2);
			pb.setUuid("34");
			Borrow borrow = new Borrow(us, pb, new Date(2012, 01, 10), new Date(2012, 01, 20));
			
			System.out.println(br.addBorrow(borrow));*/
			
//			AuthorDAO autDAO = new AuthorDAO();
//			List<Author> autthors = autDAO.listAuthors();
//			for (int i = 0; i < autthors.size(); i++) {
//				System.out.println(autthors.get(i).getName());
//			}
			//Registry registry = LocateRegistry.createRegistry(LoginServiceRmi.RMI_PORT);
			Registry registry = LocateRegistry.createRegistry(Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			BasicLoginService basicLoginService = new BasicLoginService();
			BasicUserService basicUserService = new BasicUserService();
			BasicPublicationService basicPublicationService = new BasicPublicationService();
			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			registry.rebind(UserServiceRmi.RMI_NAME, basicUserService);
			registry.rebind(PublicationServiceRmi.RMI_NAME, basicPublicationService);
			
			
//			BasicUserService basicLoginService2 = new BasicU();
//			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
