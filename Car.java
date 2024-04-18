// Danai Chanlaridou, AM: 5386

public class Car extends Vehicle{
  private double[] consumptionFators = {0.1 , 0.35 , 0.45};

  public Car(){
    super("Car" , 0);
  }

  public double computeConsumptionFactor(Road road){
    road.updateConsumptionFactor(0.2);
    return consumptionFators[road.getType()];
  }
}
