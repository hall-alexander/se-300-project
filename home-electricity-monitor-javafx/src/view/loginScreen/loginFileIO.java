package view.loginScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loginFileIO {

	private List<String> usernameList   = new ArrayList<String>();
	private List<String> passwordList   = new ArrayList<String>();
	private String[][] loginFile;


	private static Scanner scanner;

	public static void main (String args[]) {
		loginFileIO loginFileIO = new loginFileIO();
		loginInput loginInput = new loginInput();
		
		loginInput.createFile();
		
//		loginFileIO.createLogin();
//		loginFileIO.checkInput();
		System.out.println("what the fuck you are a cucumber");

	}

	public void createLogin() {

		scanner = new Scanner(System.in);
		System.out.println("Enter a Username:");
		String username = scanner.nextLine();
		System.out.println("\nEnter a Password:");
		String password = scanner.nextLine();

		usernameList.add(username);
		usernameList.toArray();
		passwordList.add(password);
		passwordList.toArray();

		loginFile = new String[usernameList.size()+1][passwordList.size()+1];

		for (int i=0; i<usernameList.size(); i++) {
			loginFile[i][0] = usernameList.get(i);
			for(int j=0;j<passwordList.size();j++) {
				loginFile[j][1] = passwordList.get(j);
			}
		}

		System.out.println("Login Saved!");

	}

	public void checkInput() {
		scanner = new Scanner(System.in);
		System.out.println("\nEnter a Username:");
		String username = scanner.nextLine();
		System.out.println("\nEnter a Password:");
		String password = scanner.nextLine();

		for(int i=0; i<loginFile.length; i++)
			if(username.equalsIgnoreCase(loginFile[i][0]) && password.equalsIgnoreCase(loginFile[i][1])) {
				System.out.println("Access Granted Dawg");
				break;
			} else {
				System.out.println("Access DENIED BITCH");
				break;
			}
	}
}


