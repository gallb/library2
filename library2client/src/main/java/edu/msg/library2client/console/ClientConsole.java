package edu.msg.library2client.console;

import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import edu.msg.library2client.Connection;
import edu.msg.library2client.RmiRegistry;
import edu.msg.library2client.common.Clienthandler;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.util.PropertyProvider;

public class ClientConsole implements Clienthandler {

	private Scanner scanner = new Scanner(System.in);
	Connection connection = new Connection();
	RmiRegistry registry = new RmiRegistry();
	List<Publication> publications;
	List<User> users;
	private int book;

	public ClientConsole()  {

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
		printMessage("(U)User management" + " " + "(B)Book manegement");

	}

	public void menuForUserManagement() {
		printMessage("(S)Serach user by name" + " " + "(I)Insert user" + " " + "(M)Main menu");
	}

	public void menuForPublicationSearch() {
		printMessage("(S)Serach book by title" + " " + "(M)Main menu");
	}

	public void menuForPublicationManagement() {
		printMessage("(B)Borow book" + " " + "(M)Publication Menu");
	}

	public void start() {
		printMessage(PropertyProvider.INSTANCE.getProperty("welcome.message"));
		login();
	}

	public void login() {
		// Connection registry = new Connection();
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

			execute();

		}
	}

	private boolean getUserByName() {
		users = registry.getUserByName(userInput());
		if (users.isEmpty()) {
			System.out.println("Didn't find any result for your serch.");
			return false;
		} else {
			for (int i = 0; i < users.size(); ++i) {
				printMessage("\t" + "Name" + "\t" + "Username");
				printMessage((i + 1) + " \t" + users.get(i).getName() + "\t" + users.get(i).getUserName());

			}
			return true;
		}

	}

	private void getPublicationByName() {
		publications = registry.getPublicationByName("%" + userInput() + "%");
		if (!publications.isEmpty()) {
			for (int i = 0; i < publications.size(); ++i) {
				printMessage((i + 1) + "-" + publications.get(i).getTitle() + " Publisher: " +publications.get(i).getPublisher().getName());
			}
			printMessage("For publication management please input the book number!");
		} else {
			printMessage("Didn't find any result for your serch.");
		}
	}

	private void createNewUser() {
		printMessage("Enter Name:");
		String name = userInput();
		printMessage("Enter Username:");
		String userName = userInput();
		printMessage("Enter user type:(1)Admin (2)Reader");
		boolean flag = true;
		String type;
		UserType userType = null;
		while (flag) {
			type = userInput();

			if (type.equals("1")) {
				flag = false;
				userType = UserType.Admin;
			} else if (type.equals("2")) {
				flag = false;
				userType = UserType.Reader;
				type = "Reader";
			} else {
				printMessage("Invalid command");
			}
		}
		printMessage("Enter password:");
		String password = userInput();
		if (userType == null) {
			System.out.println("Invalid login access!");
		} else {
			/*if (registry.insertUser(name, userName, userType, 10, password)) {
				System.out.println("Create successful!");
			} else {
				System.out.println("Create not successful!");
			}*/
		}
	}

	private void addNewBorrow(int book) {
		printMessage("Enter reader name to search for");
		if (getUserByName()) {

			printMessage("Enter user number");
			User user = users.get(Integer.parseInt(userInput()) - 1);
			Publication publication = publications.get(book - 1);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			printMessage("Borrow from");
			printMessage(dtf.format(localDate));
			boolean flag = true;
			Date from =  Date.valueOf(LocalDate.of(0, 0, 0));
			while (flag) {
				printMessage("(1)Accept date" + " " + "(2)Enter other date");
				String aceptreject = userInput();
				if (aceptreject.equals("1")) {
					flag = false;
					from = Date.valueOf(localDate);
				} else if (aceptreject.equals("2")) {
					flag = false;
					printMessage("Year:");
					int year = Integer.parseInt(userInput());
					printMessage("Month:");
					int month = Integer.parseInt(userInput());
					printMessage("Day");
					int day = Integer.parseInt(userInput());
					from = Date.valueOf(LocalDate.of(year, month, day));
				} else {
					printMessage("Please try agian");
				}
			}
			printMessage("Borrow until");
			localDate = LocalDate.now().plusDays(20);
			printMessage(dtf.format(localDate));
			Date until = Date.valueOf(LocalDate.of(0, 0, 0));
			flag = true;
			while (flag) {
				printMessage("(1)Accept date" + " " + "(2)Enter other date");
				String aceptreject = userInput();
				if (aceptreject.equals("1")) {
					flag = false;
					until = Date.valueOf(localDate);
				} else if (aceptreject.equals("2")) {
					flag = false;
					printMessage("Year:");
					int year = Integer.parseInt(userInput());
					printMessage("Month:");
					int month = Integer.parseInt(userInput());
					printMessage("Day");
					int day = Integer.parseInt(userInput());
					until = Date.valueOf(LocalDate.of(year, month, day));
				} else {
					printMessage("Please try agian");
				}
			}

		/*	if (registry.publicationBorrow(user, publication, from, until)) {
				printMessage("Borrow success");
			} else {
				printMessage("Borrow fail");
			}*/
		} else {
			addNewBorrow(book);
		}
	}

	public void execute() {
		while (true) {
			mennuForAdmin();
			String admincmd = scanner.nextLine();
			switch (admincmd) {
			case "U":
				userManagment();
				break;
			case "B":
				bookManagement();
				break;
			default:
				printMessage("Invalid command");
			}
		}
	}

	public void userManagment() {
		boolean flag = true;
		 {

			menuForUserManagement();
			String admincmd = scanner.nextLine();
			switch (admincmd) {
			case "S":
				printMessage("Please enter the name of user who serach");
				getUserByName();
				break;
			case "I":
				createNewUser();

			case "M":
				flag = false;
			default:
				printMessage("Invalid command");

			}
		}
	}

	public void bookManagement() {
		boolean flag = true;
		while (flag) {
			menuForPublicationSearch();
			String admincmd = scanner.nextLine();
			try {
				book = Integer.parseInt(admincmd);
				admincmd = "B";
			} catch (Exception e) {

			}
			switch (admincmd) {
			case "S":
				printMessage("Please enter the publication title");
				getPublicationByName();
				break;
			case "B":
				bookBorow();
				break;
			case "M":
				flag = false;
				break;
			default:
				printMessage("Invalid command");

			}

		}
	}

	public void bookBorow() {
		menuForPublicationManagement();
		String admincmd = userInput();
		switch (admincmd) {
		case "B":
			addNewBorrow(book);
			break;
		case "M":
			break;
		default:
			printMessage("Invalid command");
		}

	}

	public static void main(String[] args) throws RemoteException {
		new ClientConsole().start();
	}

}
