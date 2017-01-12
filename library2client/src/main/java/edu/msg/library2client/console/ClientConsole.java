package edu.msg.library2client.console;

import java.io.Console;
import java.util.Scanner;

import edu.msg.library2client.RmiRegistry;
import edu.msg.library2common.model.UserType;

public class ClientConsole {

	private Scanner scanner = new Scanner(System.in);

	public ClientConsole() {

	}

	public void startConsole() {
		System.out.println("Welcom to .msg library!");
		login();
	}

	private String getLine() {
		String str = "";
		while (str.isEmpty()) {
			str = scanner.nextLine();
		}
		return str;
	}

	private void login() {
		RmiRegistry registry = new RmiRegistry();
		System.out.println("Enter your user name");
		String userName = getLine();
		System.out.println("Enter your password");
		String password = getLine();

		String loginString = registry.login(userName, password);
		if (loginString.equals("0")) {
			System.out.println("Invalid user name and password,try again!");
			login();
		} else if (loginString.equals("1")) {
			System.out.println("Logged in as reder...");
			while (true) {

			}
		} else {
			System.out.println("logged in as admin...");
			while (true) {

			}
		}
	}

	public static void main(String[] args) {
		new ClientConsole().startConsole();
	}

}
