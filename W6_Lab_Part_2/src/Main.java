/**
 * 
 * Driver program for week 6 lab, part 2.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 10, 2021
*
 */
public class Main {
	
	public static void main(String[] args) {
		
		Doctor doctorSpock = new Doctor("Spock", "Pediatrician", 200);
		Doctor doctorDoolittle = new Doctor("Doolittle", "Witch", 175);
		
		Patient patientCalvin = new Patient("Calvin", "123-45-6789");
		Patient patientHobbes = new Patient("Hobbes", "987-65-4321");
		
		Billing billA = new Billing(patientCalvin, doctorSpock);
		billA.writeOutput();
		
		Billing billB = new Billing(patientHobbes, doctorSpock);
		billB.writeOutput();
		
		Billing billC = new Billing(patientCalvin, doctorDoolittle);
		billC.writeOutput();
		
		Billing.writeTotal(billA, billB, billC);
		
		System.out.println("Is bill A (Calvin - Spock) equal to bill B (Hobbes - Spock)? \n" + (billA.equals(billB) ? "Yes!" : "No."));
	
	}
	


}
