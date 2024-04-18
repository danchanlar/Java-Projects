// Danai Chanlaridou, AM: 5386

import java.util.Random;

public class Road{
  private int kilometres;
  private boolean hasTurns;
  private int length;
  private int distance;
  private Road[] track;
  private int index;

  public Road(int kilometres){
    this.kilometres = kilometres;
    this.hasTurns = new Random().nextBoolean();
  }

  public int getLength(){
    return length;
  }
  public int getRemainingDistance(){
    return distance;
  }

  public boolean reachedEnd(){
    if (index >= track.length){
      System.out.println("End of Track!");
    }return true;
  }

  public double updateConsumptionFactor(double consumptionFator){
    if (hasTurns){
      consumptionFator = consumptionFator * 1.1;
    }return consumptionFator;
  }

  public String toString(){
    return kilometres + "klm of  paved road with " + hasTurns + "turns";
  }

  public int getType(){
    return 0;
  }
  public void setKilometres(int kilometres){
    this.kilometres = kilometres;
  }

  public void setHasTurns(boolean hasTurns){
    this.hasTurns = hasTurns;
  }

  public int getKilometres(){
    return kilometres;
  }

  public boolean hasTurns(){
    return hasTurns;
  }
}
