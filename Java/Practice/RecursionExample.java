import java.util.Scanner;

// -- Recursion is a method that calls itself.

public class RecursionExample{
  public static long factorial(int n){
    if (n < 0) {
      throw new IllegalArgumentException("n cannot be negative.");
    }
    // Bsae Case:
    else if (n == 0 || n == 1) {
      return 1;
    }
    else {
      // Algorithmic & Recurssive-Call Case:
      return n * factorial(n - 1);
    }
  }

  public static int sumN(int n){
    if (n < 0) {
      throw new IllegalArgumentException("n cannot be negative.");
    }

    else if (n == 0) {
      return 0;
    }

    else{
      return n + sumN(n - 1);
    }
  }

  public static void main(String[] args){
    RecursionExample newObject = new RecursionExample();

    int number = newObject.sumN(5);
    System.out.println(number);
  }
}
