/**
 * 
 * IntegerCount takes in a value and reduces it by a value until it reaches a negative value.
 * These intermediate values are stored in an array, and can be aggregated or shown.
 * <pre> 
 *     IntegerCount integerCount1 = new IntegerCount(11);
 *     IntegerCount integerCount2 = new IntegerCount(90, 7);
 * </pre>

 * @author Jonathan Doolittle
 * @version 0.1 - Apr 28, 2021
 */

public class IntegerCount {

	// ******************************
	// Variables
	// ******************************
	
	/**
	 * The default count factor, if none is supplied
	 */
	private static final int DEFAULT_COUNT_FACTOR = 2;
	
	private int[] values;
	private int countFactor;
	private int startingValue;
	private int size;
	
	// ******************************
	// Constructors
	// ******************************
		
	/**
	 * Creates a new IntegerCount with a count factor of {@value #DEFAULT_COUNT_FACTOR}
	 * @param val The initial value that will be reduced. All values less than <code>val</code> to 0 will be stored. <code>val</code> will not be stored
	 * @exception Exception     
	 *              if the value entered to reduce is less than <code>0</code> 
	 */
	public IntegerCount(int val) throws Exception {
		this(val, DEFAULT_COUNT_FACTOR);
	}
	
	/**
	 * Creates a new IntegerCount
	 * @param val The initial value that will be reduced. All values less than <code>val</code> to 0 will be stored. <code>val</code> will not be stored
	 * @param count The factor to count down by
	 * @exception Exception     
	 *              if the value entered to reduce is less than the count factor
	 *              or if the count factor is 0 or less
	 *              
	 */
	public IntegerCount(int val, int count) throws Exception {
		startingValue = val;
		countFactor = count;
		if(val < count) {
			throw new Exception("The value you entered is too small to be reduced.");
		}
		if(count <= 0) {
			throw new Exception("The count value you entered is too small to be applied");
		}
		size = startingValue / countFactor; //Integer division will always truncate, so we can save a Math.floor call
		values = new int[size];
		populateArray();
	}

	// ******************************
	// Getters & Setters
	// ******************************
	
	// ******************************
	// Private methods
	// ******************************

	/**
	 * Populates the array by reducing <code>startingValue</code> by <code>countFactor</code>
	 */
	private void populateArray() {
		for(int i = 0; i < size; i++) {
			// Add one to i so we don't include the start value and do include the final non-negative value
			values[i] = (startingValue - (countFactor * (i+1)));
		}
	}
	
	// ******************************
	// Public methods
	// ******************************

	/**
	 * Gets the total value of all items within the array
	 * @return The total integer value
	 */
	public int getTotal() {
		int total = 0;
		for(int i = 0; i < size; i++) {
			total += values[i];
		}
		return total;
	}
	
	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String seperator = ", ";
		for(int i = 0; i < size; i++) {
			sb.append(values[i] + seperator);
		}		
		return sb.toString().substring(0, sb.length() - seperator.length());
	}
	

}
