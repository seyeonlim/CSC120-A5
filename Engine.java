/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version March 7, 2023
 * Description: A class that creates an engine of a train with the fuel type, current fuel level, 
 *              and fuel capacity as its attributes.
 */
public class Engine {

    private FuelType fuelType;
    private double currentFuelLv;
    private double fuelCapacity;

    /**
     * Creates an engine and initializes all attributes
     * @param fuelType the fuel type of engine
     * @param fuelCapacity the maximum fuel level of engine
     * @param currentFuelLv current fuel level of engine
     */
    public Engine(FuelType fuelType, double fuelCapacity) {
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLv = fuelCapacity;
    }

    /**
     * Method that gets the fuel type of engine
     * @return the fuel type of engine
     */
    public FuelType getFuelType() {
        return this.fuelType;
    }

    /**
     * Method that gets the current fuel level of engine
     * @return current fuel level of engine
     */
    public double getCurrentFuelLv() {
        return this.currentFuelLv;
    }

    /**
     * Method that gets the maximum fuel level of engine
     * @return maximum engine capacity
     */
    public double getFuelCapacity() {
        return this.fuelCapacity;
    }

    /**
     * Method that changes the current fuel level to maximum fuel level
     */
    public void refuel() {
        this.currentFuelLv = fuelCapacity;
    }

    /**
     * Method that decreases the current fuel level by 10.0. When fuel level is less than or 
     * equal to 0, it prints out a message telling to refuel.
     * @throws RuntimeException when the current fuel level is below 0.
     */
    public void go() {
        if (this.currentFuelLv <= 0) {
            throw new RuntimeException("Train is out of fuel. Please refuel.");
        }
        this.currentFuelLv -= 10;
        System.out.println("Remaining fuel level: " + this.currentFuelLv);
    }

    /**
     * Demonstrates the making of an engine and the use of refuel and go method
     * @param args
     */
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 200.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        myEngine.refuel();

        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

