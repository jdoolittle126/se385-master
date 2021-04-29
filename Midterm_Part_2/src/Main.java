/**
 * 
 * Driver program for part 2 of the midterm. Simply demonstrates the capabilities of {@link Car}
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Apr 29, 2021
*
 */
public class Main {

	public static void main(String[] args) {

		try {
			// Default constructor car creation
			Car car = new Car();
			car.print();
			
			// Parameter constructor car creation
			Car car2 = new Car("BMW", "Blue", 4);
			car2.print();
			
			// Editing the brand of a car
			car.setBrand("Town & Country");
			car.print();
			
			// Static function
			System.out.println("Range of a 20 gal. tank: " + Car.calculateRange(20));
			
			// Total number of cars
			System.out.println("Total number of cars: " + Car.creationCount());
			
		} catch (Exception e) {
			System.out.println("Whoops... An error occured: " + e.getMessage());
		}

	}


}
