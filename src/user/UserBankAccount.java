package user;

public class UserBankAccount {
  private int userId;
  private int bankId;
  private int accountNumber;

  public UserBankAccount(int bankId, int accountNumber) {
    this.userId = -1;
    this.bankId = bankId;
    this.accountNumber = accountNumber;
  }

  protected UserBankAccount(int userId, int bankId, int accountNumber) {
    this.userId = userId;
    this.bankId = bankId;
    this.accountNumber = accountNumber;
  }

  public int getUserId() { return userId; }
  public int getBankId() { return bankId; }
  public int getAccountNumber() { return accountNumber; }
  public void setUserId(int userId) { this.userId = userId; }
}
