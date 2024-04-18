//Danai Chanlaridou , AM: 5386

import java.util.Random;

class MineField {
    private int rows;
    private int columns;
    private int numMines;
    private Cell[][] grid;
    private boolean[][] gameBoard;
    private boolean[][] revealedTiles;

    public MineField(int rows, int columns, int numMines, Random random) {
        this.rows = rows;
        this.columns = columns;
        this.numMines = numMines;
        this.grid = new Cell[rows][columns];
        initializeCells();
        initializeMines();
    }

    private void initializeCells() {
        // create and connect cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(i, j);
                if (i > 0) { // connect north neighbor
                    grid[i][j].addNeighbor(grid[i - 1][j]);
                    if (j > 0) { // connect northwest neighbor
                        grid[i][j].addNeighbor(grid[i - 1][j - 1]);
                    }
                    if (j < columns - 1) { // connect northeast neighbor
                        grid[i][j].addNeighbor(grid[i - 1][j + 1]);
                    }
                }
                if (j > 0) { // connect west neighbor
                    grid[i][j].addNeighbor(grid[i][j - 1]);
                }
                if (j < columns - 1) { // connect east neighbor
                    grid[i][j].addNeighbor(grid[i][j + 1]);
                }
                if (i < rows - 1) { // connect south neighbor
                    grid[i][j].addNeighbor(grid[i + 1][j]);
                    if (j > 0) { // connect southwest neighbor
                        grid[i][j].addNeighbor(grid[i + 1][j - 1]);
                    }
                    if (j < columns - 1) { // connect southeast neighbor
                        grid[i][j].addNeighbor(grid[i + 1][j + 1]);
                    }
                }
            }
        }
    }
    public int getNumSafeTilesRevealed() {
        int count = 0;
        for (int i = 0; i < revealedTiles.length; i++) {
            for (int j = 0; j < revealedTiles[0].length; j++) {
                if (revealedTiles[i][j] && !gameBoard[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumSafeTiles() {
        int count = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (!gameBoard[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void initializeMines() {
        // place mines randomly
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = rand.nextInt(rows*columns);
            int column = rand.nextInt(columns*rows);
            if (!grid[row][column].containsMine()) {
                //grid[row][column].setMine(true);
                minesPlaced++;
            }
        }
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public int getSize() {
        return rows*columns;
    }

    public int getNumMines(){
        return numMines;
    }



    //CREATE MAIN METHOD FOR TESTING

    public static void main(String[] args){
      int rows = 10;
      int columns = 10;
      int numMines = 20;
      Random random = new Random();
      random.setSeed(2023);
      MineField field = new MineField(rows, columns , numMines, random);
      System.out.println(field);
      for (int row = 0; row < rows; row++){
        for (int column = 0; column < columns; column++){
          field.getCell(row, column).open();
        }
      }
      System.out.println(field);
    }
    // END OF MAIN METHOD
}
