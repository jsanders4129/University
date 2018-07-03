public class TwoDArrays{
    private int[][] example = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    public TwoDArrays(){

    }

    public TwoDArrays(int[][] arrayInput){
        example = arrayInput;
    }

    public int getLength(){
        return example.length;
    }

    public int getRowLength(int i){
        return example[i].length;
    }

    public int getElement(int i, int j){
        return example[i][j];
    }

    public void displayArray(){
        for (int row = 0; row < example.length; row++){
            for (int column = 0; column < example[row].length; column++){
                System.out.print(example[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        int[][] example = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {10, 11, 12, 13},
            {100}
        };


        TwoDArrays array = new TwoDArrays(example);

        int arrayLength = array.getLength();
        System.out.println(arrayLength);

        int rowLength = array.getRowLength(0);
        System.out.println(rowLength);

        int element = array.getElement(1, 2);
        System.out.println(element);

        array.displayArray();


    }

}
