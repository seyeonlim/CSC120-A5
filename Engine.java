public class Engine {

    private FuelType fuelType;
    private double currentFuelLv;
    private double maxFuelLv;

    public Engine(FuelType fuelType, double currentFuelLv, double maxFuelLv) {
        this.fuelType = fuelType;
        this.currentFuelLv = currentFuelLv;
        this.maxFuelLv = maxFuelLv;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public double getCurrentFuelLv() {
        return this.currentFuelLv;
    }

    public double getMaxFuelLv() {
        return this.maxFuelLv;
    }

    public void refuel() {
        this.currentFuelLv = maxFuelLv;
    }

    public void go() {
        if (this.currentFuelLv <= 0) {
            throw new RuntimeException("Train is out of fuel. Please refuel.");
        }
        this.currentFuelLv -= 10;
        System.out.println("Remaining fuel level: " + this.currentFuelLv);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 200.0);
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
/*We recommend you startt by implementing the `Engine` class. Your `Engine` class will need:
 
  - a private `FuelType` attribute to indicate what type of fuel it uses, and `double`s to store the 
  current and maximum fuel levels (along with an approproate accessors for each)
  - a constructor, which takes in initial values for the attributes named above and sets them appropriately
  - a method `public void refuel()` which will reset the `Engine`'s current fuel level to the maximum
  - a method `public void go()` which will decrease the current fuel level and print some useful information 
  (e.g. remaining fuel level) provided the fuel level is above 0 (otherwise it should throw a `RuntimeException` containing an informative message)
*/
