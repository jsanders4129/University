//Austin Basala Basal006
//Jacob Sanders Sande917

public class Cell{
    private int row;
    private int column;
    private boolean emptyShot = false;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public void setOtherBoats(int boat2y,int boat2x,int boat3y,int boat3x){
      y2=boat2y;
      x2=boat2x;
      y3=boat3y;
      x3=boat3x;
    }
    public int getBoat2x(){
      return x2;
    }
    public int getBoat2y(){
      return y2;
    }
    public int getBoat3x(){
      return x3;
    }
    public int getBoat3y(){
      return y3;
    }

    private boolean boat = false;

    private boolean cellHealth = true;

    public Cell(){

    }

    public Cell(int iRow, int iColumn){
        row = iRow;
        column = iColumn;
    }

    public void setRow(int inputRow){
        row = inputRow;

    }
    public int getRow(){
        return row;
    }

    public void setColumn(int inputColumn){
        column = inputColumn;
    }
    public int getColumn(){
        return column;
    }

    public void setBoat(){
        boat = true;
    }
    public boolean getBoat(){
        return boat;
    }

    public void setCellHealth(boolean health){
        cellHealth = health;
    }
    public boolean getCellHealth(){
        return cellHealth;
    }

    public void setMissedShot(){
      emptyShot = true;
    }

    public boolean getMissedShot(){
      return emptyShot;
    }
}
