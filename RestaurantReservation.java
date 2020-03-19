package FinalReservation;

/**
 * This is the restaurant reservation and all it has is seats needed.
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public class RestaurantReservation extends Reservation
{
	private int seatsNeeded;
	
	/**
	 * Initializes the reservation of the time slot, the name and the 
	 * seats needed by using the super class.
	 * 
	 * @param customerName
	 * @param seatsNeeded
	 * @param timeSlot
	 */
	public RestaurantReservation(String customerName, int seatsNeeded,
															int timeSlot) 
	{
		super(customerName, timeSlot);
		this.seatsNeeded = seatsNeeded;
	}
	
	/**
	 * Gets the number of seats that the customer needs
	 * @return
	 */
	public int getNumSeatsNeeded()
	{
		return this.seatsNeeded;
	}
	
	@Override
	/**
	 * This returnsthe unsuccessful reservation or the successful reservaiton
	 * as a string.
	 */
	public String toString()
	{	
		if(this.getResourceId() == null)
		{
			return "Unsuccessful Reservation: Reservation Name: " 
				+ this.getCustomer() + " time: " + this.getTime() + 
				" id: " + this.getResourceId() + " customer seats: "
				+ this.seatsNeeded + "\n";
		}
		else
		{
			return "Reservation Name: " + this.getCustomer() + " time: " +
				this.getTime() + " id: " + this.getResourceId() + 
						" customer seats: " + this.seatsNeeded + "\n";
		}
	}
}
