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
		System.out.println("Please enter a sentence >");
		String value = scanner.nextLine();
		int space = value.indexOf(' ');
		
		if(space == -1) {
			System.out.println("This sentence cannot be manipulated");
			return;
		}
		
		if(value.charAt(value.length()-1) != ' ') {
			value += ' ';
		}
		
		value = value.substring(space+1, space+2).toUpperCase() + value.substring(space+2) + value.substring(0, space);
		
		System.out.println("I have tweaked what you said to read: ");
		System.out.println(value);
		
	}
	
	
	
}
