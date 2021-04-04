import java.util.InputMismatchException;
import java.util.Scanner;

public class Point {
	float x;
	float y;
	
	/**
	 * Creates a point in 2D space
	 * @param x X Coordinate (float)
	 * @param y Y Coordinate (float)
	 */
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the distance between this point and another as a positive floating point value
	 * @param other The point to compare 
	 * @return The distance (float)
	 */
	public float distanceBetween(Point other) {
		
		double ab2 = Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2);
		
		return (float) Math.pow(ab2, 0.5);
	}
	
	/**
	 * Creates a Point from user input
	 * @param scanner The scanner to collect data from
	 * @return The new Point
	 */
	public static Point inputPoint(Scanner scanner) {
		float inputX;
		float inputY;
		
		System.out.println("Input the X value for this point >");
		inputX = gatherInput(scanner);
		
		System.out.println("Input the Y value for this point >");
		inputY = gatherInput(scanner);
		
		return new Point(inputX, inputY);
		
	}
	
	/**
	 * Private method to gather and filter input
	 * @param scanner The scanner to collect data from
	 * @return The entered float value
	 */
	private static float gatherInput(Scanner scanner) {
		float value;
		
		try {
			value = scanner.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println("Hmm, that doesn't look quite right. Lets try again. >");
			scanner.next();
			value = gatherInput(scanner);
		}
		
		return value;	
	}
	
	
	
}
