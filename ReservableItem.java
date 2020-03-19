package FinalReservation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the ReservableItem class. This contains has the id of the table and
 * or the boat and has the time array for each of the boat and the table.
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public abstract class ReservableItem extends ResManager
{
	//Instance variables
	
	//Id is protected because we want it to be accessed in the subclasses as 
	//well
	protected String id;
	public static final int TIME_SLOT = 10;
	private boolean[] time = new boolean[TIME_SLOT];
	
	/**
	 * This is an empty constructor
	 */
	public ReservableItem()
	{
		
	}
	
	/**
	 * Reads in the scanner and sets each line to the id. If its the boat txt 
	 * file, then this would work, but we'll see what happens in the Table txt
	 * 
	 * @param fileIn
	 */
	public ReservableItem(Scanner fileIn)
	{
		this.id = fileIn.nextLine();
	}
	
	/**
	 * Gets the Id of the table or the boat.
	 * 
	 * @return
	 */
	public String getId() 
	{
		return this.id;
	}

	/**
	 * Sets the Id of the table and boat, but it is not necessarily needed in 
	 * this project.
	 * 
	 * @param id
	 */
	public void setId(String id) 
	{
		this.id = id;
	}
	
	/**
	 * Sets the Time to true. False means that it is available while true means
	 * that is not available.
	 * 
	 * @param index
	 */
	public void setTime(int index)
	{
		time[index] = true;
	}
	
	/**
	 * Abstract class that will be finished in the Table and Boat class. 
	 * @param res
	 * @return
	 */
	public abstract int getFitnessValue(Reservation res);
	
	/**
	 * Returns the time array from 0 - 9. All initially available (false)
	 * @return
	 */
	public boolean[] getTimeArray()
	{
		return time;
	}
	
}
