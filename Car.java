import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<Passenger>(maxCapacity);
    }

    public int getCapacity() {
        return maxCapacity;
    }

    public int seatsRemaining() {
        return maxCapacity - this.passengersOnboard.size();
    }

    public void addPassenger(Passenger p) {
        if (this.passengersOnboard.size() >= maxCapacity) {
			throw new RuntimeException("Car is already at capacity; cannot add passenger " + p.name);
		}
		if (this.passengersOnboard.contains(p)) {
			throw new RuntimeException("Passenger " + p.name + " is already onboard.");
		}
		this.passengersOnboard.add(p);
		System.out.println("Successfully added passenger " + p.name);
	}

    public void removePassenger(Passenger p) {
        if (!this.passengersOnboard.contains(p)) { 
            throw new RuntimeException("Passenger " + p.name + " is not onboard; cannot remove passenger.");
        }
        this.passengersOnboard.remove(p);
        System.out.println("Passenger " + p.name + " successfully removed.");
    
    }

    public void printManifest() {
        if (this.passengersOnboard.size() == 0) {
            System.out.println("This car is EMPTY.");
        }
        for (Passenger p : passengersOnboard) {
            p.getPassengerInfo();
        }

    }

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