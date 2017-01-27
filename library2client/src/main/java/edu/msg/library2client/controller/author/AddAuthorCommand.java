/**
 * 
 */
package edu.msg.library2client.controller.author;

import edu.msg.library2client.controller.AbstractCommand;

/**
 * @author nagys
 *
 */
public class AddAuthorCommand extends AbstractCommand{
	
	public AddAuthorCommand() {
		super(22,"client.command.author.add","client.command.author.add.button");
	}

	@Override
	public void execute() {
				
	}

}
