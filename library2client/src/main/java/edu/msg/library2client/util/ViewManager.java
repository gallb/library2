/**
 * 
 */
package edu.msg.library2client.util;

import java.util.Scanner;

/**
 * @author gallb
 *
 */
public class ViewManager {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static String userInput() {
		String str = "";
		while (str.isEmpty()) {
			str = scanner.nextLine();
		}
		return str;
	}
	
	public static int numberChooser(int max) {
		int chosen;
		
		chosen = scanner.nextInt();
		
		if (chosen > 0 && chosen <= max){
			return chosen;
		}
		return -1;
	}
}
