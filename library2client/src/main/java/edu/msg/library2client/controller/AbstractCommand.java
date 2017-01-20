/**
 * 
 */
package edu.msg.library2client.controller;

import java.util.List;

/**
 * @author gallb
 *
 */
public abstract class AbstractCommand {
	private int id;
	private String name;
	private String triggerCharacter;
	private int parentID;
	private List<Integer> childList;
	
	
	public abstract void execute();
	
	;
}
