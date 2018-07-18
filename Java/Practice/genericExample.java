import java.util.Scanner;

public class genericExample {
    public static void main(String[] args){
        Integer[] iArray = {1, 2, 3, 4, 5};
        String[] sArray = {"Jacob", "Billy", "Ryan", "Elijah"};

        String[] dataArrays = {"iArray", "sArray"};

        printData(dataArrays);
    }

    public static <T> void printData(T[] dataArray){
        for (T i:dataArray){
            System.out.printf("%s ", i);
        }
        System.out.println("");
    }
}



// Example 1:

// import java.util.Scanner;
//
// public class genericExample {
//     public static void main(String[] args){
//         Integer[] iArray = {1, 2, 3, 4, 5};
//         String[] sArray = {"Jacob", "Billy", "Ryan", "Elijah"};
//
//         String[] dataArrays = {"iArray", "iArray"};
//
//         System.out.println(dataArrays);
//         printData(sArray);
//     }
//
//     public static <T> void printData(T[] dataArray){
//         for(T i:dataArray){
//             System.out.printf("%s ", i);
//         }
//         System.out.println("");
//     }
// }
