public class Boat{
    private int length = 3;
    private boolean vertical;
    private boolean horizontal;
    private int[][] coordinateArray = new int[3][2];
    private boolean boatHealth = true;

    public Boat(int x1, int x2, int x3, int y1, int y2, int y3){
        Board.board[x1][y1].setBoat(true);
        Board[x2][y2].setBoat(true);
        Board[x3][y3].getBoat(true);

        Board[x1][y1].setCellHealth(true);
        Board[x2][y2].setCellHealth(true);
        Board[x3][y3].setCellHealth(true);

        if (x1 == x2){
            vertical = true;
            horizontal = false;
        }
        else {
            horizontal = true;
            vertical = false;
        }
    }
}
