package user;

import payment.apis.PaymentApi;

public class ActiveUser {
  private User user;
  String paymentKey;
  PaymentApi paymentApi;

  public ActiveUser(User user, String paymentKey, PaymentApi paymentApi) {
    this.user = user;
    this.paymentKey = paymentKey;
    this.paymentApi = paymentApi;
  }


  public User getUser() { return user; }
  public String getPaymentKey() { return paymentKey; }
  public PaymentApi getPaymentApi() { return paymentApi; }
}
