package inheritance;

public class Turtle extends Animal {

	// ******************************
	// Constructors
	// ******************************

	public Turtle(String name) {
		//Super calls Animal's constructor
		super(name, "Turtle", "meep meep!");
	}

	// ******************************
	// Public methods
	// ******************************

	public void printTurtleThings() {
		System.out.println("WOW IM A TURTLE");
	}


}
