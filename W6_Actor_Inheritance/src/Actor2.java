/**
 * 
 * Basically, creates an Actor object that implements Actor and has its own printout for the act() method 
 * 
 * <pre> 
 *    Actor2 actor2 = new Actor2();
 * </pre>
 *
 * @author Jonathan Doolittle, Jason Mandras, Brandon Morris, Juliana Wright, Tim LeBrun
 * @version 0.1 - May 6, 2021
 *
 */

public class Actor2 extends Actor {
	
	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new Actor2
	 */
	public Actor2() {
		// Empty for demonstration purposes 
	}

	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public void act() {
		System.out.println("Actor 2 is acting!");
	}

}
