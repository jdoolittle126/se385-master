/**
 * 
 * The Patient class represents a patient in a doctor's office environment. 
 * Each Patient has a read only identifier, and can be used with the {@link Billing} object for payment related processing.
 * 
 * <pre> 
 *    Patient patient = new Patient("Jonathan", "0509-22");
 *    patient.writeOutput();
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
 *
 */

public class Patient extends Person {

	// ******************************
	// Variables
	// ******************************

	private String identifier;
	
	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new Patient with a name, and identification
	 * @param initialName The Patient's name
	 * @param identifier The Patient's identifier
	 */
	public Patient(String initialName, String identifier) {
		super(initialName);
		this.identifier = identifier;
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public void writeOutput() {
		System.out.println("Name: " + getName() + " Identifier: " + identifier);
	}


}
