/**
 * 
 */
package edu.msg.library2server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;

/**
 * @author gallb
 *
 */
public class BasicLoginService extends UnicastRemoteObject implements LoginServiceRmi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDAO;

	public BasicLoginService() throws RemoteException {
		super();
		try {
			userDAO = DaoFactory.getDaoFactory().getUserDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String login(String userName, String pwd) throws RemoteException {
		User user = userDAO.getUserByUserName(userName);
		if (user.getUserName().equals(userName)&& (user.getPassword().equals(pwd))) {
			if (user.getUserType() == UserType.Reader) {
				return "1";
			}
			if (user.getUserType() == UserType.Admin) {
				return "2";
			}
		}
		return "0";
	}
}
