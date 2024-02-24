package user;

public class UserWalletMobile {
  private int userId;
  private int walletProviderId;
  private String mobileNumber;

  public UserWalletMobile(int walletId, String mobileNumber) {
    this.userId = -1;
    this.walletProviderId = walletId;
    this.mobileNumber = mobileNumber;
  }

  protected UserWalletMobile(int userId, int walletId, String mobileNumber) {
    this.userId = userId;
    this.walletProviderId = walletId;
    this.mobileNumber = mobileNumber;
  }

  public int getUserId() { return userId; }
  public int getWalletProviderId() { return walletProviderId; }
  public String getMobileNumber() { return mobileNumber; }
  public void setUserId(int userId) { this.userId = userId; }
}
