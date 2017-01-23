/**
 * 
 */
package edu.msg.library2client.controller;

/**
 * @author gallb
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Command cmd = new Command(Login);
		
		//cmd.execute();
		CommandManager commandManager = new CommandManager();
		
		commandManager.run();
	}

}
