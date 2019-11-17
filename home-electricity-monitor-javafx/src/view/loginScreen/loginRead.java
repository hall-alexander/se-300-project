import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class loginRead {

	private void parseFile() {
		// read from the file using a bufferedReader
		try {
			// make file reader
			FileReader fileReader = new FileReader(loginFile);
			// buffer the file reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// make the string line
			String line;


			while ( (line = bufferedReader.readLine() )!= null ) {
				System.out.println(line);
				String[] splitLin = line.split(",");
			}
			
			//write the file
			FileWriter fileWriter = new FileWriter(loginFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.newLine();
			
			bufferedWriter.close();

			// close the stream

			// close the stream
			bufferedReader.close();
		}catch( Exception e ){
			e.printStackTrace();
		}		
	}
}