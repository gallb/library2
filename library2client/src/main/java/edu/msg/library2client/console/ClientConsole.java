package edu.msg.library2client.console;

import java.util.Scanner;

import edu.msg.library2client.RmiRegistry;
import edu.msg.library2client.common.Clienthandler;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.util.PropertyProvider;

public class ClientConsole implements Clienthandler {

	private Scanner scanner = new Scanner(System.in);

	public ClientConsole() {

	}

	public void startConsole() {
		// System.out.println(PropertyProvider.INSTANCE.getProperty("welcome.message"));
		printMessage(PropertyProvider.INSTANCE.getProperty("welcome.message"));
		login();
	}

	public static void main(String[] args) {
		new ClientConsole().startConsole();
		User user = new User("Proba", "praba_user", 10, "pass", UserType.Admin);
		RmiRegistry registry = new RmiRegistry();

	}

	public void printMessage(String message) {
		System.out.println(message);

	}

	public String userInput() {
		String str = "";
		while (str.isEmpty()) {
			str = scanner.nextLine();
		}
		return str;
	}

	public void start() {
		// TODO Auto-generated method stub

	}

	public void login() {
		RmiRegistry registry = new RmiRegistry();
		// System.out.println(PropertyProvider.INSTANCE.getProperty("usename.message"));
		printMessage(PropertyProvider.INSTANCE.getProperty("usename.message"));
		String userName = userInput();
		// System.out.println(PropertyProvider.INSTANCE.getProperty("password.message"));
		printMessage(PropertyProvider.INSTANCE.getProperty("password.message"));
		String password = userInput();

		UserType loginString = registry.login(userName, password);
		if (loginString.equals(UserType.Invalid)) {
			// System.out.println(PropertyProvider.INSTANCE.getProperty("uname_pass_try"));
			printMessage(PropertyProvider.INSTANCE.getProperty("uname_pass_try"));
			login();
		} else if (loginString.equals(UserType.Reader)) {
			// System.out.println(PropertyProvider.INSTANCE.getProperty("reader.log"));
			printMessage(PropertyProvider.INSTANCE.getProperty("reader.log"));
			while (true) {

			}
		} else if (loginString.equals(UserType.Admin)) {
			// System.out.println(PropertyProvider.INSTANCE.getProperty("admin.log"));
			printMessage(PropertyProvider.INSTANCE.getProperty("admin.log"));
			while (true) {
			}
		}
	}

	public void execute() {
		// TODO Auto-generated method stub

	}

}
