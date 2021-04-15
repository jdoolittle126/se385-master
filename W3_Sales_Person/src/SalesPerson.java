/**
 * Represents a simple sales person, with a first and last name
 * @author Jonathan Doolittle
 *
 */

public class SalesPerson {
	
	// ******************************
	// Variables
	// ******************************
	
	private String firstName;
	private String lastName;
	
	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new SalesPerson instance, with a blank first name and a blank last name
	 */
	public SalesPerson() {
		this.firstName = "";
		this.lastName = "";
	}
	
	/**
	 * Creates a new SalesPerson instance, with a first name and a blank last name
	 * @param firstName The SalesPerson's first name
	 */
	public SalesPerson(String firstName) {
		this.firstName = firstName;
		this.lastName = "";
	}
	
	/**
	 * Creates a new SalesPerson instance, with a first and last name
	 * @param firstName The SalesPerson's first name
	 * @param lastName The SalesPerson's last name
	 */
	public SalesPerson(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// ******************************
	// Getters & Setters
	// ******************************
	
	/**
	 * Gets this SalesPerson's first name
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set this SalesPerson's first name
	 * @param firstName The new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets this SalesPerson's last name
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set this SalesPerson's last name
	 * @param lastName The new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Prints the string representation of this SalesPerson
	 */
	public void print() {
		System.out.println(this);
	}
	
	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof SalesPerson) {
			//If obj is a SalesPerson, cast and continue
			SalesPerson other = (SalesPerson)obj;
			
			/* Compare first and last name for equality. It is important
			 * to compare variables as opposed to the 'toString()' value for
			 * maintainability.
			 * */
			return (other.getFirstName().equals(this.firstName)) &&
				   (other.getLastName().equals(this.lastName));
		}
		
		return false;
		
	}
	
	@Override
	public int hashCode() {
		// See SolarLint - java:S1206
		return super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("%s %s", this.firstName, this.lastName);
	}
	
	

}
