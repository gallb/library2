/**
 * 
 */
package edu.msg.library2client.controller.publication;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.PublicationManager;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ViewManager;
import edu.msg.library2common.model.Publication;

/**
 * @author gallb
 *
 */
public class SearchPubCommand extends AbstractCommand{
	
	public SearchPubCommand() {
		
		super(2, "client.command.pub.search", "client.command.pub.search.button");
	}

	@Override
	public void execute() {
		PublicationManager pubMan = new PublicationManager();
		List<Publication> pubList = new ArrayList<>();
		System.out.println(ClientPropertyProvider.getProperty("client.command.input"));
		String selection = ViewManager.getViewManager("Console").userInput();
		try {
			pubList = pubMan.search("Pal");
		} catch (ManagerException e) {
			System.err.print(e.getMessage());
		}
		pubList.forEach(element -> System.out.println(element.getTitle() + " "+element.getPublisher()));
	}
	
}
