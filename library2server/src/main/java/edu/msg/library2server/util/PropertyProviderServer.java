package edu.msg.library2server.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.msg.library2common.util.PropertyProvider;

/**
 * Makes the connection to the property file.
 * 
 * @author nagyz
 * 
 */
public enum PropertyProviderServer {

	INSTANCE;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyProviderServer.class);
	private final ResourceBundle RESURCEBOUNDLE = ResourceBundle.getBundle("edu.msg.library2server.res.library2");

	/**
	 * Makes the connection to the property file.
	 * 
	 * @author nagyz
	 * @return Property form the library2.property file. 
	 * If property doesn't exist
	 * @return ! [input String] !
	 *
	 */
	public String getProperty(String key) {
		try {
			return RESURCEBOUNDLE.getString(key);
		} catch (MissingResourceException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.property_provider_server"), e);
			return "!" + key + "!";
		}
	}

}