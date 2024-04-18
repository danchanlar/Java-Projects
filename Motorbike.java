// Danai Chanlaridou, AM: 5386

public class Motorbike extends Vehicle{
  private double[] consumptionFators = {0.05 , 0.4 , 0.5};
  // 0.05 for paved road, 0.4 for dirty road and 0.5 for rocky road.

  public Motorbike(){
    super("Motorbike" , 0.0);
  }
  public double computeConsumptionFactor(Road road){
    road.updateConsumptionFactor(0.3);
    return consumptionFators[road.getType()];
  }
}
