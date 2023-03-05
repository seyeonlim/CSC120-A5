/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version March 6, 2023
 * Description: A class that creates a car for a train. Allows passengers to onboard or get off the car and can 
 *              return the capacity of the car, seats remaining, and the names of passengers onboard.
 */
import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengersOnboard;
    private int passengerCapacity;

    /**
     * Creates a Car and an ArrayList, which is for boarding passengers, and initializes all attributes
     * @param passengerCapacity
     */
    public Car(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        this.passengersOnboard = new ArrayList<Passenger>(passengerCapacity);
    }

    /**
     * a method that gets the maximum capacity of a car
     * @return the capacity of a car
     */
    public int getCapacity() {
        return passengerCapacity;
    }

    /**
     * a method that returns the seats remaining in a car
     * @return the total number of seats remianing in a car
     */
    public int seatsRemaining() {
        return passengerCapacity - this.passengersOnboard.size();
    }

    /**
     * a method that adds a passenger to a car
     * @param p
     * @throws RuntimeException when the car is full
     * @throws RuntimeException when the passenger is already onboard
     */
    public void addPassenger(Passenger p) {
        if (this.passengersOnboard.size() >= passengerCapacity) {
			throw new RuntimeException("Car is already at capacity; cannot add passenger " + p.name);
		}
		if (this.passengersOnboard.contains(p)) {
			throw new RuntimeException("Passenger " + p.name + " is already onboard.");
		}
		this.passengersOnboard.add(p);
		System.out.println("Successfully added passenger " + p.name);
	}

    /**
     * a method that removes a passenger from a car
     * @param p
     * @throws RuntimeException when the passenger is not onboard
     */
    public void removePassenger(Passenger p) {
        if (!this.passengersOnboard.contains(p)) { 
            throw new RuntimeException("Passenger " + p.name + " is not onboard; cannot remove passenger.");
        }
        this.passengersOnboard.remove(p);
        System.out.println("Passenger " + p.name + " successfully removed.");
    
    }

    /**
     * a method that prints the names of the passengers onboard
     */
    public void printManifest() {
        if (this.passengersOnboard.size() == 0) {
            System.out.println("This car is EMPTY.");
        }
        for (Passenger p : passengersOnboard) {
            p.getPassengerInfo();
        }

    }

    /**
     * Demonstration of making passengers and using addPassenger(...), removePassenger(...), and printManifest methods
     * @param args
     */
    public static void main(String[] args) {
        Car myCar = new Car(3);
        Passenger me = new Passenger("Seyeon");
        Passenger friend = new Passenger("Bob");
        System.out.println(myCar.getCapacity());
        myCar.addPassenger(me);
        myCar.addPassenger(friend);
        System.out.println(myCar.seatsRemaining());
        myCar.printManifest();
        myCar.removePassenger(friend);
        myCar.printManifest();
        myCar.removePassenger(me);
        myCar.printManifest();
        me.boardCar(myCar);
        me.boardCar(myCar);
        me.getOffCar(myCar);
        me.getOffCar(myCar);
    }
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