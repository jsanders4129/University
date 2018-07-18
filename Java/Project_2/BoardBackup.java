import java.util.Arrays;
import java.util.Scanner;

public class Board{
    private Cell[][] board;
    private int rows;
    private int columns;
    private int boatQuantity;
    private boolean debugMode = false;
    private boolean droneView = false;
    private int droneX;
    private int droneY;

    public Board(int iRows, int iColumns){
        try{
            if ((3 <= iRows && iRows <= 12) && (3 <= iColumns && iColumns <= 12)){
                rows = iRows;
                columns = iColumns;
                board = new Cell[rows][columns];
                setupCells(debugMode);

                if (rows == 3 || columns == 3){
                    boatQuantity = 1;
                }
                else if ((3 < rows && rows <= 5) || (3 < columns && columns <= 5)){
                    boatQuantity = 2;
                }
                else if ((5 < rows && rows <= 7) || (5 < columns && columns <= 7)){
                    boatQuantity = 3;
                }
                else if ((7 < rows && rows <= 9) || (7 < columns && columns <= 9)){
                    boatQuantity = 4;
                }
                else if ((9 < rows && rows <= 12) || (9 < columns && columns <= 12)){
                    boatQuantity = 6;
                }
            }
            else {
                throw new BoardGridOutOfBoundsException("Invalid input for board demensions." + "\n");
            }
        }
        catch(BoardGridOutOfBoundsException exception){
            System.out.println(exception);
            System.exit(0);
        }
    }

    public Board(int iRows, int iColumns, boolean iDebugMode){
        try{
            if ((3 <= iRows && iRows <= 12) && (3 <= iColumns && iColumns <= 12)){
                rows = iRows;
                columns = iColumns;
                board = new Cell[rows][columns];
                debugMode = iDebugMode;
                if (debugMode == true){
                    setupCells(debugMode);
                }

                if (rows == 3 || columns == 3){
                    boatQuantity = 1;
                }
                else if ((3 < rows && rows <= 5) || (3 < columns && columns <= 5)){
                    boatQuantity = 2;
                }
                else if ((5 < rows && rows <= 7) || (5 < columns && columns <= 7)){
                    boatQuantity = 3;
                }
                else if ((7 < rows && rows <= 9) || (7 < columns && columns <= 9)){
                    boatQuantity = 4;
                }
                else if ((9 < rows && rows <= 12) || (9 < columns && columns <= 12)){
                    boatQuantity = 6;
                }
            }
            else {
                throw new BoardGridOutOfBoundsException("Invalid input for board demensions." + "\n");
            }
        }
        catch(BoardGridOutOfBoundsException exception){
            System.out.println(exception);
            System.exit(0);
        }
    }

    public int getRow(int row, int column){
        return board[row][column].getRow();
    }

    public int getColumn(int row, int column){
        return board[row][column].getColumn();
    }

    public boolean getBoat(int row, int column){
        return board[row][column].getBoat();
    }

    public int getBoats(){
        return boatQuantity;
    }


    public boolean getCellHealth(int row, int column){
        return board[row][column].getCellHealth();
    }
    public void setCellHealth(int row, int column){
        board[row][column].setCellHealth(false);
    }

    public void setMissedBoat(int row, int column){
        board[row][column].setMissedShot();
    }
    public boolean getMissedBoat(int row, int column){
        return board[row][column].getMissedShot();
    }

