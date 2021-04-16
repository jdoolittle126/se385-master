/**
 * Driver program for Week 3 Lab - Problem 2
 * 
 * @author Jonathan Doolittle
 * @version 0.1
 * @created Apr 15, 2021
**/

public class MovieDriver {

	public static void main(String[] args) {
		
		//Creating a movie
		System.out.println("Let's start with a new movie.");
		
		Movie nemo = new Movie("Finding Nemo", MpaaRating.PG);
		System.out.println(nemo);
		
		System.out.println("Now let's add some ratings.");
		
		//Adding ratings
		nemo.addRating(3);
		nemo.addRating(3);
		nemo.addRating(4);
		nemo.addRating(5);
		nemo.addRating(5);
		nemo.addRating(5);
		
		//Print and show average
		System.out.println(nemo);
		
		System.out.println("Here is another movie.");
		 
		Movie cars = new Movie("Cars II", MpaaRating.PG13);
		cars.addRating(1);
		cars.addRating(1);
		cars.addRating(1);
		cars.addRating(5);
		cars.addRating(2);
		cars.addRating(3);
		cars.addRating(3);
		cars.addRating(5);
		
		System.out.println(cars);
		
		
	}

}
