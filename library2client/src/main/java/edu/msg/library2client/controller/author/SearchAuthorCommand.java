package edu.msg.library2client.controller.author;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.AuthorManager;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.Author;

public class SearchAuthorCommand extends AbstractCommand {

	public SearchAuthorCommand() {
		super(18, "client.command.author.search", "client.command.author.search.button");
	}

	@Override
	public void execute() {
		AuthorManager authorManager = new AuthorManager();
		List<Author> authors = new ArrayList<>();
		System.out.println(ClientPropertyProvider.getProperty("client.command.author.input.user"));
		String selection = ViewManager.getViewManager("Console").userInput();
		try {
			authors = authorManager.search(selection);

		} catch (ManagerException e) {
			System.err.println(e.getMessage());
		}
		authors.forEach(element -> System.out.println(element.getName()));

	}

}
