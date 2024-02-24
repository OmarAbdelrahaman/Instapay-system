package user;

import java.util.ArrayList;
import java.util.Objects;

public class UsersApi {
  private ArrayList<User> users;
  private ArrayList<Bank> banks;
  private ArrayList<WalletProvider> walletProviders;
  private ArrayList<UserBankAccount> userBankAccounts;
  private ArrayList<UserWalletMobile> userWalletMobiles;

  public UsersApi() {
    users = new ArrayList<>();
    banks = new ArrayList<>();
    walletProviders = new ArrayList<>();
    userBankAccounts = new ArrayList<>();
    userWalletMobiles = new ArrayList<>();
    addWalletProviders:{
      walletProviders.add(new WalletProvider(1, "Vodafone"));
      walletProviders.add(new WalletProvider(2, "Etisalat"));
      walletProviders.add(new WalletProvider(3, "Orange"));
    }
    addBanks:{
      banks.add(new Bank(1, "CIB"));
      banks.add(new Bank(2, "QNB"));
      banks.add(new Bank(3, "HSBC"));
    }
    addUsers:{
      users.add(new User(1, "ahmed", "123456"));
      users.add(new User(2, "mohammed", "123456"));
      users.add(new User(3, "gamal", "123456"));
      users.add(new User(4, "tamer", "123456"));
    }
    addBankAccountNumbers:{
      userBankAccounts.add(new UserBankAccount(1, 1, 11111111));
      userBankAccounts.add(new UserBankAccount(4, 3, 33333333));
    }
    addWalletMobileNumbers:{
      userWalletMobiles.add(new UserWalletMobile(2, 2, "01100000000"));
      userWalletMobiles.add(new UserWalletMobile(3, 3, "01200000000"));
    }
  }

  private boolean isUsernameFound(String username) {
    for (User user : users) {
      if (Objects.equals(username, user.getUsername())) {
        return true;
      }
    }
    return false;
  }

  public boolean isAccountNumberFound(int bankId, int accountNumber) {
    for (UserBankAccount userBankAccount : userBankAccounts) {
      if (accountNumber == userBankAccount.getAccountNumber()
          && bankId == userBankAccount.getBankId()) {
        return true;
      }
    }
    return false;
  }

  public boolean isMobileNumberFound(String mobileNumber) {
    for (UserWalletMobile userWalletMobile : userWalletMobiles) {
      if (Objects.equals(mobileNumber, userWalletMobile.getMobileNumber())) {
        return true;
      }
    }
    return false;
  }

  public User getUser(String username, String password) {
    for (User user : users) {
      if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword())) {
        return user;
      }
    }
    System.out.println("Invalid Username or Password");
    return null;
  }

  public int getUserId(String Username) {
    for (User user : users) {
      if (Objects.equals(Username, user.getUsername())) {
        return user.getId();
      }
    }
    return -1;
  }


  public PaymentInfo getUserPaymentInfo(int userId) {
    for (UserBankAccount userBankAccount : userBankAccounts) {
      if (userId != userBankAccount.getUserId()) { continue; }
      for (Bank bank : banks) {
        if (bank.getId() != userBankAccount.getBankId()) { continue; }
        return new PaymentInfo(bank.getName(), String.valueOf(userBankAccount.getAccountNumber()), true);
      }
    }
    for (UserWalletMobile userWalletMobile : userWalletMobiles) {
      if (userId != userWalletMobile.getUserId()) { continue; }
      for (WalletProvider walletProvider : walletProviders) {
        if (walletProvider.getId() != userWalletMobile.getWalletProviderId()) { continue; }
        return new PaymentInfo(walletProvider.getName(), String.valueOf(userWalletMobile.getMobileNumber()), false);
      }
    }
    System.out.println("Invalid userId");
    return null;
  }

  public boolean addUser(User newUser, UserBankAccount userBankAccount) {
    if (isUsernameFound(newUser.getUsername())) {
      System.out.println("Username used before");
      return false;
    }
    if (isAccountNumberFound(userBankAccount.getBankId(), userBankAccount.getAccountNumber())) {
      System.out.println("Bank Account used before");
      return false;
    }
    int id = users.size() + 1;
    newUser.setId(id);
    userBankAccount.setUserId(id);
    users.add(newUser);
    userBankAccounts.add(userBankAccount);
    return true;
  }

  public boolean addUser(User newUser, UserWalletMobile userWalletMobile) {
    if (isUsernameFound(newUser.getUsername())) {
      System.out.println("Username used before");
      return false;
    }
    if (isMobileNumberFound(userWalletMobile.getMobileNumber())) {
      System.out.println("Mobile number used before");
      return false;
    }
    int id = users.size() + 1;
    newUser.setId(id);
    userWalletMobile.setUserId(id);
    users.add(newUser);
    userWalletMobiles.add(userWalletMobile);
    return true;
  }

  public ArrayList<Bank> getBanks() {
    return banks;
  }

  public Bank getBank(int bankId) {
    for (Bank bank : banks) {
      if (bankId == bank.getId()) {
        return bank;
      }
    }
    System.out.println("Invalid bankId");
    return null;
  }

  public ArrayList<WalletProvider> getWalletProviders() {
    return walletProviders;
  }

  public WalletProvider getWalletProvider(int walletProviderId) {
    for (WalletProvider walletProvider : walletProviders) {
      if (walletProviderId == walletProvider.getId()) {
        return walletProvider;
      }
    }
    System.out.println("Invalid walletProviderId");
    return null;
  }
}
