import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	static NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Hi! Let's figure out the cost of your next trip!");

		do {
			calculateTrip(scanner);
		} while (doRepeat(scanner));
		
		System.out.println("Thank you! Enjoy your trip(s)!");
		
		scanner.close();
		
	}
	
	public static void calculateTrip(Scanner scanner) {
	    double distance, mpg, ppg;
	    
	    System.out.println("We will need some basic info to get started...\n"
	    		+ "How many miles will you be driving? >");
	    distance = gatherInput(scanner);
	    
	    System.out.println(String.format("Great! A %s mile trip!\n"
	    		+ "What is the average MPG (miles per gallon) of your car? >", distance));
	    mpg = gatherInput(scanner);
	    
	    System.out.println("Excellent! And what is the average price per gallon of fuel right now? >");
	    ppg = gatherInput(scanner);
		
		System.out.println(String.format("Based on the data you provided, this trip looks like it will cost around %s!", 
				moneyFormatter.format((distance/mpg) * ppg)));
	    
	}
	
	public static boolean doRepeat(Scanner scanner) {
		System.out.println("Would you like to calculate another trip? Type (n) to exit >");
		return (!scanner.next().trim().equalsIgnoreCase("n"));
	}
	
	public static double gatherInput(Scanner scanner) {
		double value;
		try {
			value = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Hmm, that doesn't look quite right. Lets try again. >");
			scanner.next();
			value = gatherInput(scanner);
		}
		return value;
	}
	
	
	
}
