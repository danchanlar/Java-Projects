//Danai Chanlaridou , AM: 5386

import java.util.ArrayList;
import java.util.List;

class Cell{
  private int row;
  private int column;
  private boolean ifMineExists;
  private boolean ifCellIsOpen;
  private int mineCounter;
  private ArrayList<Cell> neighbors;

  public Cell(int row, int column){
    this.row = row;
    this.column = column;
  }

  public void addNeighbor(Cell neighbor){
    this.neighbors.add(neighbor);
    neighbor.neighbors.add(this);
  }
  public void addMine(){
    this.ifMineExists = true;
    for (Cell neighbor : this.neighbors) {
        if (!neighbor.ifMineExists) {
            neighbor.mineCounter++;
        }
    }
  }
  public void open(){
    this.ifCellIsOpen = true;
  }

  public boolean isOpen(){
    return this.ifCellIsOpen;
  }

  public boolean containsMine(){
    return this.ifMineExists;
  }

  public String toString(){
    if (!this.ifCellIsOpen){
      return "-";
    }
    else if (this.ifMineExists){
      return "*";
    }
    else{
      return Integer.toString(this.mineCounter);
    }
  }
}
