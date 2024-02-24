
import utility.InputHandler;
import user.UserRegistration;
import user.ActiveUser;


public class Main {
  static ActiveUser activeUser = null;
  static public UserRegistration userRegistration = new UserRegistration();
  static boolean loggedIn = false;

  public static boolean userRegistrationMenu() {
    System.out.println("Welcome to the InstaPay system");
    System.out.println("===================");
    System.out.println("1- Register");
    System.out.println("2- Login");
    System.out.println("3- Exit");
    int c = InputHandler.TakeChoice(1, 3);
    if (c == 3) { return false; } // exit the program
    if (c == 1) {
      userRegistration.register();
    } else if (c == 2) {
      activeUser = userRegistration.login();
      if (activeUser == null) {
        System.out.println("Login failed");
        return true;
      }
      loggedIn = true;
      System.out.println("Welcome " + activeUser.getUser().getUsername());
    }
    return true;
  }
  public static void userMenu(){
    System.out.println("What do you want to do?");
    System.out.println("1- Pay bill");
    System.out.println("2- Transfer money");
    System.out.println("3- Inquire balance");
    System.out.println("4- Logout");
    int choice = InputHandler.TakeChoice(1, 4);
    switch (choice) {
      case 1:
        System.out.println("Gas");
        System.out.println("Electricity");
        System.out.println("Water");
        String billType = InputHandler.TakeLine("bill type");
        activeUser.getPaymentApi().payBill(activeUser.getPaymentKey(), billType);
        break;
      case 2:
        System.out.println("1- Transfer to Bank Account");
        System.out.println("2- Transfer to Wallet using mobile number");
        System.out.println("3- Transfer to Instapay account");
        int transfertype = InputHandler.TakeChoice(1, 3);
        activeUser.getPaymentApi().Transfer(activeUser.getPaymentKey(), transfertype);
        break;
      case 3:
        System.out.println("Your balance is " + activeUser.getPaymentApi().inquireBalance(activeUser.getPaymentKey()));
        break;
      case 4:
        activeUser = null;
        loggedIn = false;
        break;
    }
  }

  public static void main(String[] args) {
    while (true) {
      if (!loggedIn) {
        if (!userRegistrationMenu()) {
          break;
        }
      }
      else {
        userMenu();
      }



    }
  }
}
