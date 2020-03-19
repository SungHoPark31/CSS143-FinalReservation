package FinalReservation;

import java.util.ArrayList;

/**
 * This is the boat reservation.
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public class BoatReservation extends Reservation
{
	//Arraylist 
	private ArrayList<String> boat = new ArrayList<>();

	/*
	 * Sets the boat name and the timeslot
	 */
	public BoatReservation(String boatName, int timeSlot) 
	{
		super(boatName, timeSlot);
	}
	
	/**
	 * Adds the boat name to the preference. The 0 index is the highest
	 * index.
	 * @param boatName
	 */
	public void addBoatPreference(String boatName)
	{
		boat.add(boatName);
	}
	
	/**
	 * Returns the ArrayList of the boat preference that the customer wants.
	 * @return
	 */
	public ArrayList<String> getPreferences()
	{
		return boat;
	}
	
	@Override
	/*
	 * This prints out both the successful and the unsuccessful reservations.
	 */
	public String toString()
	{
		if(this.getResourceId() == null)
		{
			return "Unsuccessful Reservation: Reservation Name: " 
			+ this.getCustomer() + " time: " + this.getTime() + 
			" id: " + this.getResourceId() + "\n";
		}
		else
		{
			return "Reservation Name: " + this.getCustomer() + " time: " +
					this.getTime() + " id: " + this.getResourceId() + "\n";
		}
	}

}
