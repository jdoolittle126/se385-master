import java.util.Scanner;

public class Main {
	static Scanner scanner;
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);

		try {
			
			gatherInput(scanner);
			
		} catch (Exception e) {
			
			System.out.println("Whoops... An error occured");
			
		} finally {
			
			scanner.close();
			
		}
		
	}
	
	/**
	 * The logic of the exercise
	 * @param scanner The scanner to gather data from
	 */
	private static void gatherInput(Scanner scanner) {
		System.out.println("Lets find the distance between two points!\n"
				+ "Lets start with Point A");
		
		Point a = Point.inputPoint(scanner);
		
		System.out.println("Okay, how about Point B?");
		
		Point b = Point.inputPoint(scanner);
		
		System.out.println(String.format("The distance between your points is %f!", a.distanceBetween(b)));
	}
	
	
	
	
}
