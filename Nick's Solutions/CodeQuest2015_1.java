import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nick Palmer
 *
 */
public class CodeQuest2015_1 {
	public static void main(String[] args) {
		
		String filePath = "src\\CodeQuest2015Inputs\\Prob01.in.txt";
		String inputs[] = getInput(filePath);
		
		for(int i = 0; i < inputs.length; i++) {
			//Try parsing a number from the inputs
			try {
				Integer.parseInt(inputs[i]);
			} catch(NumberFormatException e) {
				//If parsing an integer from a line fails, then it is a valid name. Proper coding techniques!
				String[] names = inputs[i].toUpperCase().split(" ");
				System.out.println(names[0].substring(0, 1) + names[2].substring(0, 1) + names[1].substring(0, 1));
			}
			
		}
		
	}
	
	public static String[] getInput(String filename) {
		
		try {
			//Count the number of lines in the file
			BufferedReader counter = new BufferedReader(new FileReader(filename));
			int lines = 0;
			while(counter.readLine() != null) {
				lines++;
			}
			
			counter.close();
			
			//Shove the inputs into an array and return them
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String inputs[] = new String[lines];
			for(int i = 0; i < lines; i++) {
				inputs[i] = reader.readLine().trim();
			}
			
			reader.close();
			return inputs;
			
		} catch(FileNotFoundException fn) {
			System.out.println("File not found!");
			fn.printStackTrace();
		} catch(IOException io) {
			System.out.println("There was an error reading the file!");
			io.printStackTrace();
		}
		
		return null;
	}

}
