import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nick Palmer 
 * Code Quest Question One: When I say Code you say Quest!
 */
public class CodeQuest1 {
	public static void main(String[] args) {
		int num[] = getInput(
				"src\\CodeQuestInputs\\Prob01.in.txt");

		// Run through the possible scenarios for what to output
		for (int i = 0; i < num.length; i++) {
			if (num[i] % 3 == 0 && num[i] % 7 == 0) {
				System.out.println("CODEQUEST");
			} else if (num[i] % 3 == 0 && num[i] % 7 != 0) {
				System.out.println("CODE");
			} else if (num[i] % 7 == 0 && num[i] % 3 != 0) {
				System.out.println("QUEST");
			} else {
				System.out.println(num[i]);
			}
		}
	}

	// Gets the input from the file specified, and returns all of the lines as
	// an array. Can be adapted to any data type.
	public static int[] getInput(String filePath) {
		String path = filePath;

		try {
			// Create the BufferedReader to count lines
			BufferedReader counter = new BufferedReader(new FileReader(path));

			int lines = 0;
			// Count the lines in the file
			while ((counter.readLine()) != null) {
				lines++;
			}

			int inputs[] = new int[lines];
			counter.close();

			// Create a BufferedReader to get the lines and put them into an
			// array
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// Read the lines and put them into an array
			for (int i = 0; i < lines; i++) {
				inputs[i] = Integer.parseInt(reader.readLine());
			}
			reader.close();
			return inputs;

		} catch (FileNotFoundException fne) {
			System.out.println("There was a problem opening the file.");
			fne.printStackTrace();
		} catch (IOException io) {
			System.out.println("There was a problem with the file.");
			io.printStackTrace();
		} catch (NumberFormatException num) {
			System.out.println("There was a problem reading the input. A datatype other than an integer was entered");
		}
		return null;
	}

}