/**
 * @author Jonathan Doolittle
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
				
		//Create input capture for the game
		Scanner scanner = new Scanner(System.in);

		//Encapsulate in try to ensure scanner is always closed
		try {
			
			gatherInput(scanner);
			
		} catch (Exception e) {
			
			System.out.println("Whoops... An error occured " + e.getMessage());
			
		} finally {
			
			scanner.close();
			
		}
		
	}
	
	/**
	 * The logic of the exercise. Gathers values until 0 is entered. This data is processed for
	 * frequency of values and maximum of values
	 * @param scanner The scanner to gather data from
	 */
	private static void gatherInput(Scanner scanner) {
		
		//Start with two strings. One for the message, and the other for our data
		String output = "Enter Integers. Entering 0 ends the capture: ";
		
		//An array list for storing our values as they come in
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//A variable to hold the value of each input temporarily
		int value;
		
		do {
			
			/* Flush the buffer and reprint. This is somewhat of a hack 
			 * but it intents to comply with the assignment's instructions */
			bufferFlushAndPrint(output);
			
			//Grab the next int. Assume valid input as instructed.
			value = scanner.nextInt();
			
			//Append to visual & list
			numbers.add(value);
			output += value + " ";
			
		} while(value != 0);
		
		//Pop the ending 0 from the stack
		numbers.remove(numbers.size() - 1);		
		
		//HashSet for quick frequency count
		HashSet<Integer> number_sets = new HashSet<Integer>(numbers);
		
		//HashMap for histogram data count
		HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
		
		
		for(int unique : number_sets) {
			//Map <Value, Frequency>
			histogram.put(unique, Collections.frequency(numbers, unique));
		}
		
		//Grab the largest value
		int largest = Collections.max(numbers);

		//Showcase data collected
		System.out.println(String.format("The largest number is %d... It occured %d times!", 
				largest, histogram.get(largest)));
				
		System.out.println("Still not sure? Heres a histogram!");
		
		System.out.println("#############################");
		
		//Because why not?
		for(int unique : number_sets) {
			
			String count = "";
			for(int i=0; i < histogram.get(unique); i++) {
				count += "X ";
			}
			
			System.out.println(String.format("# %02d | %s", unique, count));
			
		}
		
		System.out.println("#############################");
		
		
		
		
		
	}
	
	private static void bufferFlushAndPrint(String data) {
		//Drop 25 lines to create the illusion of buffer flush
		for(int i =0; i< 25; i++) {
			System.out.print("\r");
		}
		//Actually flush, just in case it's run on a console
	    System.out.flush();  
	    //Reprint
	    System.out.print(data);
	}
	
	
	

}