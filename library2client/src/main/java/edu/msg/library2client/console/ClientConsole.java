package edu.msg.library2client.console;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import edu.msg.library2client.Connection;
import edu.msg.library2client.common.Clienthandler;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.service.rmi.BorrowServiceRmi;
import edu.msg.library2common.service.rmi.PublicationServiceRmi;
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
		printMessage("(U)User management" + " " + "(B)Book manegement");

	}

	public void menuForUserManagement() {
		printMessage("(S)Serach user by name" + " " + "(I)Insert user" + " " + "(M)Main menu");
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

			while (true) {
				execute();
			}
		}
	}

	private void getUserByName() {
		registry.getUserByName(userInput());

	}
	
	private void createNewUser(){
		String name = userInput();
		String userName = userInput();
		String type = userInput();
		String password = userInput();
		
		UserType userType = null;
		if (type.equals("Admin")) {
			userType = UserType.Admin;
		} else if (type.equals("Reader")) {
			userType = UserType.Reader;
		}
		if (userType == null) {
			System.out.println("Invalid login access!");
		} else {
			if (registry.insertUser(name, userName, userType, 10, password)) {
				System.out.println("Create successful!");
			} else {
				System.out.println("Create not successful!");
			}
		}
	}

	public void execute() {
		mennuForAdmin();
		String admincmd = scanner.nextLine();
		switch (admincmd) {
		case "U":
			userManagment();
			break;
		case "B":

		}
	}
	

	public void userManagment() {
		boolean field = true;
		while (field) {

			menuForUserManagement();
			String admincmd = scanner.nextLine();
			switch (admincmd) {
			case "S":
				printMessage("Please enter the name of user who serach");
				getUserByName();
				break;
			case "I":
				printMessage("Please enter:Name userName usertype password");
				createNewUser();
				break;
			case "M":
				field = false;

			}
		}
	}

	public static void main(String[] args) throws RemoteException {
		PublicationServiceRmi pubServiceRmi = null;
		Registry registry = null;
		try {
			 registry = LocateRegistry.getRegistry("localhost",
		
				Integer.parseInt((PropertyProvider.INSTANCE.getProperty("rmi_port"))));
			pubServiceRmi = (PublicationServiceRmi) registry.lookup(PublicationServiceRmi.RMI_NAME);
		} catch (Exception e){
			e.printStackTrace();
		}
		List<Publication> list = pubServiceRmi.searchForPublicationByTitle("Voros%");
		for (Publication p : list){
			System.out.println(p.getTitle());
		}
		
		BorrowServiceRmi borrowServiceRmi = null;
		try {
			borrowServiceRmi = (BorrowServiceRmi) registry.lookup(BorrowServiceRmi.RMI_NAME);
		} catch (Exception e){
			e.printStackTrace();
		}
		User tempUser = new User("tst", "tst", 10, "fds", UserType.Admin);
		tempUser.setUuid("112");
		Date date = new Date(2012, 01, 01);
		if (borrowServiceRmi.borrowPublication(tempUser, list.get(0),date, date)){
			System.err.println("borrow success");
		} else {
			System.err.println("borrow NOT successfull");
		}
		new ClientConsole().start();
		// User user = new User("Proba", "praba_user", 10, "pass",
		// UserType.Admin);
		//Connection registry = new Connection();

	}

}
