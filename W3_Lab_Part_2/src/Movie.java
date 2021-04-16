/**
 * Represents a movie, complete with a MPAA rating and global rating system. Usage:
 * 

<pre> 
Movie movie = new Movie("Finding Nemo", MpaaRating.PG); 
movie.addRating(4);
</pre>

 *
 * @author Jonathan Doolittle
 * @version 0.1
 * @created Apr 15, 2021
**/

public class Movie {

	// ******************************
	// Variables
	// ******************************

	/**
	 * Defined the max rating a movie can receive, starting at 1
	 */
	private static final int MAX_RATING = 5;
	
	private String name;
	private MpaaRating mpaaRating;
	private int[] globalRatings;
	
	// ******************************
	// Constructors
	// ******************************

	/**
	 * Creates a new movie, with a blank name and blank MpaaRating
	 */
	public Movie() {
		this.name = "";
		this.mpaaRating = MpaaRating.NONE;
		this.globalRatings = new int[MAX_RATING];
	}
	
	/**
	 * Creates a new movie, with a name and blank MpaaRating
	 * @param name The movie's name
	 */
	public Movie(String name) {
		this.name = name;
		this.mpaaRating = MpaaRating.NONE;
		this.globalRatings = new int[MAX_RATING];
	}
	
	/**
	 * Creates a new movie, with a name and MpaaRating
	 * @param name The movie's name
	 * @param mpaaRating The movie's MPAA rating
	 */
	public Movie(String name, MpaaRating mpaaRating) {
		this.name = name;
		this.mpaaRating = mpaaRating;
		this.globalRatings = new int[MAX_RATING];
	}

	// ******************************
	// Getters & Setters
	// ******************************

	/**
	 * Gets this movie's name
	 * @return The movie's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets this movie's name
	 * @param name The new movie name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets this movie's MPAA rating
	 * @return The MPAA rating
	 */
	public MpaaRating getMpaaRating() {
		return mpaaRating;
	}

	/**
	 * Sets this movie's MPAA rating
	 * @param mpaaRating The new MPAA rating
	 */
	public void setMpaaRating(MpaaRating mpaaRating) {
		this.mpaaRating = mpaaRating;
	}
	
	// ******************************
	// Private methods
	// ******************************
	
	// ******************************
	// Public methods
	// ******************************

	/**
	 * Adds a global rating to this movie
	 * @param rating The rating of this movie, from 1 to {@link #MAX_RATING}
	 * @throws Exception Rating out of range
	 */
	public void addRating(int rating) {
		
		//Bump down the rating to match the index of array
		rating--;
		
		//Ensure rating is within bounds
		if(rating < 0 || rating >= MAX_RATING) {
			return; //No error / throws for the sake of this assignment
		}
		
		//Increase counter
		globalRatings[rating]++;
		
	}

	/**
	 * Gets the average rating for this movie, based on the global ratings
	 * @return The average rating, or 0 if no ratings have been provided
	 */
	public float getAverageRating() {
		
		//Keep track of the totals as we loop
		float totalRating = 0;
		int itemCount = 0;
		
		//Loop trough all the ratings
		for(int i = 0; i < MAX_RATING; i++) {
			itemCount += globalRatings[i];
			totalRating += globalRatings[i] * (i+1); //Add one to account for index being one under the rating
		}
		
		//Catch for divide by zero
		if(itemCount == 0) {
			return 0f;
		}
		
		//Return the average
		return (totalRating / itemCount);
	}
	
	// ******************************
	// Overrides
	// ******************************
	
	@Override
	public String toString() {
		return String.format("%s, Rated %s - Average User Rating: %.2f", name, mpaaRating.toString(), getAverageRating());
	}
	

}
