public class Passenger {
    
    String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void getPassengerInfo() {
        System.out.println("Name: " + this.name);
    }

    public void boardCar(Car c) {
        try {
        c.addPassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getOffCar(Car c) {
        try {
        c.removePassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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

/*- `public void boardCar(Car c)` can call `c.addPassenger(this)` 
to board a given `Car` (_Hint: this method should be ready to `catch` 
the `RuntimeException` that will be thrown by `c.addPassenger(...)` 
in the event that the car is full._)
 - `public void getOffCar(Car c)` can call `c.removePassenger(this)` 
 to get off a given `Car` (_Hint: this method should be ready to `catch` 
 the `RuntimeException` that will be thrown by `c.removePassenger(...)` in 
 the event that the `Passenger` wasn't actually onboard._)
 */