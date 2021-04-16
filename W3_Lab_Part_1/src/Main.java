/**
 * Driver program for Week 3 Lab - Problem 1
 *
 * @author Jonathan Doolittle
 * @version 0.1
 * 
**/

public class Main {
	
	public static void main(String[] args) {
		
		//Create our rooms
		RoomOccupancy room1 = new RoomOccupancy();
		RoomOccupancy room2 = new RoomOccupancy();
		
		//Demo that addition works as intended
		System.out.println(String.format("Room 1 has %d occupants", room1.getNumber()));
		System.out.println("Let's now add two people.");
		
		room1.addOneToRoom();
		room1.addOneToRoom();
		
		System.out.println(String.format("Room 1 has %d occupants", room1.getNumber()));
		
		//Demo that subtraction works as intended
		System.out.println(String.format("Room 2 has %d occupants", room2.getNumber()));
		System.out.println("Let's try and have negative occupancy.");
		room2.removeOneFromRoom();
		System.out.println(String.format("Room 2 has %d occupants", room2.getNumber()));
		
		//Demo that static counter works as intended
		System.out.println("Great! Works as intended. Now let's add some more people and see the totals.");
		
		room2.addOneToRoom();
		room2.addOneToRoom();
		room2.addOneToRoom();
		
		System.out.println(String.format("The total occupancy is %d occupants", RoomOccupancy.getTotal()));
		
		
	}
		
}