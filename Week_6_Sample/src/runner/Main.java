package runner;

import java.util.LinkedList;

import inheritance.Animal;
import inheritance.Turtle;

public class Main {

	public static void main(String[] args) {
		
		// Inheritance 
		LinkedList<Animal> list = new LinkedList<>();
		
		Animal bear = new Animal("Herb", "Bear", "Grrrrr");
		Animal turtle = new Animal("Tucker", "Turtle", "blub blub");
		
		Turtle turtle2 = new Turtle("Stumpy");
		
		///   Animal (Root)
		///      |
		///      V
		///   Turtle (Child, can do everything Animal can do plus whatever it can do)
		
		System.out.println(bear);
		System.out.println(turtle);
		System.out.println(turtle2);
		
		//Doesn't work, hes not a REAL turtle 
		//turtle.printTurtleThings();
		
		turtle2.printTurtleThings();
		
		//We can add them all to our list, because they are all at the Animal level or less. If we made our 
		//List with <Turtle>, we could only add Mr. Stumpy, since Animals are above turtles. Essentially,
		//as you move down the tree, we add data, not remove it. So when you add a Turtle to the Animal list,
		//we get rid of all of that extra turtle data (in this case, the ability to call printTurtleThings() )
		list.add(bear);
		list.add(turtle);
		list.add(turtle2);
		
		//So here our pal Stumpy lost his ability to call printTurtleThings(), but he still has any data thats part of the
		//animal class!
		for(Animal a : list) {
			System.out.println(a);
		}
		
		//So what about casting? What is casting? Casting is trying to force one type to another. It doesn't always work,
		//because we are adding data that's not there. See, we turned our turtle2 into an Animal, but we can bring it back
		//to Turtle form with this cast!
		((Turtle) list.get(2)).printTurtleThings();
		
		//This one, not so much. See he was never a turtle, he can't just become one
		//((Turtle) bear).printTurtleThings();
		
		//Why is this useful? Well this is how we can model real world problems, and save a ton of time.
		//The only problem is, we need to think out our code in advance.
		

	}

}
