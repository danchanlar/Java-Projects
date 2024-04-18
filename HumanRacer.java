// Danai Chanlaridou, AM: 5386

import java.util.Scanner;

public class HumanRacer extends Racer{
    private Scanner scanner;

    public HumanRacer(String name, Vehicle vehicle) {
        super(name, vehicle);
        scanner = new Scanner(System.in);
    }

    public double getFuel() {
        System.out.print("How much fuel do you want to use? ");
        double fuelQuantity = scanner.nextDouble();
        return fuelQuantity;
    }

}
