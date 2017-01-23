/**
 * 
 */
package edu.msg.library2client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

/**
 * @author gallb
 *
 */
public class CommandManager{
	private List <AbstractCommand> commandList;
	private AbstractCommand currentCommand;
	private AbstractCommand previousCommand;
	private Scanner scanner = new Scanner(System.in);
	
	public CommandManager () {
		ExitCommand exitCommand = new ExitCommand();
		commandList = new ArrayList<>();
		commandList.add(exitCommand);
		commandList.add( new MainCommand());
		commandList.add(new SearchPubCommand());
	}
			
	public void run() {
		currentCommand = commandList.get(1);
		
		while (!((ExitCommand)getCommandByID(0)).isExitFlag() ) {
			printChilds();
			System.out.println("Please enter command letter!");
			String selection = userInput();
			List<AbstractCommand> commands = new ArrayList<>();
			commands.addAll(commandList.stream().filter(element -> element.getTriggerCharacter().equals(selection)).collect(Collectors.toList())); 
			if (!commands.isEmpty()) {
				previousCommand = currentCommand;
				currentCommand = commands.get(0);
				currentCommand.execute();
			} else {
				System.out.println("Invalid command.");
			}
		}
	}
	
	private void printChilds(){
		List<AbstractCommand> commands = new ArrayList<>();
		List<Integer> childs = currentCommand.getChildList();
		for (Integer i : childs){
			commands.addAll(commandList.stream().filter(child -> (child.getId()==i)).collect(Collectors.toList()));
		}
		commands.forEach(c -> System.out.println("(" + c.getTriggerCharacter() + ")" + c.getName() + " "));
	}
	
	private AbstractCommand getCommandByID(int id) {
		for (int i = 0; i < commandList.size(); i++) {
			if (commandList.get(i).getId() == id) {
				return commandList.get(i);
			}
		}
		return null;
	}
	
	private AbstractCommand getCommandByTrigger(String character) {
		for (int i = 0; i < commandList.size(); i++) {
			if (commandList.get(i).getTriggerCharacter().equals(character)) {
				return commandList.get(i);
			}
		}
		return null;
	}
	
	public String userInput() {
		String str = "";
		while (str.isEmpty()) {
			str = scanner.nextLine();
		}
		return str;
	}
}
