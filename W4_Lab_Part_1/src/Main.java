/**
 * Driver program for Week 4 Lab
 * @author Jonathan Doolittle
 * @version 0.1
 * @created Apr 26, 2021
*
 */
public class Main {

	public static void main(String args[]) {
	
		//Demo the solution works using the data provided
		System.out.println("Creating a ledger of size 10");
		
		Ledger ledger = new Ledger(10);
		
		System.out.println("Adding sales 3.52, 2.43, 9.00, 3.5, 5.0");
		
		ledger.addSale(3.52);
		ledger.addSale(2.43);
		ledger.addSale(9.00);
		ledger.addSale(3.5);
		ledger.addSale(5.0);
		
		System.out.println("Output: " + ledger.toString());
		System.out.println("The total number of sales are: " + ledger.getNumberOfSales());
		System.out.println("The total amount of sales is: " + ledger.getTotalSales());
		System.out.println("The average amount for a sale is: " + ledger.getAverageSale());
		System.out.println("The number of sales greater than 3.5 is: " + ledger.getCountAbove(3.5f));
		System.out.println("The number of sales greater than 3.0 is: " + ledger.getCountAbove(3f));
		
		//Example of a safeguard against bad input
		System.out.println("Try to overfill the ledger...");
		ledger.addSale(3.52);
		ledger.addSale(2.43);
		ledger.addSale(9.00);
		ledger.addSale(3.5);
		ledger.addSale(5.0);
		ledger.addSale(3.52);
		ledger.addSale(2.43);
		ledger.addSale(9.00);
		ledger.addSale(3.5);
		
		System.out.println("Was this sale successful since the ledger is full? " + (ledger.addSale(5.0) ? "yes" : "no"));
		System.out.println("Output of the ledger: " + ledger.toString() + " (10 items)");
		
		
		
	}

}
