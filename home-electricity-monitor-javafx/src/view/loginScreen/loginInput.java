package view.loginScreen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class loginInput {
	
	private static File loginFile = new File("loginFile.csv");



	public void saveLogin(String filename, String username, String password) {


		try {
			//write to the file
			FileWriter fileWriter = new FileWriter(loginFile, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(username + ',' + password);
			bufferedWriter.newLine();
			bufferedWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Login Saved!");
	}
}