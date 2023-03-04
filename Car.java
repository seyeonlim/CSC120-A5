public class Car {

}

/*- a private `ArrayList` where it will store the `Passenger`s currently onboard, 
and an `int` for the `Car`'s maximum capacity (since `ArrayList`s will expand as we add objects, 
we'll need to manually limit their size)
 -   - a constructor, which takes in an initial value for the `Car`'s maximum capacity 
 and initializes an appropriately-sized `ArrayList`
 - accessor-like methods `public int getCapacity()` and `public int seatsRemaining()` 
 that return the maximum capacity and remaining seats, respectively
 - methods `public void addPassenger(Passenger p)` and `public void removePassenger(Passenger p)` 
 to add or remove a `Passenger` from the `Car` (_Hint: don't forget to check that there are seats available 
 if someone wants to board, and to confirm that the `Passenger` is actually onboard before trying to remove them! 
 If you encounter a problem, throw a `RuntimeException`._)
 - and a final method `public void printManifest()` that prints out a list of all 
 `Passenger`s aboard the car (or "This car is EMPTY." if there is no one on board) */