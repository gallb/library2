package edu.msg.library2server.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.DaoFactory;
import edu.msg.library2server.repository.UserDao;
import edu.msg.library2server.repository.jdbc.SqlHandlerException;
import edu.msg.library2server.util.PasswordEncrypter;
/**
 * 
 * @author nagyz
 *
 */
public class BasicLoginBusiness  {
	private static UserDao userDao = DaoFactory.getDaoFactory().getUserDao();
	private User user;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicLoginBusiness.class);

	public BasicLoginBusiness() throws BusinessLayerException   {
		super();
	}
/**
 * Validates if user exist and password matches.
 * @param userName-String user name
 * @param pwd-String of the password
 * @return true 
 * -if user exist and password is valid.
 *  @return false 
 * -if user does not exist or password was not valid
 * @throws BusinessLayerException
 */
	public boolean validateLoginData(String userName, String pwd) throws BusinessLayerException {
		boolean flag = false;
		try {
			User user = userDao.getUserByUserName(userName);
			if (user.getUserName() == null) {
				flag = false;
			} else {
				if (passwordIsOk(userName, pwd)) {
					flag = true;
				}
			}
		} catch (SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_login_BasicLoginBusiness_validateLoginData"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.login"));
		}
		return flag;
	}
/**
 * Validates if password is the same as in the Database.
 * @param userName-String
 * @param pwd-String
 * @return true
 * - if password is the same as in the database
 * @return false
 * - if password is not matching password in the database
 * @throws BusinessLayerException
 */
	private boolean passwordIsOk(String userName, String pwd)throws BusinessLayerException {
		boolean flag = false;
		try {
			User user = userDao.getUserByUserName(userName);
			User u = new User();
			u.setPassword(PasswordEncrypter.encypted(pwd, " "));
			if (user.getPassword().equals(u.getPassword())) {
				flag = true;
			}
		} catch (SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_login_BasicLoginBusiness_passwordIsOK"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.login"));
		}
		return flag;
	}

	/**
	 * Returns what kind of a user is logged in
	 * @param userName-String
	 * @return Reader or Admin
	 * -if userName exist in database
	 * @return Invalid
	 *- if userName doesn't exist in database
	 * @throws BusinessLayerException
	 */
	public UserType returnType(String userName)throws BusinessLayerException{
		UserType userType;
		try {
			User user = userDao.getUserByUserName(userName);
			if ((user.getUserType().equals(UserType.Reader))||((user.getUserType().equals(UserType.Admin)))) {
				userType = user.getUserType();
			} else {
				userType = UserType.Invalid;
			}
		} catch (SqlHandlerException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error_login_BasicLoginBusiness_returnType"), e);
			throw new BusinessLayerException(PropertyProvider.INSTANCE.getProperty("error.login"));
		}
		return userType;
	}
}