    public void setupCells(boolean debugMode){
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[row].length; column++){
                board[row][column] = new Cell(row, column);
                if (debugMode == true){
                    System.out.print("("
                    + Integer.toString(board[row][column].getRow()) + "," + " "
                    + Integer.toString(board[row][column].getColumn()) + ", "
                    + Boolean.toString(board[row][column].getBoat()) + ", "
                    + Boolean.toString(board[row][column].getCellHealth())
                    + ") ");
                }
                System.out.println();
            }
        }
    }

    public void setUpBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public void setBoats(){
        boolean placedBoat = false;
        int boatCount = 0;
        boolean exit = false;
        while(boatCount<boatQuantity){ //while the number of placed boats is less than total
            double rDirection = Math.random(); //this determines if the boat will face horizontal,
            long direction = Math.round(rDirection); //or vertical

            double x = Math.random(); //this determines the x coordinate to place the boat
            int x1 = (int)(x*columns);

            double y = Math.random(); //this determines the y coordinate to place the boat
            int y1 = (int)(y*rows);

            placedBoat = false;
            exit = false;

            if (!board[y1][x1].getBoat()){//if the random spot is open
                int changed = 0;
                while (!placedBoat && !exit){
                    if (direction == 1){
                        //the && is to keep it from going out of bounds
                        if (y1 + 1 < rows && !board[y1+1][x1].getBoat()){ //if the spot above it is open
                            if (y1 + 2 <rows && !board[y1+2][x1].getBoat()){//if two spots above it are open
                                board[y1][x1].setBoat();//then place boat
                                board[y1+1][x1].setBoat();
                                board[y1+2][x1].setBoat();
                                placedBoat = true;
                            }
                            else if (y1 - 1 >= 0 && !board[y1-1][x1].getBoat()){//if spot above and below are open
                                board[y1][x1].setBoat();//then place boat
                                board[y1+1][x1].setBoat();
                                board[y1-1][x1].setBoat();
                                placedBoat = true;
                            }
                        }
                        else if(y1 - 2 >= 0 && !board[y1-1][x1].getBoat() && !board[y1-2][x1].getBoat()){
                            board[y1][x1].setBoat();//then place boat
                            board[y1-1][x1].setBoat();
                            board[y1-2][x1].setBoat();
                            placedBoat = true;
                        }
                        if (!placedBoat && changed < 1){
                            direction = 0;
                            changed += 1;
                        }
                    }

                    if (direction == 0){
                        if (x1 + 1 < columns && !board[y1][x1+1].getBoat()){ //if the spot above it is open
                            if(x1 + 2 < columns && !board[y1][x1+2].getBoat()){//if two spots above it are open
                                board[y1][x1].setBoat();//then place boat
                                board[y1][x1+1].setBoat();
                                board[y1][x1+2].setBoat();
                                placedBoat = true;

                            }
                            else if (x1 - 1 >= 0 && !board[y1][x1-1].getBoat()){//if spot above and below are open
                                board[y1][x1].setBoat();//then place boat
                                board[y1][x1+1].setBoat();
                                board[y1][x1-1].setBoat();
                                placedBoat = true;

                            }
                        }
                        else if (x1 - 2 >= 0 && !board[y1][x1-1].getBoat() && !board[y1][x1-2].getBoat()){
                            board[y1][x1].setBoat();//then place boat
                            board[y1][x1-1].setBoat();
                            board[y1][x1-2].setBoat();
                            placedBoat = true;
                        }
                        if(!placedBoat && changed < 1){
                            direction = 1;
                            changed += 1;
                        }
                    }
                    if(!placedBoat && changed >= 1){
                        exit = true;
                    }
                }
            }
            if(placedBoat){
                boatCount += 1;
            }
        }
    }

    public void printBoard(){
        char printer;
        int rowCounter = 0;
        int columnCounter = 0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (i == 0 && j == 0){
                    for (int x = 0; x < board[i].length; x++){
                        if (x == 0){
                            System.out.print("                 " + columnCounter + "  ");
                            columnCounter++;
                        }
                        else {
                            System.out.print(columnCounter + "  ");
                            columnCounter++;
                        }
                    }
                    System.out.println("");
                    for (int s = 0; s < board[i].length + 2; s++){
                        if (s == 0){
                            System.out.print("               ");
                            System.out.print("\u2554");
                        }
                        else if (s == board[i].length + 1){
                            System.out.println("\u2550" + "\u2557");
                        }
                        else if (s == 1){
                            System.out.print("\u2550" + "\u2569");
                        }
                        else {
                            System.out.print("\u2550" + "\u2550" + "\u2569");
                        }
                    }
                }
                if(board[i][j].getBoat()){
                    if(board[i][j].getCellHealth()){
                        printer = '\u2591';
                    }
                    else{
                        printer = 'x';
                    }
                }
                else{
                    if(board[i][j].getMissedShot()){
                        printer = 'o';
                    }
                    else{
                        printer = '\u2591';
                    }
                }
                if(j==0){
                    System.out.print("            " + rowCounter + "  " + "\u2562" +  " " + printer +"  ");
                }
                else if(j==columns-1&& i != rows-1){
                    System.out.print(printer + " " + "\u255f" + "  " + rowCounter);
                    rowCounter++;
                }
                else if(j==columns-1 && i==rows-1){
                    System.out.print(printer + " " + "\u255f" + "  " +  rowCounter);
                    rowCounter++;
                }
                else{
                    System.out.print(printer + "  ");

                }
            }
            System.out.println("");
            System.out.print("               ");
            for (int m = 0; m < board[i].length + 1; m++){
                if (m == 0){
                    System.out.print("\u2560");
                }
                else {
                    System.out.print("\u2550" + "\u2550" + "\u2550");
                }
            }
            System.out.print("\u2563");
            System.out.println("");
        }
        System.out.println("");
        if (droneView == true){
            sendDrone(droneX, droneY);
        }

    }

    public boolean boatsAreRemaining(){
        boolean answer=false;
        for(int i=0;i<rows;i++){
            //board[i]=false;
            for(int j=0;j<columns;j++){
                if(board[i][j].getBoat() &&board[i][j].getCellHealth()){
                    answer = true;
                }
            }
        }
        return answer;
    }

    public void sendDrone(){
        if (droneView == true){
            sendDrone(int xDrone, int yDrone);
        }
    }

    public void sendDrone(int xSpot,int ySpot){
        droneView = true;
        droneX = xSpot;
        droneY = ySpot;

        int loopCounter = 0;
        char printer;
        boolean answer=false;
        boolean droneHeader = false;
        int droneViewPadding = 0;
        for(int i=ySpot-1;i<ySpot+2;i++){
            if(i>=0){
                for(int j=xSpot-1;j<xSpot+2;j++){
                    if (j>= 0){
                        if (loopCounter == 0){
                            droneHeader = true;
                        }
                        else{
                            droneHeader = false;
                        }
                        if(j>=0){
                            if(board[i][j].getBoat()){
                                if(board[i][j].getCellHealth()){
                                    printer = 'B';//signifies boat with health
                                }
                                else{
                                    printer = 'X';//boat is hit
                                }

                            }
                            else{
                                if(board[i][j].getMissedShot()){
                                    printer ='o';//missed shot on water
                                }
                                else{
                                    printer = '.';//water
                                }

                            }
                            if(j==xSpot-1){
                                if (droneHeader == true){
                                    while (droneViewPadding < board[i].length + 10){
                                        System.out.print(" ");
                                        droneViewPadding++;
                                    }
                                    System.out.print("Tactical Drone-View" + '\n' + '\n');
                                    droneViewPadding = 0;
                                }
                                while (droneViewPadding <  board[i].length + 12){
                                    System.out.print(" ");
                                    droneViewPadding++;
                                }
                                if (i == ySpot-1){
                                    for (int droneColumnCounter = 0; droneColumnCounter < 3; droneColumnCounter++){
                                        if (droneColumnCounter == 0){
                                            System.out.print("    " + droneColumnCounter + "  ");
                                        }
                                        else{
                                            System.out.print(droneColumnCounter + "  ");
                                        }
                                    }
                                    droneViewPadding = 0;
                                    System.out.println("");
                                    while (droneViewPadding < board[i].length + 12){
                                        System.out.print(" ");
                                        droneViewPadding++;
                                    }
                                        for (int droneTopBorder = 0; droneTopBorder < 4; droneTopBorder++){
                                            if (droneTopBorder == 0){
                                                System.out.print("  " + "\u2554");
                                            }
                                            else if (droneTopBorder == 3){
                                                System.out.print("\u2550" + "\u2557");
                                            }
                                            else if (droneTopBorder == 1){
                                                System.out.print("\u2550" + "\u2569" + "\u2550" + "\u2550" + "\u2569");
                                            }
                                            else {
                                                System.out.print( "\u2550" + "\u2550" + "\u2569");
                                            }
                                        }
                                }
                                System.out.println("");
                                droneViewPadding = 0;
                                while (droneViewPadding < board[i].length + 12){
                                    System.out.print(" ");
                                    droneViewPadding++;
                                }
                                System.out.print(i + " " + "\u2562" +  " " + printer +"  ");
                                droneViewPadding = 0;
                            }
                            // else if(j==columns-1&& i != rows-1){
                            //   System.out.print(printer+"|");
                            // }
                            else if(j==xSpot+1){
                                System.out.print(printer + " " + "\u255f" + " " + i + '\n');
                                droneViewPadding = 0;
                            }
                            else{
                                System.out.print(printer+"  ");
                            }
                        }
                    }
                }
            }
                while (droneViewPadding < board[0].length + 12){
                    System.out.print(" ");
                    droneViewPadding++;
                }
                for (int droneBottomBorder = 0; droneBottomBorder < 3; droneBottomBorder++){
                    if (droneBottomBorder == 0){
                        System.out.print("  " + "\u2560" + "\u2550");
                    }
                    else {
                        System.out.print("\u2550" + "\u2550" + "\u2550" + "\u2550");
                    }
                }
                System.out.print("\u2563");
                loopCounter++;
        }
        System.out.println("");
        System.out.println("");
    }

    public static void main(String[] args){
        int numberofTurns = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Board Rows: ");
        int rows = scan.nextInt();
        System.out.print("Board Columns: ");
        int columns = scan.nextInt();

        Board board = new Board(rows, columns);

        board.setUpBoard();
        board.setBoats();
        board.printBoard();

        while(board.boatsAreRemaining()){ //while there are boats still floating
            System.out.println("Number of Turns Used: " + numberofTurns);
            System.out.println("Press 1 to fire a shot");
            System.out.println("Shot cost: 1 turn");

            System.out.println("Press 2 to use a drone to uncover a 3x3 area!");
            System.out.println("Shot Cost: 4 turns");
            int choice = scan.nextInt();

            if(choice==1){
                System.out.println("What is the x and y coordinate of your shot? ");
                System.out.println("row: ");
                int yShot = scan.nextInt();//get y coordinate of the shot
                System.out.println("column: ");
                int xShot = scan.nextInt();//get x coordinate of the shot

                if(board.getBoat(yShot,xShot)){//if there is a boat under the shot
                    if(!board.getCellHealth(yShot,xShot)){//if the boat is already hit here
                        System.out.println('\n'+"penalty");
                        numberofTurns+=1;
                    }
                    else{
                        System.out.println('\n'+"hit!");//if this spot is not already hit,
                        board.setCellHealth(yShot,xShot);//mark this as hit
                    }

                }
                else{
                    if(board.getMissedBoat(yShot,xShot)){
                        System.out.println('\n'+"u missed here already!");//mark this as a missed shot
                        System.out.println('\n'+"penalty");
                        numberofTurns+=1;

                    }
                    else{
                        System.out.println('\n'+"u missed!");//mark this as a missed shot
                        board.setMissedBoat(yShot,xShot);
                    }

                }

                numberofTurns+=1;
                board.printBoard();
            }
            else if(choice == 2){

              System.out.println("What x and y coordinate should we send the drone? ");
              System.out.println("row: ");
              int yShot = scan.nextInt();//get y coordinate of the shot
              System.out.println("column: ");

              int xShot = scan.nextInt();//get x coordinate of the shot
              System.out.println("");

              numberofTurns+=4;
              board.printBoard();
              board.sendDrone(yShot,xShot);

            }
        }
        System.out.println("u win");
        System.out.println("it only took you "+numberofTurns+" turns");
    }

    protected static class BoardGridOutOfBoundsException extends Exception {
        private static final long serialVersionUID = 000001;

        public BoardGridOutOfBoundsException() {

        }

        public BoardGridOutOfBoundsException(String message) {
            super ("Invalid input for board demensions." + "\n");
        }

        public BoardGridOutOfBoundsException(Throwable cause) {
            super (cause);
        }

        public BoardGridOutOfBoundsException(String message, Throwable cause) {
            super (message, cause);
        }
    }
}
