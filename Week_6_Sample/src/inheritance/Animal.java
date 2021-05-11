package inheritance;

/**
 * 
 * Animal class for demo
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 6, 2021
*
 */

public class Animal {

	// ******************************
	// Variables
	// ******************************
	
	private String name;
	private String species;
	private String sound;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Animal
	 * @param name The name of this animal. For example, Sam
	 * @param species The species of the animal. For example, Monkey
	 * @param sound The sound this animal makes. For example, GLUBUBUBU
	 */
	public Animal(String name, String species, String sound) {
		this.name = name;
		this.species = species;
		this.sound = sound;
	}

	// ******************************
	// Getters & Setters
	// ******************************

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	// ******************************
	// Overrides
	// ******************************

	@Override
	public String toString() {
		return "Hi my name is " + name + "! I am a(n) " + species + ", and this is my sound... " + sound;
	}
	
}
