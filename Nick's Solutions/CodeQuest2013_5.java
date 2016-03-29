import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * 
 */

/**
 * @author Team Null
 *
 */
public class CodeQuest2013_5 {
	public static void main(String[] args) {
		String filename = "src\\CodeQuest2013JudgingInputs\\Prob05.in.txt";
		
		String inputs[] = getInput(filename);
		int currentDate[] = getNumbers(inputs[0]);
		@SuppressWarnings("deprecation")
		Date current = new Date(currentDate[2] - 1900, currentDate[0] - 1, currentDate[0]);
		
		for (int x = 1; x < inputs.length; x++) {
			Date temp = getDate(inputs[x]);
			int timeDiff = (int)((current.getTime() - temp.getTime()) / (1000 * 60 * 60 * 24));
			if (timeDiff > 180) {
				System.out.println(inputs[x].split(":")[0] + ", " + timeDiff);
			}
		}

		
	}
	
	public static Date getDate(String dateNeeded) {
		String[] temp = dateNeeded.split(":");
		int[] dates = getNumbers(temp[1]);
		@SuppressWarnings("deprecation")
		Date fin = new Date(dates[2] - 1900, dates[0]-1, dates[1]);
		return fin;
	}
	
	public static int[] getNumbers(String date) {
		String dateNumbers[] = date.split("/");
		int dateInts[] = new int[3];
		
		for(int i = 0; i < dateInts.length; i++) {
			dateInts[i] = Integer.parseInt(dateNumbers[i]);
		}
		
		return dateInts;
	}
	
	
	public static String[] getInput(String filepath) {
		
		try {
			//Define the bufferedreader to count the number of lines in the file
			BufferedReader counter = new BufferedReader(new FileReader(filepath));
			
			//Count the number of lines
			int lines = 0;
			while((counter.readLine()) != null) {
				lines++;
			}
			
			counter.close();
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			
			//Fill an array with the inputs
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
			io.printStackTrace();
		}
		
		return null;
	}

}
