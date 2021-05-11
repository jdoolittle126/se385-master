import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 * Links a {@link Patient} and  a {@link Doctor} object to create a Billing entity. 
 * Billing entities can keep track of the total cost of a particular visit.
 * 
 * <pre> 
 *   Billing billing = new Billing(patient, doctor);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
*
 */
public class Billing {

	// ******************************
	// Variables
	// ******************************
	
	// A nice way to format currency
	private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	
	private Patient patient;
	private Doctor doctor;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new billing object between two entities, a patient and a doctor
	 * @param patient The patient who will be paying the bill
	 * @param doctor The doctor that was visited
	 */
	public Billing(Patient patient, Doctor doctor) {
		this.patient = patient;
		this.doctor = doctor;
	}

	// ******************************
	// Getters & Setters
	// ******************************

	/**
	 * @return The bill's patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @return The bill's doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Gets the bill for this visit
	 * @return The payment due for this visit
	 */
	public double getBill() {
		return doctor.getVisitFee();
	}
	
	/**
	 * Writes the status of this bill to the standard output stream
	 */
	public void writeOutput() {
		System.out.println("Patient " + patient.getName() + " visited " + doctor.getName() + ". The total bill is " + moneyFormatter.format(getBill()));
	}
	
	/**
	 * Writes to total for all of the bills provided
	 * @param bills All of the bills to be added
	 */
	public static void writeTotal(Billing ... bills) {
		double total = 0; // Start with a blank counter
		for(Billing bill : bills) {
			total += bill.getBill(); // Iterate and append bill totals
		}
		
		System.out.println("The overall bill is " + moneyFormatter.format(total));
		
	}
	
	// ******************************
	// Overrides
	// ******************************
	
	/**
	 * Compares two Billing objects for value equality
	 * @param other The external Billing instance to compare with
	 * @return true if these Billing objects are equal in value, false if not
	 */
	public boolean equals(Billing other) {
		return  other.doctor.hasSameName(doctor) && // Look at each metric, doctor name, patient name, and bill cost
				other.patient.hasSameName(patient) &&
				getBill() == other.getBill();
		
	}





}
