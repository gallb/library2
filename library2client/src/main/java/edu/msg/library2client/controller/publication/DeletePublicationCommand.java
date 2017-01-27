/**
 * 
 */
package edu.msg.library2client.controller.publication;

import edu.msg.library2client.controller.AbstractCommand;
import edu.msg.library2client.controller.CommandManager;
import edu.msg.library2client.manager.ManagerException;
import edu.msg.library2client.manager.PublicationManager;
import edu.msg.library2client.util.ViewManager;

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
		System.out.println("Are you sure you want to delete: " + CommandManager.pub.getTitle() + "?");
		System.out.println("(1)Yes (2)No");
		int choose = ViewManager.getViewManager("Console").numberChooser(2);
		if (choose == 1) {
			try {
				if (pubMan.deleteEntity(CommandManager.pub.getUuid())) {
					System.out.println("Delete succesfull.");
				} else {
					System.out.println("Delete NOT succesfull.");
				}
			} catch (ManagerException e) {
				System.err.print(e.getMessage());
			}
		}
		else {
			System.out.println("Delete cancelled.");
		}
	}
	
}
