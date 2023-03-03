public class Engine {

    private String FuelType;
    double currentFuelLv;
    double maxFuelLv;

    public Engine(String FuelType, double currentFuelLv, double maxFuelLv) {
        this.FuelType = FuelType;
        this.currentFuelLv = currentFuelLv;
        this.maxFuelLv = maxFuelLv;

    }
    
    public String getFuelType() {
        return FuelType;
    }

    public double getCurrentFuelLv() {
        return currentFuelLv;
    }

    public double getMaxFuelLv() {
        return maxFuelLv;
    }
    
    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public void setCurrentFuelLv(double currentFuelLv) {
        this.currentFuelLv = currentFuelLv;
    }

    public void setMaxFuelLv(double maxFuelLv) {
        this.maxFuelLv = maxFuelLv;
    }

    public void refuel() {
        this.currentFuelLv = maxFuelLv;
    }

    public void go() {
        if (this.currentFuelLv <= 0) {
            throw new RuntimeException("Train is out of fuel. Please refuel.");
        }
        this.currentFuelLv -= 0.5;
        System.out.println("Remaining fuel level: " + this.currentFuelLv);
    }
}
