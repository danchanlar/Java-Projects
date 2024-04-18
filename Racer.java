// Danai Chanlaridou, AM: 5386

public class Racer{
  private String name;
  private Vehicle vehicle;
  private double totalTime = 0;

  public Racer(String name , Vehicle vehicle){
    this.name = name;
    this.vehicle = vehicle;
  }

  public double getFuel(){
    return vehicle.getFuelAmount();
  }

  public void race(Road road){
    double fuelConsumption = vehicle.race(road, getFuel());
    totalTime += vehicle.time(road.getLength(), fuelConsumption);
  }
  public void refuel(){
    vehicle.refuel();
  }

  public String toString(){
    return "name:  " + name + ", " + "totalTime: " + totalTime + " Vehicle " + vehicle.toString();
  }

  // Accessor methods
    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getTotalTime() {
        return totalTime;
    }

    // Mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
}
