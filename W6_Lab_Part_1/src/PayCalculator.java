/**
 * 
 * Represents an object used to calculate the pay of an hourly employee
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 8, 2021
*
 */
public abstract class PayCalculator {

	// ******************************
	// Variables
	// ******************************
	
	private double payRate;

	// ******************************
	// Getters & Setters
	// ******************************

	/**
	 * Gets the current pay rate
	 * @return The current pay rate
	 */
	public double getPayRate() {
		return payRate;
	}
	
	// ******************************
	// Public methods
	// ******************************

	/**
	 * Gets the employee's pay, based on the number of hours worked
	 * @param hours The number of hours worked
	 * @return The earned pay of the employee
	 */
	public double getPay(double hours) {
		return hours * payRate;
	}
	
	/**
	 * Changes the payrate for this instance
	 * @param payRate The new pay rate 
	 */
	public void changeRate(double payRate) {
		this.payRate = payRate;
	}


}
