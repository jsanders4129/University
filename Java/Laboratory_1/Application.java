public class Application{
  public static void main(String[] args){
    //BankAccount myAccount = new BankAccount();
    //myAccount.password = "Kn0wledge!";
    //myAccount.deposit("Kn0wledge!", 100.500);

    BankAccount myAccount = new BankAccount("Java", "Kn0wledge!", 1500.25);
    System.out.println("My account’s balance is: " + myAccount.balance);
  }
}
