package edu.msg.library2client.util;

/**
 * 
 * @author kiska
 *
 *abstract class which defines some methods used for client side data I/O operations 
 *which are common for console and GUI
 */
public abstract class ViewManager {
	/**
	 * 
	 * @param max - the maximum value the user can input
	 * @return - the number the user typed
	 */
	public abstract int numberChooser(int max);
	/**
	 * 
	 * @return - a String representation of the data the user typed
	 */
	public abstract String userInput();
	/**
	 * 
	 * @return - a ConsoleViewManager instance
	 */
	public static ViewManager getViewManager(String input){
		switch(input.toLowerCase()){
		case "console":
			return new ConsoleViewManager();
		}
		return null;		
	}
	
}
