/**
 * 
 */
package edu.msg.library2client.controller.publication;

import edu.msg.library2client.controller.AbstractCommand;

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
		
	}
	
}
