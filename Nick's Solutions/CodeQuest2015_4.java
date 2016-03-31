import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nick Palmer
 *
 */
public class CodeQuest2015_4 {
	public static void main(String[] args) {
		//Get the lines from the file
		String filepath = "src\\CodeQuest2015Inputs\\Prob04.in.txt";
		String inputs[] = getInputs(filepath);
		
		//Loop through the inputs
		for(int i = 1; i < inputs.length; i++) {
			
			//You don't need any of the information about the groups. If the line is not a conversion, don't do anything with it
			try {
				Integer.parseInt(inputs[i]); 
			} catch(NumberFormatException e) {
				//Check what the type of conversion was and convert it
				String filtered[] = inputs[i].split(" ");
				if(inputs[i].charAt(inputs[i].length() - 1) == 'C') {
					convertToFarenheight(Double.parseDouble(filtered[0]));
				} else {
					convertToCelcius(Double.parseDouble(filtered[0]));
				}
			}
		}

	}
	
	//Converts from farenheight to celcius and prints out the result
	public static void convertToCelcius(Double temp) {
		Double cTemp = ((5.0/9.0)*(temp - 32));
		//Round the number and print it
		cTemp = Math.round(cTemp * 10.0) / 10.0;
		System.out.println(temp + " F = " + cTemp + " C");
	}
	
	//Converts from Celsius to farenheight and prints out the result
	public static void convertToFarenheight(Double temp) {
		Double fTemp = ((temp * (9.0/5.0)) + 32);
		//Round the number and print it 
		fTemp = Math.round(fTemp * 10.0) / 10.0;
		System.out.println(temp + " C = " + fTemp + " F");
	}
	
	
	public static String[] getInputs(String filePath) {
		
		try {
			//Count the lines in the file
			BufferedReader counter = new BufferedReader(new FileReader(filePath));
			int lines = 0; 
			
			while(counter.readLine() != null) {
				lines++;
			}
			
			counter.close();
			
			//Shove the lines in the file into an array and return it
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String inputs[] = new String[lines];
			for(int i = 0; i < inputs.length; i++) {
				inputs[i] = reader.readLine().trim();
			}
			
			reader.close();
			
			return inputs;
			
			
		} catch(FileNotFoundException fn) {
			System.out.println("The file does not exist!");
			fn.printStackTrace();
		} catch(IOException io) {
			System.out.println("There was an error reading the file!");
			io.printStackTrace();
		}
		
		return null;
	}
}
