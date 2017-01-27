package edu.msg.library2client.controller.user;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.PublicationManager;
import edu.msg.library2common.model.Publication;

public class SearchForUserByNameCommand extends AbstractCommand {
	public SearchForUserByNameCommand() {
		super(13, "client.command.user.searchForUserByNameCommand",
				"client.command.user.searchForUserByNameCommand.button");
	}

	@Override
	public void execute() {
		PublicationManager pubMan = new PublicationManager();
		List<Publication> pubList = new ArrayList<>();
		try {
			pubList = pubMan.search("Pal");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		pubList.forEach(element -> System.out.println(element.getTitle() + " " + element.getPublisher()));
	}

}
