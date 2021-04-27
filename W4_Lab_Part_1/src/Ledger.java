/**
 * 
 * Represents a ledger that records the sales for a store.
<pre> 
	Ledger ledger = new Ledger(10);
	ledger.addSale(3.52);
</pre>

 *
 * @author Jonathan Doolittle
 * @version 0.1
 * @created Apr 26, 2021
 * 
 */

public class Ledger {

	// ******************************
	// Variables
	// ******************************

	/**
	 * The max sales a ledger can hold, if no value is supplied
	 */
	private static final int DEFAULT_SALES_MAX = 50;
	
	private double[] sale;
	private int salesMade;
	private int maxSales;
	
	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new ledger with a max sales of {@value #DEFAULT_SALES_MAX}
	 */
	public Ledger() {
		this(DEFAULT_SALES_MAX);
	}
	
	/**
	 * Creates a new ledger with the provided maximum sales.
	 * @param maxSales The maximum amount of sale records this ledger can hold
	 */
	public Ledger(int maxSales) {
		this.maxSales = maxSales;
		sale = new double[maxSales];
		salesMade = 0;
	}

	// ******************************
	// Getters & Setters
	// ******************************
	
	// ******************************
	// Private methods
	// ******************************

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Adds a sale to this ledger. If the maximum capacity has been reached, no
	 * action is taken.
	 * @param The value of the sale to add
	 * @return The result of this action. true is returned if the record was appended, false indicates the ledger is full
	 */
	public boolean addSale(double value) {
		//Check for full ledger
		if(salesMade < maxSales) {
			//Append then advance the counter. This makes the counter human readable 
			//and keeps track of the array
			sale[salesMade++] = value;
			return true;
		}
		return false;
	}
	
	/**
	 * Gets all of the sales in the ledger
	 * @return The total value of all sales present in the ledger
	 */
	public double getTotalSales() {
		double total = 0;
		for(int i = 0; i < salesMade; i++) {
			total += sale[i];
		}
		return total;
	}
	
	/**
	 * Gets the number of sales this ledger has stored
	 * @return The count of sales on the ledger
	 */
	public int getNumberOfSales() {
		return salesMade;
	}
	
	/**
	 * Finds the average value of sales in this ledger. If no sales have been made, 0 is returned
	 * @return The average of all sales 
	 */
	public double getAverageSale() {
		if(getNumberOfSales() != 0) {
			return getTotalSales() / getNumberOfSales();
		}	
		return 0f;
	}
	
	/**
	 * Returns the total number of sales above the indicated target
	 * @param target The threshold for searching. Only values above target will be counted
	 * @return The number of sales with a value above the target
	 */
	public int getCountAbove(double target) {
		int counter = 0;
		for(int i = 0; i < salesMade; i++) {
			if(sale[i] > target) {
				counter++;
			}
		}
		return counter;
	}
	
	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String seperator = ", ";
		for(int i = 0; i < salesMade; i++) {
			sb.append(sale[i] + seperator);
		}		
		return sb.toString().substring(0, sb.length() - seperator.length());
	}
	

}
