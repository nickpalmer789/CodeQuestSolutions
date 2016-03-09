import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nick Palmer Validates a book's International Standard Book Number
 */
public class CodeQuest5 {
	public static void main(String[] args) {
		//Define the paths for the example and judging IO files, making it easier to switch for testing
		String examplePath = "CodeQuestInputs\\Prob05.in.txt";
		
		//Get the inputs
		String lines[] = getInput(examplePath);
		
		//Loop through the inputs
		for(int i = 0; i < lines.length; i++) {
			int isbn[] = filterSeparators(lines[i]);
			validateISBN(isbn);
		}	
	}
	
	//Validates the ISBN which is input as an array
	public static void validateISBN(int isbn[]) {
		int checksum = 0;
		int sumDifference = 0;
		for(int i = 0; i < isbn.length; i++) {
			if(i % 2 == 0) {
				checksum += isbn[i];
			} else {
				checksum += (isbn[i] * 3);
			}
			
			if(i == isbn.length - 2) {
				sumDifference = checksum;
			}
		}
		
		//Check whether the checksum is a multiple of 10
		if(checksum % 10 == 0) {
			System.out.println("VALID");
		} else {
			int validSum = (int)(Math.ceil( sumDifference / 10.0) * 10);
			System.out.println(validSum - sumDifference);
		}
		
	}
	
	//Filters out all of the integers from their separating characters
	public static int[] filterSeparators(String line) {
		//Define the final integer array which will have a length of 13
		int isbn[] = new int[13];
		int index = 0;
		
		for(int i = 0; i < line.length(); i++) {
			//If the character at i is a number then put it in the array
			if(isANumber(line.charAt(i))) {
				isbn[index] = Character.getNumericValue(line.charAt(i));
				index++;
			}
		}
		
		return isbn;
	}
	
	//Returns true if the input character is a number
	public static boolean isANumber(char input) {
		switch(input) {
		case '0':
			return true;
		case '1':
			return true;
		case '2':
			return true;
		case '3':
			return true;
		case '4':
			return true;
		case '5':
			return true;
		case '6':
			return true;
		case '7':
			return true;
		case '8':
			return true;
		case '9':
			return true;
		default:
			return false;
		}
	}
	

	// Gets the input from the file specified, and returns all of the lines as
	// an array. Can be adapted to any data type
	public static String[] getInput(String filePath) {
		String path = filePath;

		try {
			// Create the BufferedReader to count lines
			BufferedReader counter = new BufferedReader(new FileReader(path));

			int lines = 0;
			// Count the lines in the file
			while ((counter.readLine()) != null) {
				lines++;
			}

			String inputs[] = new String[lines];
			counter.close();

			// Create a BufferedReader to get the lines and put them into an
			// array
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// Read the lines and put them into an array
			for (int i = 0; i < lines; i++) {
				inputs[i] = reader.readLine().trim();
			}

			// Close the reader
			reader.close();

			// Return the inputs as an array
			return inputs;

		} catch (FileNotFoundException fne) {
			System.out.println("There was a problem opening the file.");
			fne.printStackTrace();
		} catch (IOException io) {
			System.out.println("There was a problem with the file.");
			io.printStackTrace();
		} catch (NumberFormatException num) {
			System.out.println("There was a problem reading the input. A datatype other than a String was entered");
		}
		return null;
	}
}
