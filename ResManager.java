package FinalReservation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the ResManager class. This will determine if you actually can 
 * reserve a spot at that time slot depending on the fitness value.
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
public class ResManager<ItemType extends ReservableItem,
										ResType extends Reservation>
{
	//ArrayList that has items inside of them.
	
	//Note inside reservations is the name of the customer, the time slot 
	//that they want and the tableId that needs to be set later.
	private ArrayList<ResType> reservations;
	
	//Note inside reservableItems has the instance variables for
	//ReservableItem class (String id, and timeArray)
	private ArrayList<ItemType> reservableItems;
	
	/**
	 * Make the new ArrayList
	 */
	public ResManager()
	{
		reservations = new ArrayList<>();
		reservableItems = new ArrayList<>();
	}
	
	/**
	 * This method adds the items in the reservableItems list.
	 * @param item
	 */
	public void addReservable(ItemType item)
	{
		reservableItems.add(item);
	}
	
	/**
	 * Makes the reservations depending on the time slot and the fitness 
	 * value.
	 * 
	 * @param trialRes
	 * @return
	 */
	public Reservation makeReservation(ResType trialRes)
	{
		//Initialize these values.
		int timeSlot = trialRes.getTime();
		int bestFit = 0;
		int bestInd = -1;
		int notBest = 0;

		//Make a ReservableItem object but don't make a new one.
		ReservableItem r = null;
		
		//For each ReservableItem, see if the table or boat is available.
		for(int i = 0; i < reservableItems.size(); i++)
		{
			//Get the item 
			r = reservableItems.get(i);
			
			//Get the boolean array of the time slots
			boolean[] timeArray = r.getTimeArray();
			
			//If the timeSlot inside that time array is set to true, then 
			//this customer cannot reserve this spot so it goes onto the 
			//next item.
			if(timeArray[timeSlot] == true)
			{
				continue;
			}
			
			//Get the fitness value for Table or Boat.
			int fitnessValue = r.getFitnessValue(trialRes);

			//Track the best fit.
			if(fitnessValue > bestFit)
			{
				//Also track the best index because we'll have to find the 
				//item that has the best fit in the arrayList.
				bestFit = fitnessValue;
				bestInd = i;
			}
		}
		//If there is a fit is greater than 0, then do this.
		if(bestFit > 0)
		{
			//Get the best index where the best fit was and set that
			//time slot to true.
			reservableItems.get(bestInd).setTime(timeSlot);
			
			//Take any fit that is greater than 0
			//Mark the item's time slot to true.
			//Add to the reservations list
			
			//Set the table to the best fit
			trialRes.setResourceId(reservableItems.get(bestInd).getId());
			//Add the reservation
			reservations.add(trialRes);
			return trialRes;
		}
		else if(bestFit <= notBest)
		{
			//If the best fit is 0, then add it to the beginning of the 
			//ArrayList, we'll do something with it in the sort method.
			reservations.add(0, trialRes);
			return trialRes;
		}
		else
		{
			return null;
		}
		
	}
	
	/**
	 * Sorts the list by name and gets rid of the unsuccessful reservations.
	 */
	public void sortReservations()
	{
		//Removes the index that are unsuccessful, which have the id as null.
		//This is why we treated the notBest variable as a stack when we added
		for(int l = 0; l < reservations.size(); l++)
		{
			//Removes if the table is null.
			if(reservations.get(0).getResourceId() == null)
			{
				reservations.remove(0);
			}	
		}
		
		//Bubble sort.
		for(int i = 0; i < reservations.size() - 1; i++)
		{
			for(int j = 0; j < reservations.size() - i - 1; j++)
			{
				//If at index j, the name is Lexicographically greater than
				//at index j + 1, then swap them.
				if(reservations.get(j).getCustomer().compareTo
						(reservations.get(j + 1).getCustomer()) > 0)
				{
					ResType temp = reservations.get(j);
					reservations.set(j, reservations.get(j + 1));
					reservations.set(j + 1, temp);
				}
			}
		}
	}
	
	@Override 
	/**
	 * To string that will create the list of the reservations.
	 */
	public String toString()
	{
		String val = "";
		for(int i = 0; i < reservations.size(); i++)
		{
			val += reservations.get(i).toString();
		}
		return val;
	}
}
