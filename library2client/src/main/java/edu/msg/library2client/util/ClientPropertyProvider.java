package edu.msg.library2client.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public enum ClientPropertyProvider {
	INSTANCE;
	
	private static ResourceBundle RESURCEBOUNDLE = ResourceBundle.getBundle("edu.msg.library2client.resources.LibraryBundle", new Locale(""));
	
	public static String getProperty(String key) {
		try {
			return RESURCEBOUNDLE.getString(key);
		} catch (MissingResourceException e) {
//			LOGGER.error("Resource is missing", e);
			return "!" + key + "!";
		}
	}
	
	public  void setLocal(Locale locale) {
		RESURCEBOUNDLE = ResourceBundle.getBundle("edu.msg.library2client.resources.LibraryBundle", locale);
		
	}
}
