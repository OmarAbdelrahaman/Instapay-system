package payment.apis.banks;

import payment.apis.PaymentApi;
import payment.accounts.BankAccount;
import utility.OtpAuth;

import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Objects;

public class CibApi extends PaymentApi {

  private static ArrayList<BankAccount> accounts = new ArrayList<>();

  public CibApi() {
    if (accounts.isEmpty()) {
      accounts.add(new BankAccount(11111111, "1234567890123456", "1234", "01501112222", 1000));
      accounts.add(new BankAccount(22222222, "1234567890123457", "1234", "01501112223", 2000));
      accounts.add(new BankAccount(33333333, "1234567890123458", "1234", "01501112224", 3000));
      accounts.add(new BankAccount(44444444, "1234567890123459", "1234", "01501112225", 4000));
    }
  }

  protected BankAccount getAccount(String accountNumber) {
    for (BankAccount account : accounts) {
      if (accountNumber.equals(String.valueOf(account.getAccountNumber()))) {
        return account;
      }
    }
    return null;
  }

  private BankAccount getAccount(String creditCardNumber, String pin) {
    for (BankAccount account : accounts) {
      if (Objects.equals(creditCardNumber, account.getCreditCardNumber())
          && Objects.equals(pin, account.getPin())) {
        return account;
      }
    }
    return null;
  }

  public String verify(HashMap<String, String> credentials) {
    String creditCardNumber = credentials.get("creditCardNumber");
    String pin = credentials.get("pin");
    BankAccount bankAccount = getAccount(creditCardNumber, pin);
    if (Objects.isNull(bankAccount)) {
      System.out.println("Invalid credit card number or pin");
      return null;
    }
    OtpAuth otpAuth = new OtpAuth();
    if (!otpAuth.authenticate(bankAccount.getMobileNumber())) {
      System.out.println("Invalid OTP");
      return null;
    }
    return String.valueOf(bankAccount.getAccountNumber());
  }

  public HashMap<String, String> getCredentials() {
    HashMap<String, String> credentials = new HashMap<String, String>();
    credentials.put("creditCardNumber", "");
    credentials.put("pin", "");
    return credentials;
  }

  public boolean isBankApi() {
    return true;
  }
}
