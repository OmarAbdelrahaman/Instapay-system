package user;

public class PaymentInfo {
  String paymentProviderName;
  String paymentKey;
  boolean isPaymentBank;

  public PaymentInfo(String paymentProviderName, String paymentKey, boolean isPaymentBank) {
    this.paymentProviderName = paymentProviderName;
    this.paymentKey = paymentKey;
    this.isPaymentBank = isPaymentBank;
  }

  public String getPaymentProviderName() { return paymentProviderName; }
  public String getPaymentKey() { return paymentKey; }
  public boolean isPaymentBank() { return isPaymentBank; }
}
