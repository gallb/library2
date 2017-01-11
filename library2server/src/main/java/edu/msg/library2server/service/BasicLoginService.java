/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
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
		User user = userDAO.getUserByName(userName);
		if (user.getName() == userName) {
			if (user.getUserType() == UserType.USER) {
				return "1";
			}
			if (user.getUserType() == UserType.ADMIN) {
				return "2";
			}
		}
		return "0";
	}
}
