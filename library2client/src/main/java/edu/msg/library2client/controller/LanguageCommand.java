/**
 * 
 */
package edu.msg.library2client.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2client.util.ConsoleViewManager;
import edu.msg.library2client.util.ViewManager;

/**
 * @author gallb
 * @author kiska
 *
 */
public class LanguageCommand extends AbstractCommand{

	public LanguageCommand() {	
		super(4, "client.command.language", "client.command.language.button");
	}
	
	@Override
	public void execute() {
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\nagys\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\languages.cfg"));
			String line = scanner.nextLine();
			int i = 0;
			List<String> langList = new ArrayList();
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				langList.add(line);
				i++;
				System.out.println("(" + i + ") " + line);
			}
			scanner.close();
			System.out.println(ClientPropertyProvider.getProperty("client.command.language.chooseMessage"));
			int chosenLanguge = ViewManager.getViewManager("Console").numberChooser(i);
			ClientPropertyProvider.INSTANCE.setLocal(new Locale(langList.get(chosenLanguge - 1 )));
			CommandManager.commandList.forEach(e -> e.updatelabels());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
