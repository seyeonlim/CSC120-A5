/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version March 6, 2023
 * Description: A class that creates a train using the Engine class and Car class.
 *              Allows access to the information of engine and car, the total capacity of the train and the
 *              seats remaining, and the names of passengers on train.
 */
import java.util.ArrayList;

public class Train {

    private final Engine engine;
    private ArrayList<Car> cars;

    /**
     * creates a train; sets its engine and creates an ArrayList for the cars attached to the train
     * @param fuelType
     * @param currentFuelLv
     * @param fuelCapacity
     * @param nCars
     * @param passengerCapacity
     */
    public Train(FuelType fuelType, double currentFuelLv, double fuelCapacity, int nCars, int passengerCapacity) {
        engine = new Engine(fuelType, currentFuelLv, fuelCapacity);
        cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(passengerCapacity));
        }
    }

    /**
     * a method that returns the information of the engine on train
     * @return information of engine on train
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * a method that returns the information of a certain car using the index of cars ArrayList
     * @param i
     * @return information of a certain car on train
     */
    public Car getCar(int i) {
        return this.cars.get(i-1);
    }
    
    /**
     * a method that returns the maximum capacity of the train
     * @return the maximum capacity of the whole train
     */
    public int getMaxCapacity() {
        return this.cars.size() * cars.get(1).getCapacity(); //should change when passenger capacity isn't the same for all cars
    }

    /**
     * a method that returns the seats remaining on the train
     * @return total seats remaining on the train
     */
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for (Car car : cars) {
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * a method that prints out the names of passengers on train
     */
    public void printManifest() {
        for (Car car : cars) {
            car.printManifest();
        }
    }

    /**
     * Demonstration of making a train and using getEngine, getCar(...), getMaxCapacity, seatsRemaining, and printManifest methods
     * @param args
     */
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.STEAM, 100.0, 200.0, 5, 3);
        Passenger me = new Passenger("Seyeon");
        Passenger friend = new Passenger("Bob");
        System.out.println(myTrain.getEngine());
        System.out.println(myTrain.getCar(1));
        System.out.println(myTrain.getMaxCapacity());
        myTrain.cars.get(0).addPassenger(friend);
        myTrain.cars.get(1).addPassenger(me);
        System.out.println(myTrain.seatsRemaining());
        myTrain.printManifest();
        
    }

}