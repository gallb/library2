package edu.msg.library2server.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.jdbc.JdbcUserDao;

/**
 * Encrypts the password.
 * 
 * @author nagyz
 *
 */
public class PasswordEncrypter {
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUserDao.class);


/**
 * Concate's the two input Strings (password + salt) and makes the hashed password.
 * 
 * @author nagyz
 * @return Hashed password
 *
 */
	public static String encypted(String password, String salt) {
		try {
			byte[] initialBytes;
			initialBytes = (password + salt).getBytes(PropertyProviderServer.INSTANCE.getProperty("encrypt.encoding"));
			MessageDigest algorithm = MessageDigest
					.getInstance(PropertyProviderServer.INSTANCE.getProperty("encrypt.algorithm"));
			algorithm.reset();
			algorithm.update(initialBytes);
			byte[] hashBytes = algorithm.digest();
			return new String(hashBytes);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.password_encrypted1"));
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.logger.password_encrypted1"), e);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.password_encrypted2"));
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.logger.password_encrypted2"), e);
		}
	}
}
