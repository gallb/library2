package edu.msg.library2client.console;

import java.util.List;
import java.util.Scanner;

import edu.msg.library2client.Connection;
import edu.msg.library2client.common.Clienthandler;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.util.PropertyProvider;

public class ClientConsole implements Clienthandler {

	private Scanner scanner = new Scanner(System.in);
	Connection connection = new Connection();
	RmiRegistry registry = new RmiRegistry();

	public ClientConsole() {

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

	public void mennuForAdmin() {
		printMessage("1-Search for user");
	}

	public void start() {
		printMessage(PropertyProvider.INSTANCE.getProperty("welcome.message"));
		login();
	}

	public void login() {
	//	Connection registry = new Connection();
		printMessage(PropertyProvider.INSTANCE.getProperty("usename.message"));
		String userName = userInput();
		printMessage(PropertyProvider.INSTANCE.getProperty("password.message"));
		String password = userInput();

		UserType loginString = connection.login(userName, password);
		if (loginString.equals(UserType.Invalid)) {
			printMessage(PropertyProvider.INSTANCE.getProperty("uname_pass_try"));
			login();
		} else if (loginString.equals(UserType.Reader)) {
			printMessage(PropertyProvider.INSTANCE.getProperty("reader.log"));
			while (true) {

			}
		} else if (loginString.equals(UserType.Admin)) {
			printMessage(PropertyProvider.INSTANCE.getProperty("admin.log"));
			mennuForAdmin();
		//	while (true) {
				execute();
			//}
		}
	}

//	private void getUserByName() {
//		List<User> users = registry.getUserByName(userInput());
//		for (User user : users) {
//			printMessage(user.getName());
//		}
//
//	}

	public void execute() {
		int admincmd = scanner.nextInt();
		switch (admincmd) {
		case 1:
			String userName = userInput();
			registry.getUserByName(userName);
			break;

		default:
			break;
		}
	}

	public static void main(String[] args) {
		new ClientConsole().start();
		// User user = new User("Proba", "praba_user", 10, "pass",
		// UserType.Admin);
		Connection registry = new Connection();

	}

}
