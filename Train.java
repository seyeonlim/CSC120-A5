import java.util.ArrayList;

public class Train {

    private final Engine engine;
    private ArrayList<Car> cars;

    public Train(FuelType fuelType, double currentFuelLv, double maxFuelLv, int nCars, int maxCapacity) {
        engine = new Engine(fuelType, currentFuelLv, maxFuelLv);
        cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            cars.add(new Car(maxCapacity));
        }
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Car getCar(int i) {
        return this.cars.get(i);
    }
    
    public int getMaxCapacity() {
        return this.cars.size() * cars.get(0).getCapacity();
    }

    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for (Car car : cars) {
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    public void printManifest() {
        for (Car car : cars) {
            car.printManifest();
    }

}

/*
 * -  a private `Engine` attribute, which we will mark with the keyword 
 * `final` to establish the **composition** relationship 
 * (e.g. `private final Engine engine;`)
 -  a private `ArrayList` to keep track of the `Car`s currently attached
 -  a constructor `public Train(FuelType fuelType, double fuelCapacity, 
 int nCars, int passengerCapacity)` which will initialize the `Engine` 
 and `Car`s and store them
 -  a couple of accessors: 
     -  `public Engine getEngine()`
     -  `public Car getCar(int i)` to return the `i`th car
     -  `public int getMaxCapacity()` which will return the maximum 
     total capacity across all `Car`s
     -  `public int seatsRemaining()` which will return the number of 
     remaining open seats across all `Car`s
- and finally, its own `public void printManifest()` that prints a 
roster of all `Passenger`s onboard (_Hint: your `Car`s can help!_)

 */