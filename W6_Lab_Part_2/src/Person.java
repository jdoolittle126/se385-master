/**
 * 
 * Lab assigned Person class
 *
 */
public class Person {
	
	// ******************************
	// Variables
	// ******************************
	
	private String name;

	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new nameless Person
	 */
	public Person() {
		name = "No name yet.";
	}

	/**
	 * Creates a new Person with a name
	 * @param initialName The Person's name
	 */
	public Person(String initialName) {
		name = initialName;
	}

	// ******************************
	// Getters & Setters
	// ******************************
	
	/**
	 * Sets this Person's name
	 * @param newName This Person's new name
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Get's this Person's name
	 * @return This Person's name
	 */
	public String getName() {
		return name;
	}

	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Prints this Person's data
	 */
	public void writeOutput() {
		System.out.println("Name: " + name);
	}

	/**
	 * Compares this person to otherPerson to see if the names match.
	 * @param otherPerson The Person to compare with
	 * @return true if the names match, false if the names do not match
	 */
	public boolean hasSameName(Person otherPerson) {
		return (this.name.equalsIgnoreCase(otherPerson.getName()));
	}
}
