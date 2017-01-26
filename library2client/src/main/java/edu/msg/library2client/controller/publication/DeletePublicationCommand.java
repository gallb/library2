/**
 * 
 */
package edu.msg.library2client.controller.publication;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.PublicationManager;

/**
 * @author gallb
 *
 */
public class DeletePublicationCommand extends AbstractCommand{

	public DeletePublicationCommand() {
		super(7,"client.command.pub.del","client.command.pub.del.button");
	}
	
	@Override
	public void execute() {
		PublicationManager pubMan = new PublicationManager();
		try {
			if (pubMan.deleteEntity("89")) {
				System.out.println("Delete succesfull.");
			} else {
				System.out.println("Delete NOT succesfull.");
			}
		} catch (ManagerException e) {
			System.err.print(e.getMessage());
		}
	}
	
}
