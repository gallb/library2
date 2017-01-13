package edu.msg.library2common.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Makes the connection to the property file.
 * 
 * @author nagyz
 *
 */

public enum PropertyProvider {

	INSTANCE;
//	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyProvider.class);
	private final ResourceBundle RESURCEBOUNDLE = ResourceBundle.getBundle("edu.msg.library2common.res.library2");

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
//			LOGGER.error("Resource is missing", e);
			return "!" + key + "!";
		}
	}

}