package payment.accounts;

public class BankAccount implements Account {
  private int accountNumber;
  private String creditCardNumber;
  private String pin;
  private String mobileNumber;
  private double balance;

  public BankAccount(int accountNumber, String creditCardNumber, String pin, String mobileNumber, double balance) {
    this.accountNumber = accountNumber;
    this.creditCardNumber = creditCardNumber;
    this.pin = pin;
    this.mobileNumber = mobileNumber;
    this.balance = balance;
  }

  public int getAccountNumber() { return accountNumber; }
  public String getCreditCardNumber() { return creditCardNumber; }
  public String getPin() { return pin; }
  public String getMobileNumber() { return mobileNumber; }
  public double getBalance() { return balance; }

  public void setBalance(double balance) { this.balance = balance; }
}
