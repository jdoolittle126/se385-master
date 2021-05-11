/**
 * 
 * Represents an object used to calculate the pay of an hourly employee, under hazardous circumstances. 
 * 
 * <pre> 
 *    HazardPay hazardPay = new HazardPay(20.00);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
*
 */
public class HazardPay extends PayCalculator {

	// ******************************
	// Variables
	// ******************************

	/**
	 * The multiplier for hazard pay when given the base hourly rate
	 */
	private static final double HAZARD_MULITPLIER = 1.5;
	
	// ******************************
	// Constructors
	// ******************************

	
	/**
	 * Creates a new instance of HazardPay, with the given base hourly rate
	 * @param payRate The base hourly rate
	 */
	public HazardPay(double payRate) {
		changeRate(payRate);
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public double getPay(double hours) {
		return super.getPay(hours) * HAZARD_MULITPLIER;
	}
	
	
}
