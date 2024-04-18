//Danai Chanlaridou , AM: 5386

import java.util.Scanner;

class Player{
  private String name;
  private int score; //number of mines that he found

  public Player(String name){
    this.name = name;
    score = 0;
  }

  public boolean play(MineField field){
    Scanner input = new Scanner(System.in);
    int row;
    int column;
    while (true){
      System.out.println("Player " + name + "give the coordinates for the cell to open: ");
      row = input.nextInt();
      column = input.nextInt();

      if (field.getCell(row, column).isOpen()){
        System.out.println("This cell is already open! Please open another one!");
      }else{
        break;
      }
      boolean foundMine = field.getCell(row,column).containsMine();
      if (foundMine == true){
        System.out.println("Mine found!");
        score ++;
        return foundMine;
      }
    }return false;
  }
  public void printStatus(){
    System.out.println("Player " + name + ": " + score + "mines found");
  }

  public String getName(){
    return name;
  }

  public int getScore(){
    return score;
  }
}
