package view.loginScreen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class loginInput {

	public void createFile(File loginFile) {
		loginFile = new File("loginFile.csv");

		try {
			//write the file
			FileWriter fileWriter = new FileWriter(loginFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("I am a cheesecake");
			bufferedWriter.newLine();
			bufferedWriter.write("please bring me death");
			bufferedWriter.newLine();

			bufferedWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}