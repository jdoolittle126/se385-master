/**
 * 
 * Represents an object used to calculate the pay of an hourly employee, under normal circumstances.
 * 
 * <pre> 
 *    RegularPay regularPay = new RegularPay(11.50);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
*
 */
public class RegularPay extends PayCalculator {

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new instance of RegularPay, with the given hourly rate
	 * @param payRate The base hourly rate
	 */
	public RegularPay(double payRate) {
		changeRate(payRate);
	}


}
