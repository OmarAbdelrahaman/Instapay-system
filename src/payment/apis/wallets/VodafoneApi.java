package payment.apis.wallets;

import payment.apis.PaymentApi;
import payment.accounts.WalletAccount;
import utility.OtpAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class VodafoneApi extends PaymentApi {
  private static ArrayList<WalletAccount> accounts = new ArrayList<>();

  public VodafoneApi() {
    if (accounts.isEmpty()) {
      accounts.add(new WalletAccount("01000000000", 100));
      accounts.add(new WalletAccount("01000000001", 200));
      accounts.add(new WalletAccount("01000000002", 300));
    }
  }

  protected WalletAccount getAccount(String mobileNumber) {
    for (WalletAccount account : accounts) {
      if (mobileNumber.equals(account.getMobileNumber())) {
        return account;
      }
    }
    return null;
  }

  public String verify(HashMap<String, String> credentials) {
    String mobileNumber = credentials.get("mobileNumber");
    WalletAccount walletAccount = getAccount(mobileNumber);
    if (Objects.isNull(walletAccount)) {
      System.out.println("Invalid mobile number");
      return null;
    }
    OtpAuth otpAuth = new OtpAuth();
    if (!otpAuth.authenticate(walletAccount.getMobileNumber())) {
      System.out.println("Invalid OTP");
      return null;
    }
    return String.valueOf(walletAccount.getMobileNumber());
  }

  public HashMap<String, String> getCredentials() {
    HashMap<String, String> credentials = new HashMap<String, String>();
    credentials.put("mobileNumber", "");
    return credentials;
  }

  public boolean isBankApi() {
    return false;
  }
}
