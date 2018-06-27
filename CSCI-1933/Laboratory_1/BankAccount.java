public class BankAccount {
  public String name;
  public String password;
  public double balance;

  public BankAccount(String initName, String initPassword, double initBalance){
    name = initName;
    password = initPassword;
    balance = initBalance;
  }

  public void withdraw(String enteredPassword, double amount){
    if(password.equals(enteredPassword) && balance >= amount){
      balance -= amount;
    }
  }

  public void deposit(String enteredPassword, double amount){
    if(password.equals(enteredPassword)){
      balance += amount;
    }
  }
  public double getBalance(String enteredPassword){
    if (password.equals(enteredPassword)){
      return balance;
    } else {
      return -1;
    }
  }

  public boolean setPassword(String oldPassword, String newPassword){
    if (password.equals(oldPassword)){
      password = newPassword;
      return true;
    } else {
      return false;
    }
  }


  public void setName(String newName) {
    name = newName;
  }

  public String getName() {
    return name;
  }
}
