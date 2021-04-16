import java.util.Scanner;

/**
 * @author Jonathan Doolittle
 * 
 */

public class Main {
	
	
	public static void main(String[] args) {
				
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your first name, then press enter and enter your last name");
		//Create three sales people for testing, using 3 different methods
		SalesPerson newPerson = new SalesPerson(scanner.next(), scanner.next());
		
		SalesPerson anotherPerson = new SalesPerson();
		anotherPerson.setFirstName("Jonathan");
		anotherPerson.setLastName("Doolittle");
		
		SalesPerson aThirdPerson = new SalesPerson("Scott");
		aThirdPerson.setLastName("Lambert");
		
		//Print out all of our sales people
		System.out.println("Person #1");
		newPerson.print();
		
		System.out.println("Person #2");
		anotherPerson.print();
		
		System.out.println("Person #3");
		aThirdPerson.print();
		
		//Comparison Tests
		System.out.println();
		comparisonTest(newPerson, anotherPerson);
		comparisonTest(newPerson, aThirdPerson);
		
		scanner.close();
	
	}
	
	/**
	 * Compares two sales people and prints out a string with the results
	 * @param personA The first sales person to compare
	 * @param personB The second sales person to compare
	 */
	private static void comparisonTest(SalesPerson personA, SalesPerson personB) {
		//Output who is being compared
		System.out.println(String.format("Comparing %s to %s...", personA.toString(), personB.toString()));
		
		//Use our comparison method to generate a string
		String comparison = (personA.equals(personB)) ? "is" : "is not";
		
		//Output the human-readable result
		System.out.println(String.format("%s %s equal to %s", personA.toString(), comparison, personB.toString()));
		
	}
	

}