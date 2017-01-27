package edu.msg.library2client.controller.user;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.UserManager;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.User;

public class EditUserCommand extends AbstractCommand {
	public EditUserCommand() {
		super(12, "client.command.user.edit", "client.command.user.edit.button");
	}

	@Override
	public void execute() {
		UserManager userMan = new UserManager();
		User oneUser = new User();
		System.out.println(ClientPropertyProvider.getProperty("client.command.input"));
		String selection = ViewManager.getViewManager("Console").userInput();
		try {
			oneUser = userMan.searchByName("Pal");
		} catch (ManagerException e) {
			System.err.print(e.getMessage());
		}
		System.out.println(oneUser.getName() + " " + oneUser.getLoyalityIndex());
	}
}
