//Danai Chanlaridou , AM: 5386

import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give the board size:");
        int numRows = input.nextInt();
        int numCols = input.nextInt();
        System.out.println("Give the number of mines:");
        int numMines = input.nextInt();
        System.out.println("The number of players are: ");
        int numPlayers = input.nextInt();
        System.out.println("Give the names of players: ");
        input.nextLine(); // consume newline
        String playerNamesString = input.nextLine();
        String[] playerNames = playerNamesString.split(",");
        MineSweeper mineSweeper = new MineSweeper(numRows, numCols, numMines, numPlayers, playerNames, new Random());
        mineSweeper.play();
    }
}
