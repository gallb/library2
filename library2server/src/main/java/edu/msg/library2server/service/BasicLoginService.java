/**
 * 
 */
package edu.msg.library2server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.service.exceptions.LoginException;

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
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicLoginService.class);

	public BasicLoginService() throws RemoteException {
		super();
		try {
			userDAO = DaoFactory.getDaoFactory().getUserDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String login(String userName, String pwd) throws RemoteException, LoginException {
		try {
			User user = userDAO.getUserByUserName(userName);
			
			LOGGER.info("Hello world");
			if (user.getName() != null) {

				if ((user.getUserName().equals(userName) && (user.getPassword().equals(pwd)))) {
					if (user.getUserType() == UserType.Reader) {
						return "1";
					}
					if (user.getUserType() == UserType.Admin) {
						return "2";
					}
				}
			} else {
				throw new LoginException("hahah");
			}
		} catch (LoginException e) {
			LOGGER.error("Faild to retrieve user from db.");
			throw new LoginException("Faild to retrieve user from db.", e);
		}
		return "0";
	}
}