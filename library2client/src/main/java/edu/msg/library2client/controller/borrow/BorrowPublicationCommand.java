package edu.msg.library2client.controller.borrow;

import java.sql.Date;
import java.time.LocalDate;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.BorrowManager;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;

public class BorrowPublicationCommand  extends AbstractCommand{
	public BorrowPublicationCommand() {
		super(21, "client.command.borrow.borrow", "client.command.borrow.borrow.button");
	}
	
	@Override
	public void execute() {
		BorrowManager borrowManager = new BorrowManager();
		System.out.println(ClientPropertyProvider.getProperty("client.command.borrow.input.user"));
		String userID = ViewManager.getViewManager("Console").userInput();
		User user = new User();
		user.setUuid(userID);
		System.out.println(ClientPropertyProvider.getProperty("client.command.borrow.input.publication"));
		String pubID = ViewManager.getViewManager("Console").userInput();
		Publication pub = new Publication();
		pub.setUuid(pubID);
				
		LocalDate locald = LocalDate.now();
		Date dateFrom = Date.valueOf(locald);
		
		LocalDate local = locald.plusDays(20);
		Date dateUntil = Date.valueOf(local);
		Borrow borrow = new Borrow(user, pub, dateFrom, dateUntil);
		try {
			borrowManager.addNewEntity(borrow);
			System.out.println(ClientPropertyProvider.getProperty("client.command.borrow.success"));
		} catch (ManagerException e) {			
			System.out.println(ClientPropertyProvider.getProperty("client.command.borrow.notSuccess"));
		}		
	}

}
