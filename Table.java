package FinalReservation;

import java.util.Scanner;

/**
 * This is the table class. This has the number of seats that each table has.
 * The id of the table is in the reservableItem.
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public class Table extends ReservableItem
{
	//Protected value for numSeats
	protected int numSeats;

	/**
	 * This constructor is different. Because the ReservableItem is reading in
	 * a line, it only reads a line. Table txt has a line but is separated by 
	 * an id and the seats. So it is best to separate the line and put the 
	 * String id and the int numSeats in a variable.
	 * @param inFile
	 */
	public Table(Scanner inFile)
	{
		//Calls the super constructor to read the line in the Table
		super(inFile);
		
		//Since the line carries both the table id and the numSeats,
		//we split it when there is a space in the text file.
		String[] split = this.id.split(" ");
		
		//Put the splited arrays into values.
		String table = split[0];
		int seats = Integer.parseInt(split[1]);
		
		//Set the values to the instance variables.
		this.id = table;
		this.numSeats = seats;
	}
	

	/**
	 * Returns the number of seats at the table.
	 * @return
	 */
	public int getNumSeats() 
	{
		return numSeats;
	}
	
	/**
	 * Sets a number of seats at the table.
	 * @param numSeats
	 */
	public void setNumSeats(int numSeats) 
	{
		this.numSeats = numSeats;
	}
	
	@Override
	/**
	 * Precondition: res is not null
	 * 
	 * Postcondition: This will return a fitness value.
	 * 
	 * This method returns an integer between 0 and 100 which tells the caller 
	 * how well fit a reservation is for this ReservableItem.  0 means not at 
	 * all fit.  100 means best fit. 
	 * 
	 * In the table class, 100 means perfect fit for the amount of seats 
	 * and seats needed. 
	 * 
	 */
	public int getFitnessValue(Reservation res) 
	{
		//Type cast the Reservation res so that the numSeatsNeeded
		//can be available. (Note that numSeatsNeeded is in the 
		//RestaurantReservation class).
		RestaurantReservation reserve = (RestaurantReservation) res;
			
		//Compare the number of seats and the number of seats needed.
		if(this.getNumSeats() == reserve.getNumSeatsNeeded())
		{
			//If the number of seats needed is a perfect fit for the table,
			//then return 100 which is the best fit.
			return 100;
		}
		else if(this.getNumSeats() > reserve.getNumSeatsNeeded())
		{
			//If there are extra seats, then return the perfect fit minus 
			//the extra seats so you get a fitness value.
			int extra = this.getNumSeats() - reserve.getNumSeatsNeeded();
			return 100 - extra;
		}
		else
		{
			//Otherwise it is the worst fitness value.
			return 0;
		}
	}
}
