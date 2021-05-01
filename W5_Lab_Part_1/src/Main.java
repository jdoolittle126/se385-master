import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 * Week 5 Lab assignment. Due to the procedural nature of the problem, all data is stored in static LinkedLists.
 * 
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 1, 2021
 *
 */
public class Main {

	// Make these static so we can access them from other methods easily, to break up the logic
	static LinkedList<String> stadiumNames;
	static LinkedList<Double> gameRevenue;
	
	// Format our currency correctly
	static NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	
	public static void main(String[] args) {
		
		// Create the two lists as specified in lab instructions
		stadiumNames = new LinkedList<>();
		gameRevenue = new LinkedList<>();

		// Encapsulate in try to ensure scanner is always closed
		try (Scanner scanner = new Scanner(System.in)) {
			
			// Gathers input from the user and populates our list
			gatherInput(scanner);
			
			System.out.println("Data entry complete...");
			
			// Allows the user to search the entered data and see total revenue
			calculateData(scanner);

		} catch (Exception e) {
			// Feedback if an unexpected error occurs
			System.out.println("Whoops... An error occured: " + e.getMessage());

		}

	}	

	/**
	 * Gathers data for the assignment. Stores the data in two static linked lists and handles invalid input
	 * @param scanner The scanner to gather input from
	 */
	public static void gatherInput(Scanner scanner) {
		
		// Initial instructions and data entry message
		System.out.print("Start by entering a statium name, followed by a value.\n"
				+ "For example, '>Giants 1000' would be valid.\n"
				+ "Type done when you have finished data entry!\n"
				+ ">");
		
		// Start off by reading the first entry
		String input = cleanInput(scanner.nextLine());
					
		// Check if our input is an entry or the done command
		while(!isDone(input)) {
			
			// Catch bad input
			try {
				// Try to split the string on spaces. If this throws errors, we know the input was bad
				String[] data = input.split("\\s+");	
				
				// Try to parse the double. This comes first, since it could throw an error. 
				// That prevents the name from being added without a value
				gameRevenue.add(Double.parseDouble(data[1]));
				
				// Normalize the name, and append to our list
				stadiumNames.add(cleanInput(data[0]));
			} catch (Exception e) {
				// Provide feedback
				System.out.println("Hmm, that doesn't look quite right. Lets try again.");
			}
			
			// Re-prompt and prime for next loop
			System.out.print("Next Entry\n>");
			input = scanner.nextLine();
		}
		
	}
	
	/**
	 * Asks the user for a string and searches the entered data, outputting the total revenue of the search term, if any
	 * @param scanner The scanner to gather input from
	 */
	public static void calculateData(Scanner scanner) {
		
		// Initial instructions and data entry message
		System.out.print("Enter the name of a stadium to get the total revenue for\n>");
		
		// Read and clean the search string
		String search = cleanInput(scanner.nextLine());
		
		// Tells us if a match has been found, allowing us to provide better feedback
		boolean hasEntry = false;
		
		// Aggregates the total for the stadium selected
		double total = 0;
		
		// Iterate through all the names in our LinkedList
		for(int i = 0; i < stadiumNames.size(); i++) {
			
			// Check if the name matches the search criteria
			if(stadiumNames.get(i).equals(search)) {
				
				//Append the data to the total and mark that at least one entry has been found
				hasEntry = true;
				total += gameRevenue.get(i);
			}
		}
		
		//Change the output based on if an entry was found
		if(hasEntry) {
			System.out.println(String.format("The total revenue is %s!", 
					moneyFormatter.format(total)));
		} else {
			System.out.println("The selected stadium could not be found in the data!");
		}

	}
	
	/**
	 * Checks to see if the string matches the criteria to end data entry
	 * @param input The string to check
	 * @return boolean value, true if the statement matches done criteria, false if the statement does not match done criteria
	 */
	public static boolean isDone(String input) {
		return cleanInput(input).equals("done");
	}
	
	/**
	 * Cleans and normalizes an input. Removes extra spacing and converts to all lowercase for normalization
	 * @param input The string to clean
	 * @return The cleaned string
	 */
	public static String cleanInput(String input) {
		return input.trim().toLowerCase(); 
	}
	

}
