/**
 * 
 * The Doctor class represents a doctor within a doctor's office environment. 
 * Each Doctor has several read only variables, including the fee per office visit, 
 * the Doctor’s particular specialty, and the Doctor’s name. Doctors are linked to {@link Patient} 
 * objects for office visits, and charges are calculated via the {@link Billing} object.
 * 
 * <pre> 
 *    Doctor doctor = new Doctor("Dr. Doolittle", "Veterinarian", 45.00);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
*
 */
public class Doctor extends Person {

	// ******************************
	// Variables
	// ******************************

	private String specialty;
	private double visitFee;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Doctor with the given parameters
	 * @param initialName The Doctor's name
	 * @param specialty The Doctor's specialty, e.g. neurologist, etc
	 * @param visitFee The fee per office visit, in USD
	 */
	public Doctor(String initialName, String specialty, double visitFee) {
		super(initialName);
		this.specialty = specialty;
		this.visitFee = visitFee;
	}

	// ******************************
	// Getters & Setters
	// ******************************
	
	/**
	 * @return The doctor's specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @return The visitation fee
	 */
	public double getVisitFee() {
		return visitFee;
	}
	
	// ******************************
	// Overrides
	// ******************************

	@Override
	public void writeOutput() {
		System.out.println("Name: " + getName() + " Specialty: " + specialty + " Office Fee: " + visitFee);
	}


}
