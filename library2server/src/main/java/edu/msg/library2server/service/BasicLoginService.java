/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.ServiceLayerException;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.business.BasicLoginBusiness;
import edu.msg.library2server.business.BusinessLayerException;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;

/**
 * @author nagyz Validates user data returns user type
 */
public class BasicLoginService extends UnicastRemoteObject implements LoginServiceRmi {

	private static final long serialVersionUID = 1L;
	private UserDao userDAO;
	//plusz
	
	//minusz
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicLoginService.class);

	public BasicLoginService() throws RemoteException, ServiceLayerException {
		super();
		try {
			userDAO = DaoFactory.getDaoFactory().getUserDao();			
		} catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.basic_login_service"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error.basic_login_service"));
		}
	}

	/**
	 * Check if data are valid for the user,validating the password and
	 * user name.
	 * 
	 * @return user type
	 * -Admin,Reader if exist
	 * -Invalid if doesn't exist
	 * @param username	- String user name for identification-validation
	 * @param pwd	-String password for validation
	 */
	public UserType login(String userName, String pwd) throws RemoteException, ServiceLayerException {
		try{
		BasicLoginBusiness basicLoginBusiness = new BasicLoginBusiness();
		//plusz
		UserDao usersajat=DaoFactory.getHibernateDaoFactory().getUserDao();
		List<User> user=new ArrayList<>();
		User uu=new User();
		//user=usersajat.getAll();
		//user=usersajat.getByName("Admin");
//		uu=usersajat.getById("112");				//nem megy
		System.out.println(usersajat.delete("112"));
//		for(User u:user){
//			System.out.println(u.getName().toString());
//		}
				//minusz
		if (basicLoginBusiness.validateLoginData(userName, pwd)) {
			return basicLoginBusiness.returnType(userName);
		}
		}catch (BusinessLayerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.basic_login_service"), e);
			throw new ServiceLayerException(PropertyProvider.INSTANCE.getProperty("error.basic_login_service"));
		}
		return UserType.Invalid;
	}

}