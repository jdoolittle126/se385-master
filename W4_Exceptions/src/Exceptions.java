import java.util.Scanner;

/**
 * 
 * Demonstrates simple exception usage for Week 4 
 *
 * @author Jonathan Doolittle, Ethan Markham, Saimer Nieves, Adam Moniz, Russel Souffrant
 * @version 0.1
 * @created Apr 23, 2021
*
 */
public class Exceptions {
	
	// Static variables for simplicity
	public static final int ARRAY_SIZE = 150;
	static int[] sampleArray = new int[ARRAY_SIZE];
	
	
	public static void main(String[] args) {
		
		// Static function to populate our array
		populateArray();
		
		// Create the scanner
		Scanner scanner = new Scanner(System.in);

		// Capture input in a try to ensure scanner is closed
		try {
			
			gatherInput(scanner);
			
		} catch (Exception e) {
			
			System.out.println("Whoops... An error occured");
			
		} finally {
			
			scanner.close();
			
		}
		
	}
	
	/**
	 * The logic of the exercise. Gathers input and notifies the user depending on the error
	 * @param scanner The scanner to gather data from
	 */
	private static int gatherInput(Scanner scanner) {
		
		// Loop to and continue to ask for input
		do {
			
			// Prompt the user
			System.out.println("Please enter an integer index: ");
			
			// Exception handling
			try {
				
				//First, try and parse the scanners value (This will throw a NumberFormatException if not a well formed int
				//Then, we can try and grab that index, this will throw an ArrayIndexOutOfBoundsException if not well formed index 
				System.out.println(String.format("The value at the index is %d", sampleArray[Integer.parseInt(scanner.next())]));
			
			} catch (NumberFormatException e) {
				
				//Error message for invalid input
				System.out.println("You entered a value that isn't a number! Make sure you enter an integer.");
			
			} catch(ArrayIndexOutOfBoundsException e) {
				
				//Error message for out of bounds input
				System.out.println("You entered a value that exceeds the size of our array! Try again!");
			
			}
			
			//Other exceptions will be handled by our driver to ensure the scanner is closed
			
		} while(true);	
		
	}
	
	/**
	 * Populates the static array with random numbers
	 * @param array
	 */
	private static void populateArray() {
		
		for (int i = 0; i < sampleArray.length; i++) {
			sampleArray[i] = getRandomInt();
		}
		
	}
	
	/**
	 * Returns a random int, from 0 to 10000 inclusive (provided with the lab)
	 * @return The random value
	 */
	private static int getRandomInt() {
		return (int)(Math.random() * 10000);
	}

}
