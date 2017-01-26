package edu.msg.library2server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.Author;
import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.Publisher;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
import edu.msg.library2common.service.rmi.UserServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.hibernate.HibernateAuthorDAO;
import edu.msg.library2server.repository.hibernate.HibernateBorrowDAO;
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
		// DaoFactory.getHibernateDaoFactory().getHibernateDaoFactory().getUserDao().getAll().forEach(obj
		// -> System.out.println(obj.getName()));
		// DaoFactory.getHibernateDaoFactory().getPublicationDao().getAll().forEach(obj
		// -> System.out.println(obj.getPublisher().getName()));
		// DaoFactory.getHibernateDaoFactory().getBorrowDao().getAll().forEach(obj
		// -> System.out.println(obj.getPublication().getTitle()));
		HibernateAuthorDAO authorDAO = new HibernateAuthorDAO();
		List<Author> authors = authorDAO.getByName("pet");
		System.out.println(authors.size());
		for (Author author : authors) {
			if (authors == null) {
				System.out.println("null");
			} else {

				System.out.println(author.getName());
			}
		}

		//getAll, getById working
		
//		HibernateBorrowDAO hbBorrowDAO = new HibernateBorrowDAO();
//		
//		User user = new User();
//		user.setUuid("112");
//		Publisher publ = new Publisher();
//		publ.setName("Editura");
//		publ.setUuid("100");
//		Publication pub = new Publication();
//		pub.setUuid("34");
//		Borrow br = new Borrow(user, pub, new Date(2017, 01, 01), new Date(2017, 10, 20));
//		
//		System.out.println(hbBorrowDAO.insertBorrow(user, pub, new Date(2017, 01, 01), new Date(2017, 10, 20)));
////		System.out.println(hbBorrowDAO.insert(br));
//		br.setBorrowUntil(new Date(2030, 10, 10));
////		
//		System.out.println(hbBorrowDAO.update(br));
//		List<Borrow> borrwList= hbBorrowDAO.getAll();
//		borrwList.forEach(b -> System.out.println(b.getUuid() + " " + b.getBorrowFrom()));
//		Borrow b=hbBorrowDAO.getById("e6db5d1e-0a91-4ecb-8393-a8c04a158699");
//		System.out.println("getByid ----------- "  + b.getBorrowFrom());
//	
//	
//		System.out.println("delete " + hbBorrowDAO.delete("e6db5d1e-0a91-4ecb-8393-a8c04a158699"));
	}

}
