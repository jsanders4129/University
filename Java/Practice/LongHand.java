import java.util.Scanner;

public class Check{
  private double dollar;

  public void convertString(String input){
    dollar = Double.parseDouble(input);
    }
  public double getDollar(){
    return dollar;
  }

  public static void main(String[] args){
    Check check = new Check();
    Scanner scan = new Scanner(System.in);
    String dollar = scan.next();
    check.convertString(dollar);
    System.out.println(check.getDollar());
  }
}
