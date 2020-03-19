package FinalReservation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the Reservation class. This is where the customer will make his 
 * Reservations.
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public class Reservation extends ResManager implements Comparable
{
	//instance variables
	private String customer;
	private int time;
	private String id;
	
	/**
	 * Constructor to set the reservation name and the time.
	 * @param customerName
	 * @param timeSlot
	 */
	public Reservation(String customerName, int timeSlot) 
	{
		this.customer = customerName;
		this.time = timeSlot;
	}
	
	/**
	 * Get the customer name.
	 * @return customer
	 */
	public String getCustomer() 
	{
		return customer;
	}

	/**
	 * Set the customer name (Though not needed).
	 * @param customer
	 */
	public void setCustomer(String customer) 
	{
		this.customer = customer;
	}

	/**
	 * Get the time slot that the customer wants.
	 * @return time
	 */
	public int getTime() 
	{
		return time;
	}

	/**
	 * This sets the time slot that the customer wants.
	 * @param time
	 */
	public void setTime(int time)
	{
		this.time = time;
	}
	
	@Override
	/**
	 * To String that is actually not needed.
	 */
	public String toString()
	{
		return "";
	} 
	
	/**
	 * This gets the table id or the boat id.
	 * @return id
	 */
	public String getResourceId() 
	{
		return this.id;
	}
	
	/**
	 * This sets the table id or the boat id.
	 */
	public void setResourceId(String id)
	{
		this.id = id;
	}

	@Override
	/**
	 * Precondition: o is not null
	 * 
	 * Postcondition: returns an integer
	 */
	public int compareTo(Object o)
	{
		//Type cast the object
		Reservation other = (Reservation) o;
		
		//CompareTo will make compare the customer name.
		//If the name is the same as another, then return 0
		//If the name is Lexicographically greater, then return 1
		//If not, return -1.
		if(this.customer.equals(other.customer))
		{
			return 0;
		}
		else if(this.customer.compareTo(other.customer) > 0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
