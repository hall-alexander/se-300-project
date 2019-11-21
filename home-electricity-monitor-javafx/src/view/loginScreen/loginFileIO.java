package view.loginScreen;


import java.util.Scanner;

public class loginFileIO {

	private static Scanner scanner;
	
	private static String filename = "loginFile";
	private static String username;
	private static String password;


	public static void main (String args[]) {
		
		loginInput loginInput = new loginInput();
		loginRead loginRead = new loginRead();
		
		scanner = new Scanner(System.in);
		System.out.println("Enter a Username:");
		username = scanner.nextLine();
		System.out.println("\nEnter a Password:");
		password = scanner.nextLine();
		
		//loginInput.saveLogin(filename, username, password);
		loginRead.readLogin(filename, username, password);		
		scanner.close();
		
		
	}

}


