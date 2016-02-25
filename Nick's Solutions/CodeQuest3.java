import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nick Palmer Performs Pig Latin translation
 */
public class CodeQuest3 {

	public static void main(String[] args) {
		String lines[] = getInput("src\\CodeQuestInputs\\Prob04.in.txt");
		
		//Pig latinize all of the lines and print them out
		for(int i = 0; i < lines.length; i++) {
			pigLatinize(lines[i]);
		}
	}
	
	public static void pigLatinize(String line) {
		//Split the line into the various words
		String words[] = line.split(" ");
		
		//Loop through the words and pig latinize them
		for(int i = 0; i < words.length; i++) {
			if(isVowel(words[i].charAt(0))) {
				System.out.print(words[i] + "yay ");
			} else {
				//Get the first group of consonants
				int vowelIndex = 1;
				boolean foundVowel = false;
				do {
					//Check if the next character is a vowel
					if(words[i].charAt(vowelIndex - 1) == 'q' && words[i].charAt(vowelIndex) == 'u') {
						vowelIndex ++;
					} else if(isVowel(words[i].charAt(vowelIndex))) {
						foundVowel = true;
					} else {
						vowelIndex++;
					}
				} while(foundVowel == false);
				
				//Define the suffix and prefix
				String suffix = words[i].substring(0, vowelIndex);
				String prefix = words[i].substring(vowelIndex);
				
				//Print out the pig latinized version
				System.out.print(prefix + suffix + "ay ");
			}
		}
		System.out.print("\r");
		
	}

	public static boolean isVowel(char character) {
		switch(character) {
		case 'a':
			return true;
		case 'e': 
			return true;
		case 'i':
			return true;
		case 'o': 
			return true;
		case 'u':
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
				inputs[i] = reader.readLine();
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
