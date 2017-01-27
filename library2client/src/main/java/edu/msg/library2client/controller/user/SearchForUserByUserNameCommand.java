package edu.msg.library2client.controller.user;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.UserManager;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.User;

public class SearchForUserByUserNameCommand extends AbstractCommand {
	public SearchForUserByUserNameCommand() {
		super(16, "client.command.user.SearchForUserByUserNameCommand",
				"client.command.user.SearchForUserByUserNameCommand.button");
	}

	@Override
	public void execute() {
		UserManager userMan = new UserManager();
		User oneUser = new User();
		System.out.println(ClientPropertyProvider.getProperty("client.command.input"));
		String selection = ViewManager.getViewManager("Console").userInput();
		try {
			oneUser = userMan.searchByUserName(selection);
		} catch (ManagerException e) {
			System.err.print(e.getMessage());
		}
		System.out.println(oneUser.getName() + " " + oneUser.getLoyalityIndex());
	}
}
