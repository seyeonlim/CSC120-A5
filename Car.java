/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version March 7, 2023
 * Description: A class that creates a car for a train. Allows passengers to onboard or get off the car and can 
 *              return the capacity of the car, seats remaining, and the names of passengers onboard.
 */
import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengersOnboard;
    private int carCapacity;

    /**
     * Creates a Car and an ArrayList, which is for boarding passengers, and initializes all attributes
     * @param carCapacity
     */
    public Car(int carCapacity) {
        this.carCapacity = carCapacity;
        this.passengersOnboard = new ArrayList<Passenger>(carCapacity);
    }

    /**
     * a method that gets the maximum capacity of a car
     * @return the capacity of a car
     */
    public int getCapacity() {
        return carCapacity;
    }

    /**
     * a method that returns the seats remaining in a car
     * @return the total number of seats remianing in a car
     */
    public int seatsRemaining() {
        return carCapacity - this.passengersOnboard.size();
    }

    /**
     * a method that adds a passenger to a car
     * @param p
     * @throws RuntimeException when the car is full
     * @throws RuntimeException when the passenger is already onboard
     */
    public void addPassenger(Passenger p) {
        if (this.passengersOnboard.size() >= carCapacity) {
			throw new RuntimeException("Car is already at capacity; cannot add passenger " + p.getName());
		}
		if (this.passengersOnboard.contains(p)) {
			throw new RuntimeException("Passenger " + p.getName() + " is already onboard.");
		}
		this.passengersOnboard.add(p);
		System.out.println("Successfully added passenger " + p.getName());
	}

    /**
     * a method that removes a passenger from a car
     * @param p
     * @throws RuntimeException when the passenger is not onboard
     */
    public void removePassenger(Passenger p) {
        if (!this.passengersOnboard.contains(p)) { 
            throw new RuntimeException("Passenger " + p.getName() + " is not onboard; cannot remove passenger.");
        }
        this.passengersOnboard.remove(p);
        System.out.println("Passenger " + p.getName() + " successfully removed.");
    
    }

    /**
     * a method that prints the names of the passengers onboard. Prints oyt a message when there is no passenger onboard
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
