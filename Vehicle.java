// Danai Chanlaridou, AM: 5386

public abstract class Vehicle {
    private String name;
    private double fuelAmount;
    private int kilometres;
    private boolean hasTurns;
    private double totalTime = 0;

    public Vehicle(String name, double fuelAmount) {
        this.name = name;
        this.fuelAmount = fuelAmount;
    }

    public double updateConsumptionFactor(double consumptionFator){
      if (hasTurns){
        consumptionFator = consumptionFator * 1.1;
      }return consumptionFator;
    }

    public abstract double computeConsumptionFactor(Road road);

    public double race(Road road, double fuelConsumed) {
        double consumptionFactor = computeConsumptionFactor(road);
        double actualFuelConsumption = fuelConsumed / consumptionFactor;
        double speed = actualFuelConsumption/kilometres;
        speed = speed / consumptionFactor;
        double time = road.getLength() / speed;
        fuelAmount = fuelAmount - fuelConsumed;
        return time;
    }
    public double time(double distance, double fuelConsumption){
      double time = distance/fuelConsumption;
      return time;
    }

    public void refuel() {
        fuelAmount += 10;
    }

    public String toString() {
        return "Vehicle: " + name + ", Fuel: " + fuelAmount;
    }
    public double getTotalTime() {
        return totalTime;
    }

    public String getName() {
        return name;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}
