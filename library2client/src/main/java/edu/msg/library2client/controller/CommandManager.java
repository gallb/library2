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
import javax.swing.text.View;

import edu.msg.library2client.controller.borrow.BorrowManagementCommand;
import edu.msg.library2client.controller.borrow.SearchBorrowCommand;
import edu.msg.library2client.controller.publication.AddPublicationCommand;
import edu.msg.library2client.controller.publication.DeletePublicationCommand;
import edu.msg.library2client.controller.publication.EditPublicationCommand;
import edu.msg.library2client.controller.publication.PublicationManagementCommand;
import edu.msg.library2client.controller.publication.SearchPubCommand;
import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ConsoleViewManager;
import edu.msg.library2client.util.ViewManager;

/**
 * @author gallb
 *
 */
public class CommandManager{
	public static List <AbstractCommand> commandList;
	private AbstractCommand currentCommand;
	private AbstractCommand previousCommand;
	
	public CommandManager () {
		commandList = new ArrayList<>();
		commandList.add(new ExitCommand());
		commandList.add(new MainCommand());
		commandList.add(new SearchPubCommand());
		commandList.add(new SettingsCommand());
		commandList.add(new LanguageCommand());
		commandList.add(new PublicationManagementCommand());
		commandList.add(new AddPublicationCommand());
		commandList.add(new DeletePublicationCommand());
		commandList.add(new EditPublicationCommand());
		commandList.add(new AuthorManagementCommand());
		commandList.add(new BorrowManagementCommand());
		commandList.add(new SearchBorrowCommand());
		//commandList.add(new SearchAuthorCommand());
	}
			
	public void run() {
		currentCommand = commandList.get(1);
		
		while (!((ExitCommand)getCommandByID(0)).isExitFlag() ) {
			printChilds();
			System.out.println(ClientPropertyProvider.getProperty("client.command.input"));
			String selection = ViewManager.getViewManager("Console").userInput();
			List<AbstractCommand> commands = new ArrayList<>();
			//Needs Update
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
		commands.forEach(c -> System.out.print("(" + c.getTriggerCharacter() + ")" + c.getName() + "	"));
		System.out.println();
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
}
