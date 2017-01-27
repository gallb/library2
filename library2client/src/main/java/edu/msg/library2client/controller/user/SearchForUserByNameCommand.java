package edu.msg.library2client.controller.user;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.UserManager;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.User;

public class SearchForUserByNameCommand extends AbstractCommand {
	public SearchForUserByNameCommand() {
		super(13, "client.command.user.searchForUserByNameCommand",
				"client.command.user.searchForUserByNameCommand.button");
	}

	@Override
	public void execute() {
		UserManager userMan = new UserManager();
		User oneUser = new User();
		System.out.println(ClientPropertyProvider.getProperty("client.command.input"));
		String selection = ViewManager.getViewManager("Console").userInput();
		try {
			oneUser = userMan.searchByName(selection);
		} catch (ManagerException e) {
			System.err.print(e.getMessage());
		}
		System.out.println(oneUser.getName() + " " + oneUser.getLoyalityIndex());
	}
}
