/**
 * @author Jonathan Doolittle
 * 
 */

public class Main {
	
	
	public static void main(String[] args) {
				
		//Create three sales people for testing, using 3 different methods
		SalesPerson newPerson = new SalesPerson("Jonathan", "Doolittle");
		
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
		
		//Overloading
		float salesCommission;
		
		salesCommission = newPerson.calculateCommission(0.5f, 100);
		System.out.println("The sales commission is " + salesCommission);
		salesCommission = newPerson.calculateCommission(0.5f, 100.5f);
		System.out.println("The sales commission is " + salesCommission);
		
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