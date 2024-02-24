package user;

import payment.apis.PaymentApi;
import payment.apis.PaymentApiCreator;
import utility.InputHandler;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserRegistration {
  public static UsersApi usersApi;
  PaymentApi paymentApi;


  public UserRegistration() {
    if (Objects.isNull(usersApi)) {
      this.usersApi = new UsersApi();
    }
  }

  public static  <T> T chooseEntity(ArrayList<T> entities, String entityName) {
    System.out.println("Choose your " + entityName + ":");
    for (int i = 0; i < entities.size(); i++) {
      T entity = entities.get(i);
      System.out.print((i + 1) + " ");
      if (entity instanceof Bank) {
        System.out.println(((Bank) entities.get(i)).getName());
      } else if (entity instanceof WalletProvider) {
        System.out.println(((WalletProvider) entities.get(i)).getName());
      }
    }
    int c = InputHandler.TakeChoice(1, entities.size());
    return entities.get(c - 1);
  }

  private String verifyCredentials() {
    var credentials = paymentApi.getCredentials();
    for (String key : credentials.keySet()) {
      String value = InputHandler.TakeLine(key);
      credentials.put(key, value);
    }
    return paymentApi.verify(credentials);
  }

  private String[] getBankIdAndAccountNumber() {
    Bank bank = chooseEntity(usersApi.getBanks(), "bank");
    PaymentApiCreator paymentApiCreator = new PaymentApiCreator();
    paymentApi = paymentApiCreator.createPaymentApi(bank.getName());
    String accountNumber = verifyCredentials();
    if (accountNumber == null) { return null; }
    return new String[]{String.valueOf(bank.getId()), accountNumber};
  }

  private String[] getWalletProviderIdAndMobileNumber() {
    WalletProvider walletProvider = chooseEntity(usersApi.getWalletProviders(), "wallet provider");
    PaymentApiCreator paymentApiCreator = new PaymentApiCreator();
    paymentApi = paymentApiCreator.createPaymentApi(walletProvider.getName());
    String mobileNumber = verifyCredentials();
    if (mobileNumber == null) { return null; }
    return new String[]{String.valueOf(walletProvider.getId()), mobileNumber};
  }

  private boolean addNewUser(String[] paymentInfo, boolean isBankApi) {
    String username = InputHandler.TakeLine("Username");
    String password = InputHandler.TakeLine("Password");
    String usernamePattern = "^[a-zA-Z0-9_]+$";
    String passwordPattern = "(?=.*[^0-9\\s]{2}).{8,}";
    if (!Pattern.matches(usernamePattern, username)) {
      System.out.println("Username should consists of only letters, numbers and underscores");
      return false;
    }
    if (!Pattern.matches(passwordPattern, password)) {
      System.out.println("Password should consists of at least 8 characters and at least 2 non-numeric characters");
      return false;
    }
    User user = new User(username, password);
    boolean isAdded = false;
    if (isBankApi) {
      isAdded = usersApi.addUser(user, new UserBankAccount(Integer.parseInt(paymentInfo[0]), Integer.parseInt(paymentInfo[1])));
    } else {
      isAdded = usersApi.addUser(user, new UserWalletMobile(Integer.parseInt(paymentInfo[0]), paymentInfo[1]));
    }
    return isAdded;
  }

  private int getRegisterChoice() {
    System.out.println("1- Use Bank Account");
    System.out.println("2- Use Mobile Wallet");
    System.out.println("3- Back");
    return InputHandler.TakeChoice(1, 3);
  }

  public void register() {
    int c = getRegisterChoice();
    if (c == 3) { return; }
    String[] paymentInfo = null;
    if (c == 1) {
      paymentInfo = getBankIdAndAccountNumber();
    } else if (c == 2) {
      paymentInfo = getWalletProviderIdAndMobileNumber();
    }
    if (Objects.isNull(paymentInfo)) {
      System.out.println("Registration failed");
      return;
    }
    boolean isBankApi = c == 1;
    boolean isAdded = addNewUser(paymentInfo, isBankApi);
    if (isAdded) {
      System.out.println("Registration succeeded");
    } else {
      System.out.println("Registration failed");
    }
  }

  public ActiveUser login() {
    String username = InputHandler.TakeLine("Username");
    String password = InputHandler.TakeLine("Password");
    User user = usersApi.getUser(username, password);
    if (user == null) {
      System.out.println("Login Failed");
      return null;
    }
    PaymentInfo paymentInfo = usersApi.getUserPaymentInfo(user.getId());
    PaymentApiCreator paymentApiCreator = new PaymentApiCreator();
    ActiveUser activeUser = new ActiveUser(user, paymentInfo.getPaymentKey(),
        paymentApiCreator.createPaymentApi(paymentInfo.getPaymentProviderName()));
    System.out.println("Login succeeded");
    return activeUser;
  }

}
