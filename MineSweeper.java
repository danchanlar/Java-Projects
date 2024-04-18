//Danai Chanlaridou , AM: 5386

import java.util.Scanner;
import java.util.Random;

class MineSweeper {

    private MineField mineField;
    private Player[] players;
    private int numPlayers;
    private boolean[][] gameBoard;
    private boolean[][] revealedTiles;
    private int currentPlayer;

    public MineSweeper(int numRows, int numCols, int numMines, int numPlayers, String[] playerNames, Random random) {
        this.mineField = new MineField(numRows, numCols, numMines, random);
        this.numPlayers = numPlayers;
        this.players = new Player[this.numPlayers];
        for (int i = 0; i < this.numPlayers; i++) {
            this.players[i] = new Player(playerNames[i]);
        }
        this.currentPlayer = 0;
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("Current player: " + this.players[this.currentPlayer].getName());
            System.out.println(this.mineField);
            boolean foundMine = this.players[this.currentPlayer].play(this.mineField);
            if (foundMine) {
                System.out.println("You found a mine!");
                System.out.println("Your score is now " + this.players[this.currentPlayer].getScore());
                System.out.println("The number of mines remaining is " + (this.mineField.getNumMines() - 1));
            } else {
                System.out.println("You did not find a mine!");
                System.out.println("Your score is now " + this.players[this.currentPlayer].getScore());
                System.out.println("The number of mines remaining is " + (this.mineField.getNumMines()));
            }
            // The players play one after the other
            this.currentPlayer = (this.currentPlayer + 1) % this.numPlayers;
            // The game is over when all the mines have been revealed
            if (mineField.getNumSafeTilesRevealed() == mineField.getNumSafeTiles()) {
                System.out.println("All mines have been found! Game over.");
                gameOver = true;
            }

        }
    }

}
