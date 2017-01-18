/**
 * 
 */
package edu.msg.library2server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.javafx.css.PseudoClassState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.service.rmi.LoginServiceRmi;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.util.PasswordEncrypter;

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
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.basic_login_service"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.basic_login_service"));
		}
	}

	public UserType login(String userName, String pwd) throws RemoteException, ServiceException {
		try {
			User user = userDAO.getUserByUserName(userName);
			if (user.getName() == null) {
				return UserType.Invalid;
			} else {
				User u = new User();
				u.setPassword(PasswordEncrypter.encypted(pwd, " "));
				if ((user.getUserName().equals(userName) && (user.getPassword().equals(u.getPassword())))) {
					return user.getUserType();
				}
			}
		} catch (Exception e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.basic_login_service.login"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.login"));
		}
		return UserType.Invalid;
	}
}