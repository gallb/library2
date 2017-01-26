package edu.msg.library2client.controller.user;

import edu.msg.library2client.controller.AbstractCommand;

public class DeleteUserCommand extends AbstractCommand {
	public DeleteUserCommand() {
		super(11, "client.command.pub.del", "client.command.pub.del.button");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
