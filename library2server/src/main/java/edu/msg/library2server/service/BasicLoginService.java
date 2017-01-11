/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;

import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;

/**
 * @author gallb
 *
 */
public class BasicLoginService implements LoginServiceRmi{

	private UserDao userDAO;
	
	public BasicLoginService() {
		try {
			userDAO = DaoFactory.getDaoFactory().getUserDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String login(String userName, String pwd) throws RemoteException {
		userDAO.verifyUser(userName, pwd);
		return null;
	}
}
