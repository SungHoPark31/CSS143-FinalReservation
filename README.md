# CSS143-FinalReservation
The purpose of this assignment is to give you additional experience in 
inheritance, generics, sort, and more complex data structures – as well
as larger projects.


You are to write a general-purpose reservation system.  You will then 
extend this system to be able to reserve Tables in a Restaurant, and 
to reserve Boats with boat rental company.

In all three cases (Base system, Restaurant system, and Boat Rental system) 
you will read in the resources to reserve from provided files: 
A list of tables and how many people they seat, and a list of boats.

Additionally, you will be given two basic Driver classes (one for each derived system)
that will read in the data files, allow the user to make reservations, 
and to print out various information about the state of the system. 

Reservation are made for a time slot, identified only by its position 
in the array of time slots. Each type of ReservableItem has different 
criteria for choosing the best fit.  Similarly, the user enters different
data as part of the reservation request. 

For a table, the user indicates how many people are in the party, and the
table must have at least that many seats.  For the boat, the user gives a 
list of boats, ordered by preference, and the best fit is the first on the 
list that has the requested time slot open.

For example, if I ask for a table to seat 6, I will be given the table
available with at least 6 six seats, but as few extra seats as possible.
If I give a list of three boat types, in order of preference, I get the 
first type if it is available, if not I get the second type, and if that
is not available, I try for the third.
