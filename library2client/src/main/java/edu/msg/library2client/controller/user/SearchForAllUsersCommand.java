package edu.msg.library2client.controller.user;

import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.UserManager;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.User;

public class SearchForAllUsersCommand extends AbstractCommand {
public SearchForAllUsersCommand() {
super(14,"client.command.user.SearchForAllUsersCommand","client.command.user.SearchForAllUsersCommand.button");
}
		@Override
		public void execute() {
			UserManager userMan = new UserManager();
			List<User> userList = new ArrayList<>();
			System.out.println(ClientPropertyProvider.getProperty("client.command.input"));
			String selection = ViewManager.getViewManager("Console").userInput();
			try {
				userList = userMan.search(selection);
			} catch (ManagerException e) {
				System.err.print(e.getMessage());
			}
			userList.forEach(element -> System.out.println(element.getName()+ " "+element.getLoyalityIndex()));
		}

	}