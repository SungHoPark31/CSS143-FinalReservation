package FinalReservation;

import java.util.Scanner;

/**
 * This is the boat class.
 * The id of the boat is in the reservableItem.
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public class Boat extends ReservableItem
{	
	/**
	 * Reads the line for the boat 
	 * @param fileIn
	 */
	public Boat(Scanner fileIn)
	{
		super(fileIn);
	}

	@Override
	/**
	 * Precondition: res is not null
	 * 
	 * Postcondition: This will return a fitness value.
	 * 
	 * This method returns an integer but it returns the size 
	 * minus i.
	 * 
	 */
	public int getFitnessValue(Reservation res)
	{
		//type cast the object to the Boat Reservation to get the preferences
		BoatReservation reserve = (BoatReservation) res;
		
		//For loop to go through the preference size.
		for (int i = 0; i < reserve.getPreferences().size(); i++) 
		{
			//If the value inside the preference at index i is the same as the
			//id, then return the size -1. This is because the highest 
			//preference that this customer wants is at index 0. And if 
			//we return 0, the item will be unsuccessful, which we don't want.
			//This will return the highest fitness value at that index.
			if(this.id.equals(reserve.getPreferences().get(i)))
			{
				return reserve.getPreferences().size() - i;
			}
		}
		//Otherwise return 0 for the unsuccessful items.
		return 0;
	}

}
