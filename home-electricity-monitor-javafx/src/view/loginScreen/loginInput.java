package view.loginScreen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class loginInput {
	
	private static File loginFile;


	public void saveLogin(String filename, String username, String password) {


		try {
			//create the file
			loginFile = new File(filename + ".csv");
			//write to the file
			FileWriter fileWriter = new FileWriter(loginFile);
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