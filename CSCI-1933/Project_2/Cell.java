public class Cell{
    private int row;
    private int column;

    // private int xCoordinateLeft;
    // private int xCoordinateRight;
    // private int yCoordinateLower;
    // private int yCoordinateUpper;

    private boolean boat;

    private boolean cellHealth;

    public Cell(){

    }

    public Cell(int iRow, int iColumn){
        row = iRow;
        column = iColumn;
    }

    public void setRow(int inputRow){
        row = inputRow;
        // xCoordinateLeft = row * 25;
        // xCoordinateRight = xCoordinateLeft + 25;

    }
    public int getRow(){
        return row;
    }

    public void setColumn(int inputColumn){
        column = inputColumn;
        // yCoordinateLower = column * 25;
        // yCoordinateUpper = yCoordinateLower + 25;
    }
    public int getColumn(){
        return column;
    }

    public void setBoat(boolean boatInput){
        boat = boatInput;
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
}
