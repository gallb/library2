package edu.msg.library2client.console;

import java.util.Scanner;

import edu.msg.library2client.RmiRegistry;
import edu.msg.library2common.model.User;
import edu.msg.library2common.model.UserType;
import edu.msg.library2common.util.PropertyProvider;

public class ClientConsole {

	private Scanner scanner = new Scanner(System.in);

	public ClientConsole() {

	}

	public void startConsole() {
		System.out.println(PropertyProvider.INSTANCE.getProperty("welcome.message"));
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
		System.out.println(PropertyProvider.INSTANCE.getProperty("usename.message"));
		String userName = getLine();
		System.out.println(PropertyProvider.INSTANCE.getProperty("password.message"));
		String password = getLine();

		UserType loginString = registry.login(userName, password);
		if (loginString.equals(UserType.Invalid)) {
			System.out.println(PropertyProvider.INSTANCE.getProperty("uname_pass_try"));
			login();
		} else if (loginString.equals(UserType.Reader)) {
			System.out.println(PropertyProvider.INSTANCE.getProperty("reader.log"));
			while (true) {

			}
		} else if (loginString.equals(UserType.Admin)){
			System.out.println(PropertyProvider.INSTANCE.getProperty("admin.log"));
			while (true) {
			}
		}
	}
	
	

	public static void main(String[] args) {
		new ClientConsole().startConsole();
		User user=new User("Proba", "praba_user", 10, "pass", UserType.Admin);
		RmiRegistry registry = new RmiRegistry();
		
		
		
		
	}

}
