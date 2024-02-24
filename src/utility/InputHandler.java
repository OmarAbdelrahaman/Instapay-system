package utility;

import java.io.IOError;
import java.util.Scanner;

public class InputHandler {
  public static int TakeChoice(int min, int max) {
    do {
      System.out.println("Enter the choice (" +min + ":" + max + "): ");
      try {
        Scanner in = new Scanner(System.in);
        int choice = Integer.parseInt(in.nextLine());
        if (choice >= min && choice <= max) {
          return choice;
        }
        System.out.println("Invalid choice, please try again");
      } catch (NumberFormatException e) {
        System.out.println("Invalid choice, please try again");
      }
    } while (true);
  }

  public static String TakeLine(String keyName) {
    do {
      try {
        System.out.println("Enter the " + keyName + ": ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
      } catch (IOError e) {
        System.out.println("Invalid input, please try again");
      }
    } while (true);
  }
}
