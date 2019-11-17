package view.loginScreen;

import java.io.File;

public class loginFileIO {

	loginInput input = new loginInput();
	private File loginFile;

	public void main(String[] args) {
		loginInput.createFile(loginFile);
	}

	
	//makes objects of both reading and writing class
	//bind input varibable from scene builder into class that takes the input variable and writes it as a csv file
	//read class parses csv files and turns it into a 2d array
	//2d array is then used to check login info if it equals, should use table format from cs332 
	
	//if it does match both username and password, access will be granted and display next screen; if not, then try again (dont know if were gonna allow more than one try) 
	
}