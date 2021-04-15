/**
 * @author Patrick Maguire, Kasey Bourdier, Leandro Ysiano, Jonathan Doolittle
 * 
 */

import java.util.Scanner;

public class Main {
	
	//If true, the user is prompted for input again. False results in the game ending
	static boolean allowTypos = false;
	
	public static void main(String[] args) {
				
		//Create input capture for the game
		Scanner scanner = new Scanner(System.in);

		//Encapsulate in try to ensure scanner is always closed
		try {
			
			do {
				playTurn(scanner);
			} while(continueGame(scanner));
			
		} catch (Exception e) {
			
			System.out.println("Whoops... An error occured");
			
		} finally {
			
			scanner.close();
			
		}
		
	}
	
	/**
	 * Plays a single turn of rock-paper-scissors
	 * @param scanner The scanner to capture input from
	 * 
	 */
	public static void playTurn(Scanner scanner) {
		//Picks a # between 1 & 3, then shifts one to ignore GameChoice NONE
		GameChoice cpu = GameChoice.values()[(int)(Math.random() * 3) + 1];
		GameChoice player = gatherInput(scanner);
		
		
		if(player == GameChoice.NONE) {
			
			//If typos are allowed, provide another chance
			if(allowTypos) {
				
				do {
					player = gatherInput(scanner);
					
				} while(player == GameChoice.NONE);
				
			} else {
				//Overwise end the program
				System.out.println("I don't understand... Game over.");
				scanner.close();
				System.exit(0);
			}
			
		}
		
		//Print out results
		System.out.println("PLAYER: " + player + " CPU: " + cpu);
		
		switch(GameChoice.compareChoice(cpu, player)) {
			case -1:
				System.out.println("CPU WINS");
				break;
			case 0:
				System.out.println("TIE");
				break;
			case 1:
				System.out.println("PLAYER WINS");
				break;
		}
		
		
	}
	
	/**
	 * Asks the user if they would like to play another game and returns the result.
	 * @param scanner The scanner to capture input from
	 * @return The choice to play another game
	 */
	public static boolean continueGame(Scanner scanner) {
		System.out.println("Good game! Would you like to play another? (y/n) >");
		return (!scanner.next().trim().equalsIgnoreCase("n"));
	}
	
	/**
	 * The logic of the exercise
	 * @param scanner The scanner to capture input from
	 * @return The GameChoice selected, or NONE if invalid input was entered
	 */
	private static GameChoice gatherInput(Scanner scanner) {
		System.out.println("Enter your choice (rock) (paper) (scissors) >");
		return GameChoice.mapFromString(scanner.next());	
		
	}
	
	
	

}