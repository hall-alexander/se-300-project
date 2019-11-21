package view.loginScreen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class loginRead {

	private List<String> usernameList   = new ArrayList<String>();
	private List<String> passwordList   = new ArrayList<String>();
	private String[][] loginFile;


	public void readLogin(String filename, String username, String password) {
		// read from the file using a bufferedReader
		try {
			//make file of all existing file
			File fileRead = new File(filename+ ".csv");
			// make file reader
			FileReader fileReader = new FileReader(fileRead);
			// buffer the file reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// make the string line
			String line;



			while ( (line = bufferedReader.readLine() )!= null ) {
				try {
					System.out.println(line);
					String[] splitLin = line.split(",");
					usernameList.add(splitLin[0]);
					usernameList.toArray();
					passwordList.add(splitLin[1]);
					passwordList.toArray();

					loginFile = new String[usernameList.size()][passwordList.size()];

					for(int i=0; i<loginFile.length; i++)
						if(username.equalsIgnoreCase(splitLin[0]) && password.equalsIgnoreCase(splitLin[1])) {
							System.out.println("Access Granted Dawg");
							break;
						} else {
							System.out.println("Access DENIED BITCH");
							break;
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			bufferedReader.close();

		}catch( Exception e ){
			e.printStackTrace();
		}		
	}
	
	//write to and save the file so then when the login is run single handedly itll check the login and say if it accepted or not
	

}