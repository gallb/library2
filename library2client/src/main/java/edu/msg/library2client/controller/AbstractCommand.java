/**
 * 
 */
package edu.msg.library2client.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2common.util.PropertyProvider;

/**
 * @author gallb
 *
 */
public abstract class AbstractCommand {
	private int id;
	private String name;
	private String triggerCharacter;
	private String nameProperty;
	private String triggerCharacterProperty;
	private int parentID;
	private List<Integer> childList;;

	public AbstractCommand() {
		super();
	}

	public AbstractCommand(int id, String nameProperty, String triggerCharacterProperty) {
		super();
		this.id = id;
		this.nameProperty = nameProperty;
		this.triggerCharacterProperty = triggerCharacterProperty;
		updatelabels();
		childList = new ArrayList<>();
		readChildList();
	}

	public void updatelabels() {
		name = ClientPropertyProvider.getProperty(nameProperty);
		triggerCharacter = ClientPropertyProvider.getProperty(triggerCharacterProperty);
		
	}

	public abstract void execute();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTriggerCharacter() {
		return triggerCharacter;
	}

	public void setTriggerCharacter(String triggerCharacter) {
		this.triggerCharacter = triggerCharacter;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public List<Integer> getChildList() {
		return childList;
	}

	public void setChildList(List<Integer> childList) {
		this.childList = childList;
	}

	public void addChild(Integer child) {
		childList.add(child);
	}

	private void readChildList() {

		try {
			//Scanner sc = new Scanner("edu/msg/library2client/resources/CommandTreeBoolMat");
			/*Scanner sc = new Scanner(new File(
					"edu/msg/library2client/resources/CommandTreeBoolMat"));	*/
			Scanner sc = new Scanner(new File("C:\\Users\\gallb\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\CommandTreeBoolMat"));
			while(sc.hasNextLine()){
				String  line = sc.nextLine();
				Scanner splitted = new Scanner(line);
				int firstInt = splitted.nextInt();
				if (firstInt == getId()){
					while(splitted.hasNextInt()){					
						childList.add(splitted.nextInt());
					}
				}	
			}
		} //catch (InputMismatchException e) {
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(PropertyProvider.INSTANCE.getProperty("client.command.config"));
		}
	}
}
