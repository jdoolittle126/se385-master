import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 * Driver program for week 6 lab, part 1. Demonstrates the function of differing types of PaymentCalculator
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
*
 */
public class Main {

	// A nice way to format currency
	private static NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	
	public static void main(String[] args) {
		
		// Create our pay objects
		RegularPay regularPay = new RegularPay(7.5);
		HazardPay hazardPay = new HazardPay(7.5);
		
		// Print the results
		print(40, regularPay);
		print(40, hazardPay);
		
		// Change to pay rate to $17
		regularPay.changeRate(17);
		hazardPay.changeRate(17);
		
		// Reprint results
		print(40, regularPay);
		print(40, hazardPay);

	}
	
	/**
	 * Prints out information on the pay and conditions in the format of "[Condition]: [hours] hours pay at [rate]/hr is [total]"
	 * @param hours The amount of hours worked
	 * @param payment The payment calculator to use for computation
	 */
	public static void print(double hours, PayCalculator payment) {
		
		System.out.println(String.format("%s: %.1f hours pay at %s/hr is %s", 
				payment.getClass().getName(), // Name
				hours, // Hours
				asUsd(payment.getPayRate()), // Rate
				asUsd(payment.getPay(hours))));	 // Total pay
	}
	
	/**
	 * Returns the double as a formated currency string
	 * @param value The double
	 * @return The value as a currency string
	 */
	public static String asUsd(double value) {
		return moneyFormatter.format(value);
	}


}
