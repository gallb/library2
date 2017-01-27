package edu.msg.library2client.controller.author;

import edu.msg.library2client.controller.AbstractCommand;

public class AuthorManagementCommand extends AbstractCommand {

	public AuthorManagementCommand() {
		super(17, "client.command.author.manage", "client.command.author.manage.button");
	}

	@Override
	public void execute() {

	}

}
