package FinalReservation;

/**
 * 
 * @author Sung Ho Park
 * @version 1
 * Class: CSS 143 B
 * Assignment: Final Reservation
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Driver for Boat Reservation system
 * Reads input file and prints reservations to console
 */
public class BoatDriver 
{

	public static void main(String[] args) 
	{
		ResManager<Boat, Reservation> manager = new ResManager<Boat, Reservation>();
		try 
		{
			Scanner input = new Scanner(new FileInputStream("boatFile.txt"));
			Scanner input2 = new Scanner(new FileInputStream("boatFile.txt"));
			while (input.hasNextLine())
			{
				manager.addReservable(new Boat(input));
			}
			while(input2.hasNextLine())
			{
				System.out.println("Adding Boat Type: " + input2.next());
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("file not found");
			System.exit(0);
		}
		
		
		BoatReservation r1 = new BoatReservation("Chen family", 2);
		r1.addBoatPreference("kayak");
		r1.addBoatPreference("zodiak");
		r1.addBoatPreference("canoe");
		manager.makeReservation(r1);
		BoatReservation r2 = new BoatReservation("Singh party", 8);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		r2 = new BoatReservation("Kal", 8);
		r2.addBoatPreference("dinghy");
		r2.addBoatPreference("yacht");
		r2.addBoatPreference("rowboat");
		manager.makeReservation(r2);
		r2 = new BoatReservation("Party9", 8);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		r2 = new BoatReservation("Newmans", 2);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		
	
		r2 = new BoatReservation("Party2", 3);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		r2 = new BoatReservation("Party5", 9);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		r2 = new BoatReservation("Party6", 1);
		r2.addBoatPreference("aircraft carrier");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		r2 = new BoatReservation("Party3", 3);
		r2.addBoatPreference("speedboat");
		r2.addBoatPreference("zodiak");
		r2.addBoatPreference("submarine");
		manager.makeReservation(r2);
		
		// Force failure
		r2 = new BoatReservation("Unlucky party", 3);
		r2.addBoatPreference("zodiak");
		manager.makeReservation(r2);
		
		
		System.out.println("\nreservations before sort by customer");
		System.out.println(manager);
		
		System.out.println("reservations after sort by customer");
		manager.sortReservations();
		System.out.println(manager);
		
	}
	

}
