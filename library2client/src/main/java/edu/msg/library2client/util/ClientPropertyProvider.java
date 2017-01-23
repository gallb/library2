package edu.msg.library2client.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public enum ClientPropertyProvider {
	INSTANCE;
	
	private final static ResourceBundle RESURCEBOUNDLE = ResourceBundle.getBundle("edu.msg.library2client.resources.LibraryBundle_en_US");
	
	public static String getProperty(String key) {
		try {
			return RESURCEBOUNDLE.getString(key);
		} catch (MissingResourceException e) {
//			LOGGER.error("Resource is missing", e);
			return "!" + key + "!";
		}
	}
}
