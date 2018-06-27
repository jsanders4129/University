import java.util.Scanner;

public class TryCatchExample{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    try { // Contains the code that may contain the
      // generated exception.
      double input = scan.nextDouble();
    }
    catch (Exception error){ // Contains the code that will run (Exception is default)
      // "inputMismatchException" is another type of exception that runs if input
      // doesn't match.
      // if an exception does occur.
      //error.printStackTrace(); // Prints the same information when an exception
      // usually occurs.
      System.exit(0); // If an error is caught, it will be printed
      // and the program will stop before the print-statement can
      // be ran.
    }
    // finally{} // will run a block of code with or without an exception.
    System.out.println("No error found");
  }

// Use "throw" to provide a personally made exception. Uses are for validation
// checks. Specifically, IllegalArgumentException for validation cehcks.
  public void setDenominator(int denominator)
{
    if (denominator != 0)
    {
        this.denominator = denominator;
    }
    else
    {
        throw new IllegalArgumentException(
            "denominator cannot be zero.");
    }
}

}
