import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nick Palmer 
 * Code Quest Question Two: Deal the Cards
 */
public class CodeQuest2 {
	public static void main(String[] args) {
		//Get the input for the hands from the file
		String hands[] = getInput("src\\CodeQuestInputs\\Prob02.in.txt");
		
		//Loop through the hands and print out the results
		for(int i = 0; i < hands.length; i++) {
			System.out.println("HAND " + (i + 1));
			String cards[] = hands[i].split(" ");
			//Variables for storing the data
			int red = 0;
			int black = 0;
			int clubs = 0;
			int diamonds = 0;
			int hearts = 0;
			int spades = 0;
			int[] faceValues = new int[13	];
			
			//Loop through looking for color, suit, and face value
			for(int j = 0; j < cards.length; j++) {
				//If the card is a club
				if(Character.toLowerCase(cards[j].charAt((cards[j].length() - 1))) == 'c') {
					black++;
					clubs++;
					//Get the face value and put it in the appropriate index in faceValues[]
					int value = identifyFaceValue(cards[j].substring(0, cards[j].length() - 1));
					faceValues[value - 2]++;
				}
				//If the card is a diamond
				else if(Character.toLowerCase(cards[j].charAt((cards[j].length() - 1))) == 'd') {
					red++;
					diamonds++;
					//Get the face value and put it in the appropriate index in faceValues[]
					int value = identifyFaceValue(cards[j].substring(0, cards[j].length() - 1));
					faceValues[value - 2]++;
				}
				//If the card is a heart
				else if(Character.toLowerCase(cards[j].charAt((cards[j].length() - 1))) == 'h') {
					red++;
					hearts++;
					//Get the face value and put it in the appropriate index in faceValues[]
					int value = identifyFaceValue(cards[j].substring(0, cards[j].length() - 1));
					faceValues[value - 2]++;
				}
				//If the card is a spade
				else if(Character.toLowerCase(cards[j].charAt((cards[j].length() - 1))) == 's') {
					black++;
					spades++;
					//Get the face value and put it in the appropriate index in faceValues[]
					int value = identifyFaceValue(cards[j].substring(0, cards[j].length() - 1));
					faceValues[value - 2]++;
				}
			}
			
			//Print out the colors and suits
			System.out.println(red + "-RED");
			System.out.println(black + "-BLACK");
			System.out.println(clubs + "-CLUBS");
			System.out.println(diamonds + "-DIAMONDS");
			System.out.println(hearts + "-HEARTS");
			System.out.println(spades + "-SPADES");
			
			//Print out the face values
			for(int k = 0; k < faceValues.length; k++) {
				//Omit the value if it is equal to zero
				if(faceValues[k] != 0) {
					if(k != 9 && k != 10 && k != 11 && k != 12) {
						System.out.print(faceValues[k] + "-" + (k + 2) + " card");
						
						//Add the s if it is plural
						if(faceValues[k] > 1) {
							System.out.print("s\r");
						}
						else {
							System.out.print("\r");
						}
					} 
					else {
						//Print out the face cards
						switch(k) {
						case 9:
							System.out.print(faceValues[k] + "-Jack card");
							break;
						case 10:
							System.out.print(faceValues[k] + "-Queen card");
							break;
						case 11:
							System.out.print(faceValues[k] + "-King card");
							break;
						case 12:
							System.out.print(faceValues[k] + "-Ace card");
							break;
						}
						
						//Add the s and a carriage return if it is plural
						if(faceValues[k] > 1) {
							System.out.print("s\r");
						}
						else {
							System.out.print("\r");
						}
					}
					
				}
			}
			
		}
	}
	
	public static int identifyFaceValue(String inputChar) {
		String input = inputChar.toLowerCase();
		
		//Use a switch block to get the face value
		switch(input) {
		case "2": 
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "j":
			return 11;
		case "q":
			return 12;
		case "k":
			return 13;
		case "a":
			return 14;
		}
		return 0;
		
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
			
			//Close the reader
			reader.close();
			
			//Return the inputs as an array
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