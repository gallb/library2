/**
 * 
 */
package edu.msg.library2client.util;

import java.util.Scanner;

/**
 * @author gallb
 * @author kiska
 *
 */
public class ConsoleViewManager extends ViewManager {
	
	private Scanner scanner = new Scanner(System.in);
	
	public String userInput() {
		String str = "";
		while (str.isEmpty()) {
			str = scanner.nextLine();
		}
		return str;
	}
	
	public int numberChooser(int max) {
		int chosen;
		
		chosen = scanner.nextInt();
		
		if (chosen > 0 && chosen <= max){
			return chosen;
		}
		return -1;
	}
}
