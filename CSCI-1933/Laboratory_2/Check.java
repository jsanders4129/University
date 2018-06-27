import java.util.Scanner;

public class Check{
  public String stringValue;
  private String dollars;
  private int iDollars;
  private int cents;
  private int inputTemp;

  public String convertAll(String input){
    dollars = input.substring(0, input.length() - 3);
    cents = Integer.parseInt(input.substring(input.length() - 2));

    String longHandCents = Integer.toString(cents) + "/" + "100";

    return convert(dollars) + " " + "dollars " + "and " + longHandCents + " " + "cents";
  }

  public String convert(String dollars){
    int dLength = dollars.length();
    if (dLength == 0){
      throw new IllegalArgumentException("The length of input cannot be 0");
    }
    else{
      char element = dollars.charAt(0);
      if (dLength == 1){
        switch (dollars){
          case "0": stringValue = "";
            break;
          case "1": stringValue = "one";
            break;
          case "2": stringValue = "two";
            break;
          case "3": stringValue = "three";
            break;
          case "4": stringValue = "four";
            break;
          case "5": stringValue = "five";
            break;
          case "6": stringValue = "six";
            break;
          case "7": stringValue = "seven";
            break;
          case "8": stringValue = "eight";
            break;
          case "9": stringValue = "nine";
            break;
          default: stringValue = "Error";
            break;
        }
      }
      else if (dLength == 2){
        if (element == '1'){
          switch(dollars){
            case "10": stringValue = "ten";
              break;
            case "11": stringValue = "eleven";
              break;
            case "12": stringValue = "twelve";
              break;
            case "13": stringValue = "thirteen";
              break;
            case "14": stringValue = "fourteen";
              break;
            case "15": stringValue = "fifteen";
              break;
            case "16": stringValue = "sixteen";
              break;
            case "17": stringValue = "seventeen";
              break;
            case "18": stringValue = "eighteen";
              break;
            case "19": stringValue = "nineteen";
              break;
            default: stringValue = " error";
          }
        }
        else{
          String rString = dollars.substring(1);
          switch(element){
            case '0': stringValue = "";
              break;
            case '2': stringValue = "twenty" + " " + convert(rString);
              break;
            case '3': stringValue = "thirty" + " " + convert(rString);
              break;
            case '4': stringValue = "forty" + " " + convert(rString);
              break;
            case '5': stringValue = "fifty" + " " + convert(rString);
              break;
            case '6': stringValue = "sixty" + " " + convert(rString);
              break;
            case '7': stringValue = "seventy" + " " + convert(rString);
              break;
            case '8': stringValue = "eighty" + " " + convert(rString);
              break;
            case '9': stringValue = "ninety" + " " + convert(rString);
              break;
            default: stringValue = "error";
              break;
            }
          }
      }
      else if (dLength == 3){
        String nHundred = dollars.substring(0, 1);
        String rString = dollars.substring(1);
        if (dollars.substring(1, 2).equals("0") && dollars.substring(2).equals("0") && !dollars.substring(0, 1).equals("0")){
          stringValue = convert(nHundred) + " " + "hundred";
        }
        else if (dollars.substring(1, 2).equals("0") && !dollars.substring(2).equals("0") && !dollars.substring(0, 1).equals("0")){
          stringValue = convert(nHundred) + " " + "hundred" + " " + convert(dollars.substring(2));
        }
        else{
          if (nHundred.equals("0")){
            stringValue = convert(rString);
          }
          else{
            stringValue = convert(nHundred) + " " + "hundred" + " " + convert(rString);
          }
        }
      }
      else if (dLength == 4){
        stringValue = convert(dollars.substring(0, 1)) + " " + "thousand " + convert(dollars.substring(1));
      }
      else if (dLength == 5){
        stringValue = convert(dollars.substring(0, 2)) + " " + "thousand " + convert(dollars.substring(2));
      }
      else if (dLength == 6){
        stringValue = convert(dollars.substring(0, 3)) + " " + "thousand " + convert(dollars.substring(3));
      }
      else if (dLength == 7){
        stringValue = "one million";
      }
    return stringValue;
    }
  }



  public static void main(String[] args){
    Check check = new Check();
    Scanner scan = new Scanner(System.in);
    String dollars = scan.next();
    System.out.println(check.convertAll(dollars));
  }
}
