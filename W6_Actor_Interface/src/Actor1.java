/**
 * 
 * Basically, creates an Actor object that implements Actor and has its own printout for the act() method 
 * 
 * <pre> 
 *    Actor1 actor1 = new Actor1();
 * </pre>
 *
 * @author Jonathan Doolittle, Jason Mandras, Brandon Morris, Juliana Wright, Tim LeBrun
 * @version 0.1 - May 6, 2021
 *
 */
 
public class Actor1 implements Actor {

	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new Actor1
	 */
	public Actor1() {
		// Empty for demonstration purposes 
	}
	
	// ******************************
	// Overrides
	// ******************************

	@Override
	public void act() {
		System.out.println("Actor 1 is acting!");
	}



}
