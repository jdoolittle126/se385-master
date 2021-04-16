/**
 * Monitors and tracks room occupancy for various entities. Usage:
 * 

<pre> 
RoomOccupancy room = new RoomOccupancy();
room.addOneToRoom();
room.removeOneFromRoom();
</pre>

 *
 * @author Jonathan Doolittle
 * @version 0.1
 * 
**/

public class RoomOccupancy {
	
	// ******************************
	// Variables
	// ******************************
	
	private int numberInRoom;
	private static int totalNumber = 0;
	
	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new room, with an initial count of 0;
	 */
	public RoomOccupancy() {
		numberInRoom = 0;
	}
	
	// ******************************
	// Getters & Setters
	// ******************************
	
	/**
	 * Gets the total number of occupants within this instance of a room
	 * @return The total number of occupants
	 */
	public int getNumber() {
		return numberInRoom;
	}
	
	/**
	 * Gets the total number of occupants in all rooms
	 * @return The total number of occupants
	 */
	public static int getTotal() {
		return totalNumber;
	}
	
	// ******************************
	// Private methods
	// ******************************
	
	/**
	 * A thread-safe way of incrementing totalNumber
	 */
	private static synchronized void addOneToTotal() {
		totalNumber++;
	}
	
	/**
	 * A thread-safe way of decrementing totalNumber
	 */
	private static synchronized void removeOneFromTotal() {
		totalNumber--;
	}
	
	// ******************************
	// Public methods
	// ******************************
	
	/**
	 * Adds a participant to the room
	 */
	public void addOneToRoom() {
		numberInRoom++;
		addOneToTotal();
	}
	
	/**
	 * Removes one entity from this current room instance, if the room has atleast one member.
	 */
	public void removeOneFromRoom() {
		//No need to check total, it can't be less than numberInRoom
		if(numberInRoom > 0) {
			numberInRoom--;
			removeOneFromTotal();
		}
	}
	
	// ******************************
	// Overrides
	// ******************************
	

}
