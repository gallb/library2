package edu.msg.library2client.controller.borrow;

import edu.msg.library2client.controller.AbstractCommand;

public class BorrowManagementCommand extends AbstractCommand {
	public BorrowManagementCommand() {
		super(19, "client.command.borrowManager", "client.command.borrowManager.button");
	}
	@Override
	public void execute() {		
	}

}
