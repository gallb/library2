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
import edu.msg.library2common.service.ServiceException;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicLoginService.class);

	public BasicLoginService() throws RemoteException, ServiceException {
		super();
		try {
			userDAO = DaoFactory.getDaoFactory().getUserDao();
		} catch (Exception e) {
			LOGGER.error("Data access object error.",e);
			throw new ServiceException("Data access error.");
		}
	}
	public UserType login(String userName, String pwd) throws RemoteException, ServiceException {
		try {
			User user = userDAO.getUserByUserName(userName);
			if (user.getName() != null) {
				return UserType.Invalid;
			} else {
				if ((user.getUserName().equals(userName) && (user.getPassword().equals(pwd)))) {
					return user.getUserType();
				}
			} 
		} catch (Exception e) {
			LOGGER.error("Faild to retrieve user from db.",e);
			throw new ServiceException("Faild to verify user.");
		}
		return UserType.Invalid;
	}
}