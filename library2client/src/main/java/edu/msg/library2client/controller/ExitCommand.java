/**
 * 
 */
package edu.msg.library2client.controller;

import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2common.util.PropertyProvider;

/**
 * @author gallb
 *
 */
public class ExitCommand extends AbstractCommand{

	private boolean exitFlag;
	
	
	
	public ExitCommand() {
		
		super(0, "client.command.exit", "client.command.exit.button");
		this.exitFlag = false;
	}

	@Override
	public void execute() {
		exitFlag = true;
	}

	public boolean isExitFlag() {
		return exitFlag;
	}
}
