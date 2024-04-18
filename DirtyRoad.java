// Danai Chanlaridou, AM: 5386

import java.util.Random;

public class DirtyRoad extends Road{
    private double levelRain;

    public DirtyRoad(int kilometres){
      super(kilometres);
      this.levelRain = new Random().nextDouble();
    }

    public double updateConsumptionFactor(double consumptionFator){
      super.updateConsumptionFactor(consumptionFator);
      if (levelRain >= 0.8 && levelRain <= 1){
        consumptionFator = consumptionFator* 1.2;
        return consumptionFator;
      }
      if (levelRain >= 0.5 && levelRain < 0.8){
        consumptionFator = consumptionFator*1.1;
        return consumptionFator;
      }else{
        return consumptionFator;
      }
    }

    public String toString(){
      return getKilometres() + "klm of dirty road " + hasTurns() + "with turns " + "and rain level " + levelRain;
    }

    public int getType(){
      return 1;
    }

    public double getLevelRain() {
        return levelRain;
    }

    // Mutator method
    public void setLevelRain(double levelRain) {
        this.levelRain = levelRain;
    }
}
