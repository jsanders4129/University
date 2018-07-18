import java.util.Scanner;

public class Check{
  private int dollars;
  private int cents;
  private String longConversion;
  public String stringValue;

  public void convertString(String input){
    dollars = Integer.parseInt(input);
    }
  public double getDollar(){
    return dollars;
  }

  public String convert(int dollars){
    int dLength = Integer.toString(dollars).length();
    String stringValue

    if (dLength == 0){
      throw new IllegalArgumentException("denominator cannot be zero.");
    }
    else{
      if (dlength == 1){
        switch (dollars){
          case 1: stringValue = "one";
          case 2: stringValue = "two";
          case 3: stringValue = "three";
          case 4: stringValue = "four";
          case 5: stringValue = "five";
          case 6: stringValue = "six";
          case 7: stringValue = "seven";
          case 8: stringValue = "eight";
          case 9: stringValue = "nine";
          default: "Error"
        }
      return stringValue
      }
    }
  }

  // public void longHand(){
  //   return 0;
  // }

  public static void main(String[] args){
    Check check = new Check();
    Scanner scan = new Scanner(System.in);
    String dollars = scan.next();
    System.out.println(check.convert(dollars));
  }
}
