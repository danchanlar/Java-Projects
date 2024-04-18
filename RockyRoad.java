// Danai Chanlaridou, AM: 5386

import java.util.Random;

public class RockyRoad extends Road{
    private int size;

    public RockyRoad(int kilometres){
      super(kilometres);
      this.size = new Random().nextInt(3);
    }

    public double updateConsumptionFactor(double consumptionFator){
      super.updateConsumptionFactor(consumptionFator);
      if (size == 2){
        consumptionFator = consumptionFator*1.2;
        return consumptionFator;
      }if (size == 1){
        consumptionFator = consumptionFator*1.1;
        return consumptionFator;
      }else{
        return consumptionFator;
      }
    }

    public String toString(){
      return getKilometres() + " klm of rocky road " +  hasTurns() + "with turns " + "and rock size " + size;
    }

    public int getType(){
      return 2;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
