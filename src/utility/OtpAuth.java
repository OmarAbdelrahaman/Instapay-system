package utility;

import java.util.Random;
import java.util.Scanner;

public class OtpAuth {

  private String generateOtp() {
    Random random = new Random();
    int otp = random.nextInt(9000) + 1000;
    String otpString = String.format("%04d", otp);
    return otpString;
  }

  public boolean authenticate(String mobileNumber) {
    String otp = generateOtp();
    System.out.println("Your OTP is: " + otp);
    return respond(otp);
  }

  private boolean respond(String otp) {
    Scanner in = new Scanner(System.in);
    String enteredOtp = in.nextLine();
    return enteredOtp.equals(otp);
  }
}
