/**
 * Represents a Car object with a brand, color, and number of doors. 
 * 
 * <pre> 
 *    Car car = new Car("myBrand", "myColor", 4);
 * </pre>
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Apr 29, 2021
*
 */
public class Car {

	// ******************************
	// Variables
	// ******************************
	
	/**
	 * Represents the MPG value for all cars
	 */
	private static final int MILES_PER_GALLON = 30;
	
	/**
	 * The total number of Car objects created
	 */
	private static int carsCreated = 0;
	
	private String brand;
	private String color;
	private int numberOfDoors;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Car object with default values
	 */
	public Car() {
		carsCreated++;
		this.brand = "No Brand";
		this.color = "No Color Specified";
		this.numberOfDoors = 0;
	}
	
	/**
	 * Creates a new Car object with the specified values
	 * @param brand The String representation of the car's brand
	 * @param color The String representation of the car's color
	 * @param numberOfDoors The number of doors the car has
	 * @throws Exception 
	 * 					if the value for <code>numberOfDoors</code> is a negative value
	 */
	public Car(String brand, String color, int numberOfDoors) throws Exception {
		this();
		this.brand = brand;
		this.color = color;
		this.numberOfDoors = numberOfDoors;
		if(numberOfDoors < 0) {
			throw new Exception("Cannot use a negative value for Number of Doors");
		}
	}

	// ******************************
	// Getters & Setters
	// ******************************

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	// ******************************
	// Private methods
	// ******************************

	// ******************************
	// Public methods
	// ******************************

	/**
	 * Prints out a String representation of this object to the standard output stream
	 */
	public void print() {
		System.out.println(this);
	}
	
	/**
	 * Returns the value of Car objects created so far
	 * @return the number of Car objects created at the time of call
	 */
	public static int creationCount() {
		return carsCreated;
	}
	
	/**
	 * Calculates the total range of the car based on the default MPG value of {@value #MILES_PER_GALLON}
	 * @param totalGallons The total gallons available in the car
	 * @return The range of the car, in miles
	 */
	public static int calculateRange(int totalGallons) {
		return totalGallons * MILES_PER_GALLON;
	}
	
	// ******************************
	// Overrides
	// ******************************

	@Override
	public String toString() {
		return "Car [Brand=" + brand + ", Color=" + color + ", Number Of Doors=" + numberOfDoors + "]";
	}
}
