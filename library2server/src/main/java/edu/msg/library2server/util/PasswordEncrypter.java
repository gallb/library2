package edu.msg.library2server.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.service.ServiceException;
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
			initialBytes = (password + salt).getBytes(PropertyProvider.INSTANCE.getProperty("encrypt.encoding"));
			MessageDigest algorithm = MessageDigest
					.getInstance(PropertyProvider.INSTANCE.getProperty("encrypt.algorithm"));
			algorithm.reset();
			algorithm.update(initialBytes);
			byte[] hashBytes = algorithm.digest();
			return new String(hashBytes);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Unsuported encoding");
			throw new ServiceException("Unsuported encoding", e);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No Such Algorithm Exception");
			throw new ServiceException("No Such Algorithm Exception", e);
		}
	}
}
