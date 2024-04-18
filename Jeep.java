// Danai Chanlaridou, AM: 5386

public class Jeep extends Vehicle{
  private double[] consumptionFators = {0.25 , 0.3 , 0.35};

  public Jeep(){
    super("Jeep" , 0);
  }

  public double computeConsumptionFactor(Road road){
    road.updateConsumptionFactor(0.2);
    return consumptionFators[road.getType()];
  }
}
