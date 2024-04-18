// Danai Chanlaridou, AM: 5386

import java.util.Random;

public class RaceTrack{
    private Road[] track;
    private int index;

    public RaceTrack(int sizeOfArray){
      track = new Road[sizeOfArray];
      Random random = new Random();
      for (int i = 0; i < sizeOfArray; i++) {
            int roadType = random.nextInt(3); // random value 0, 1 ή 2 for the type of road
            int length = random.nextInt(51) + 50; // random length form 50 to 100

            switch (roadType) {
                case 0:
                    track[i] = new Road(length);
                    break;
                case 1:
                    track[i] = new DirtyRoad(length);
                    break;
                case 2:
                    track[i] = new RockyRoad(length);
                    break;
            }
        }

        index = 0;
    }

    public int nextSegment(){
      return index + 1;
    }

    public boolean reachedEnd(){
      if (index >= track.length){
        System.out.println("End of Track!");
      }return true;
    }

    public void printRemainingTrack(){
      System.out.println("Remaining Track: ");
    }

    public static void main(String[] args) {
        Road road = new Road(10);

        System.out.println("Initial track: ");
        road.getRemainingDistance());


        for (int i = 0; i < 10; i++) {
            road.getRemainingDistance();
            System.out.println("Track after " + (i + 1) + " segment:");
            road.getRemainingDistance();
        }


        if (road.reachedEnd()) {
            System.out.println("Track is over! ");
        } else {
            System.out.println("Track is not over yet!");
        }
    }


}
