/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version March 6, 2023
 * Description: A class that creates passengers to be on the train. Can print out the names of passengers 
 *              and allows passengers to board or get off car.
 */
public class Passenger {
    
    String name;

    /**
     * creates a passenger and initializes the name attribute
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * a method that prints out the name of the passenger
     */
    public void getPassengerInfo() {
        System.out.println("Name: " + this.name);
    }

    /**
     * a method that allows a passenger to board a car
     * @param c
     */
    public void boardCar(Car c) {
        try {
        c.addPassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * a method that allows a passenger to get off a car
     * @param c
     */
    public void getOffCar(Car c) {
        try {
        c.removePassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Demonstration of using boardCar(...) and getOffCar(...) method
     * @param args
     */
    public static void main(String[] args) {
        Car myCar = new Car(3);
        Passenger me = new Passenger("Seyeon");
        Passenger friend = new Passenger("Bob");
        me.boardCar(myCar);
        friend.boardCar(myCar);
        myCar.printManifest();
        me.getOffCar(myCar);
        myCar.printManifest();
        friend.boardCar(myCar);
        me.getOffCar(myCar);
        
    }
}