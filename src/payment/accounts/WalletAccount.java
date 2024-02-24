package payment.accounts;

public class WalletAccount implements Account {
  private String mobileNumber;
  private double balance;

  public WalletAccount(String mobileNumber, double balance) {
    this.mobileNumber = mobileNumber;
    this.balance = balance;
  }

  public String getMobileNumber() { return mobileNumber; }
  public double getBalance() { return balance; }

  public void setBalance(double balance) { this.balance = balance; }
}
