/**
 * 
 */
package edu.msg.library2client.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import edu.msg.library2client.util.ClientPropertyProvider;
import edu.msg.library2common.util.PropertyProvider;

/**
 * @author gallb
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Command cmd = new Command(Login);
		
		//cmd.execute();
		try {

//			Scanner scanner = new Scanner(new File("C:\\Users\\nagys\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\languages.cfg"));
			Scanner scanner = new Scanner(new File("C:\\Users\\nagys\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\CommandTreeBoolMat"));
			//Scanner scanner = new Scanner(new File("C:\\Users\\gallb\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\languages.cfg"));

			//Scanner scanner = new Scanner("edu/msg/library2client/resources/languages.cfg");
			//Scanner scanner = new Scanner(new File("C:\\Users\\barni\\git\\library2\\library2client\\src\\main\\java\\edu\\msg\\library2client\\resources\\languages.cfg"));
			String line = scanner.nextLine();
			scanner.close();
			ClientPropertyProvider.INSTANCE.setLocal(new Locale(line));
		}  //catch (InputMismatchException e){
		catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommandManager commandManager = new CommandManager();
		
		commandManager.run();
	}

}
