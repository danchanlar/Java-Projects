// Danai Chanlaridou, AM: 5386

import java.util.Scanner;

public class RacingGame{
  public static void main(String[] args){
    Road road = new Road(10); //10 slices
    RaceParticipants participants = new RaceParticipants();
    System.out.println("What kind of vehicle do you want? (1: Motorbike,2:Car,3:Jeep)");
    Scanner input = new Scanner(System.in);
    input.nextInt();
    while (!road.reachedEnd()){
      System.out.println("Remaining distance: " + road.getRemainingDistance());
      participants.refuelAllVehicles();
      participants.runRaceSegment(road);
      participants.printRaceResults();
    }

    System.out.println("Race is finished! The winner is " + participants.getWinner());
  }
}
