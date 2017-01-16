package edu.msg.library2server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.Publisher;

//import org.apache.log4j.PropertyConfigurator;

import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.hibernate.HibernateAuthorDAO;
import edu.msg.library2server.repository.hibernate.HibernatePublicationDao;
import edu.msg.library2server.repository.jdbc.SqlHandler;
import edu.msg.library2server.service.BasicLoginService;
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
			HibernatePublicationDao pubDAO = new HibernatePublicationDao();
		//	pubDAO.listPublications().forEach(p -> System.out.println(p.getTitle()));
			List<Publication> pubList = pubDAO.listPublications();
			for (int i = 0; i < pubList.size(); i++) {
				System.out.println(pubList.get(i).getTitle());
			}
			
			HibernateAuthorDAO autDAO = new HibernateAuthorDAO();
			List<Author> autthors = autDAO.listAuthors();
			for (int i = 0; i < autthors.size(); i++) {
				System.out.println(autthors.get(i).getName());
			}
			//Registry registry = LocateRegistry.createRegistry(LoginServiceRmi.RMI_PORT);
			Registry registry = LocateRegistry.createRegistry(Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			BasicLoginService basicLoginService = new BasicLoginService();
			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			
//			BasicUserService basicLoginService2 = new BasicU();
//			registry.rebind(LoginServiceRmi.RMI_NAME, basicLoginService);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
