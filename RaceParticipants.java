// Danai Chanlaridou, AM: 5386

import java.util.Arrays;
import java.util.Scanner;

public class RaceParticipants {
    private Vehicle[] vehicles;

    public RaceParticipants() {
        vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Motorbike();
        vehicles[2] = new Jeep();
    }

    private Vehicle selectVehicle() {
        System.out.println("Select your vehicle:");
        System.out.println("0. Car");
        System.out.println("1. Motorbike");
        System.out.println("2. Jeep");
        Scanner input = new Scanner(System.in);
        int select = input.nextInt();

        switch (select) {
            case 0:
                return new Car();
            case 1:
                return new Motorbike();
            case 2:
                return new Jeep();
            default:
                System.out.println("Invalid selection!");
                return null;
        }
    }

    public void runRaceSegment(Road road) {
        for (Vehicle vehicle : vehicles) {
            vehicle.race(road, vehicle.getFuelAmount());
        }
    }

    public void refuelAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.refuel();
        }
    }

    public void printRaceResults() {
        double[] totalTime = new double[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            totalTime[i] = vehicles[i].getTotalTime();
        }
        Arrays.sort(totalTime);
        System.out.println("Race results: " + Arrays.toString(totalTime));
    }

    public String getWinner() {
        double[] totalTime = new double[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            totalTime[i] = vehicles[i].getTotalTime();
        }
        Arrays.sort(totalTime);
        double winnerTime = totalTime[0];

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getTotalTime() == winnerTime) {
              return "Winner: " + vehicles[i].getName() + " (" + winnerTime + ")";
            }
        }
        return "No winner found.";
    }
}
