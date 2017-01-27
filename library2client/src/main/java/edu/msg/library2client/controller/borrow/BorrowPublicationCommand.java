package edu.msg.library2client.controller.borrow;

import java.sql.Date;

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
		System.out.println("test");
		String pubID = ViewManager.getViewManager("Console").userInput();
		Publication pub = new Publication();
		pub.setUuid(pubID);
		Borrow borrow = new Borrow(user, pub, new Date(2000, 12, 20), new Date(2001, 01, 10));
		try {
			borrowManager.addNewEntity(borrow);
			System.out.println("client.command.borrow.success");
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			System.out.println("client.command.borrow.notSuccess");
		}		
	}

}
