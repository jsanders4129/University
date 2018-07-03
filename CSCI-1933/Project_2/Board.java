public class Board{
    public Cell[][] board;

    public Board(int rows, int columns){
        try{
            if ((3 <= rows && rows <= 12) && (3 <= columns && columns <= 12)){
                board = new Cell[rows][columns];
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

    public void setupCells(){
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[row].length; column++){
                board[row][column] = new Cell(row, column);
                System.out.print("(" + Integer.toString(board[row][column].getRow()) + "," + " " + Integer.toString(board[row][column].getColumn()) + ", " + Boolean.toString(board[row][column].getBoat()) + ", " + Boolean.toString(board[row][column].getCellHealth()) + ") ");
            }
            System.out.println();
        }
    }

    public void setupBoats(){
        Boat boat = new Boat(0, 1, 2, 0, 0, 0);
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

    public static void main(String[] args){
        Board board = new Board(5, 5);
        board.setupCells();

    }
}
