/**
 * 
 * Basically, this program demonstrates how to use interfaces to share methods between difference unrelated objects.
 * With an interface, you can add functionality or force implementation. In this example, we demo this using an Actor and act method
 * 
 *
 * @author Jonathan Doolittle, Jason Mandras, Brandon Morris, Juliana Wright, Tim LeBrun
 * @version 0.1 - May 6, 2021
*
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Create our two new classes that use the Actor interface
		Actor1 actor1 = new Actor1();
		Actor2 actor2 = new Actor2();
		
		// Demonstrate the functionality of each's .act() method
		actor1.act();
		actor2.act();
		
		// Demonstrate the functionality of the static tryout() method
		tryout(actor1);
		tryout(actor2);
		
	}
	
	/**
	 * Tries out an actor, by using their act() method
	 * @param actor The actor to try out
	 */
	private static void tryout(Actor actor) {
		actor.act();
	}
	

}
