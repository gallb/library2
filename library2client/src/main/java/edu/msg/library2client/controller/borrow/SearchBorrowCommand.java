package edu.msg.library2client.controller.borrow;

import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.BorrowManager;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.Borrow;

public class SearchBorrowCommand extends AbstractCommand {
	public SearchBorrowCommand() {
		super(20, "client.command.borrow.search", "client.command.borrow.search.button");
	}

	@Override
	public void execute() {
		BorrowManager borrowManager = new BorrowManager();
		List<Borrow> borrows = new ArrayList<>();
		System.out.println(ClientPropertyProvider.getProperty("client.command.borrow.input.user"));
		String selection = ViewManager.getViewManager("Console").userInput();
		try {
			borrows = borrowManager.search(selection);
		} catch (ManagerException e) {
			System.err.print(e.getMessage());
		}
		borrows.forEach(element -> System.out
				.println(element.getUuid() + " " + element.getBorrowFrom() + " " + element.getBorrowUntil()));

	}

}
