import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * Driver program for part 1 of the midterm. Simply demonstrates the capabilities of {@link IntegerCount}
 *
 * @author Jonathan Doolittle
 * @version 0.1 - Apr 28, 2021
*
 */
public class Main {

	public static void main(String[] args) {

		// Encapsulate in try to ensure scanner is always closed
		try (Scanner scanner = new Scanner(System.in)) {
			// Message for the user
			System.out.println("Please enter an integer! >");
			//Create a new object for data processing.
			IntegerCount integerCount = new IntegerCount(gatherInput(scanner));
			System.out.println("Output: " + integerCount);

		} catch (Exception e) {

			System.out.println("Whoops... An error occured: " + e.getMessage());

		}

	}

	/**
	 * Captures integer only input for the driver program. Non-integer input will be rejected and the user will be prompted again
	 * @param scanner The scanner to gather input from
	 * @return The inputed integer value.
	 */
	public static int gatherInput(Scanner scanner) {
		int value;
		try {
			value = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Hmm, that doesn't look quite right. Lets try again. >");
			scanner.next();
			value = gatherInput(scanner);
		}
		return value;
	}

}
