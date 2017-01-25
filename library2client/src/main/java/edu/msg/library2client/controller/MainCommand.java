/**
 * 
 */
package edu.msg.library2client.controller;

import edu.msg.library2client.util.ClientPropertyProvider;

/**
 * @author gallb
 *
 */
public class MainCommand extends AbstractCommand{

	public  MainCommand() {
		super(1, "client.command.main", "client.command.main.button");
		//System.out.println("Maincommand constructor");
		//setId(1);
		//setName(ClientPropertyProvider.getProperty("client.command.main"));
		//setTriggerCharacter(ClientPropertyProvider.getProperty("client.command.main.button"));
	}
	
	@Override
	public void execute() {
	}
	
}
