package edu.msg.library2client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.manager.AuthorManager;
import edu.msg.library2common.model.Author;

public class SearchAuthorCommand extends AbstractCommand {

	public SearchAuthorCommand() {
		super(18, "client.command.author.search", "client.command.author.search.button");
	}

	@Override
	public void execute() {
		AuthorManager authorManager = new AuthorManager();
		List<Author> authors = new ArrayList<>();
		try {
			authors = authorManager.search("P");

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		authors.forEach(element -> System.out.println(element.getName()));

	}

}
