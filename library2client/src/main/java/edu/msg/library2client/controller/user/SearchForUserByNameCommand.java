package edu.msg.library2client.controller.user;

import edu.msg.library2client.controller.AbstractCommand;

public class SearchForUserByNameCommand extends AbstractCommand {
	public SearchForUserByNameCommand() {
		super(13, "client.command.user.searchForUserByNameCommand",
				"client.command.user.searchForUserByNameCommand.button");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}