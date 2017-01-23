/**
 * 
 */
package edu.msg.library2client.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import edu.msg.library2common.util.PropertyProvider;

/**
 * @author gallb
 *
 */
public abstract class AbstractCommand {
	private int id;
	private String name;
	private String triggerCharacter;
	private int parentID;
	private List<Integer> childList;;

	public AbstractCommand() {
		super();
	}

	public AbstractCommand(int id, String name, String triggerCharacter) {
		super();
		this.id = id;
		this.name = name;
		this.triggerCharacter = triggerCharacter;
		childList = new ArrayList<>();
		readChildList();
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
			// Scanner sc = new Scanner(new
			// File("edu/msg/library2client/resources/CommandTreeBoolMat"));
		/*	Scanner sc = new Scanner(new File(
					"C:\\Users\\gallb\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\CommandTreeBoolMat"));
			String line = sc.nextLine();
			System.out.println("line    " + line);
			while (sc.hasNextLine()) {
				System.out.println("before scanner");
				Scanner splittedLineScanner = new Scanner(line);
				System.out.println("id " + getId());
				int temp = splittedLineScanner.nextInt();
				System.out.println("temp " + temp);
				if (temp == getId()) {
					while (splittedLineScanner.hasNext()) {
						System.out.println("after scanner");
						if (splittedLineScanner.hasNextInt()) {
							addChild(splittedLineScanner.nextInt());
							return;
						}
					}
				}
				line = sc.nextLine();
			}*/
			Scanner sc = new Scanner(new File(
					"C:\\Users\\gallb\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\CommandTreeBoolMat"));
			
			while(sc.hasNextLine()){
				String  line = sc.nextLine();
			//	System.out.print(temp + "		");
				Scanner splitted = new Scanner(line);
				int firstInt = splitted.nextInt();
				System.out.println("if " + firstInt +  "==" + getId());
				if (firstInt == getId()){
				//	System.out.print("nr " + nr + " ");
					while(splitted.hasNextInt()){					
						//System.out.println(splitted.nextInt());
						childList.add(splitted.nextInt());
					}
				}	
				
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(PropertyProvider.INSTANCE.getProperty("client.command.config"));
		}
	}
}
