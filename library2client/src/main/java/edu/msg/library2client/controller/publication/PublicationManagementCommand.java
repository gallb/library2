/**
 * 
 */
package edu.msg.library2client.controller.publication;

import edu.msg.library2client.controller.AbstractCommand;

/**
 * @author gallb
 *
 */
public class PublicationManagementCommand extends AbstractCommand{

	public PublicationManagementCommand() {
		super(5,"client.command.pub.manage","client.command.pub.manage.button");
	}
	
	@Override
	public void execute() {		
	}

}
