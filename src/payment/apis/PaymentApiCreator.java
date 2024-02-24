package payment.apis;

import payment.apis.banks.CibApi;
import payment.apis.banks.HsbcApi;
import payment.apis.banks.QnbApi;
import payment.apis.wallets.EtisalatApi;
import payment.apis.wallets.OrangeApi;
import payment.apis.wallets.VodafoneApi;

import java.util.Objects;

public class PaymentApiCreator {
  private PaymentApi createBankApi(String bankName) {
    if (Objects.isNull(bankName)) {
      return null;
    }
    if (bankName.equalsIgnoreCase("CIB")) {
      return new CibApi();
    } else if (bankName.equalsIgnoreCase("QNB")) {
      return new QnbApi();
    } else if (bankName.equalsIgnoreCase("HSBC")) {
      return new HsbcApi();
    }
    return null;
  }

  private PaymentApi createWalletApi(String walletProviderName) {
    if (Objects.isNull(walletProviderName)) {
      return null;
    }
    if (walletProviderName.equalsIgnoreCase("Vodafone")) {
      return new VodafoneApi();
    } else if (walletProviderName.equalsIgnoreCase("Etisalat")) {
      return new EtisalatApi();
    } else if (walletProviderName.equalsIgnoreCase("Orange")) {
      return new OrangeApi();
    }
    return null;
  }

  public PaymentApi createPaymentApi(String paymentName) {
    PaymentApi paymentApi = null;
    paymentApi = createBankApi(paymentName);
    if (paymentApi == null) { paymentApi = createWalletApi(paymentName); }
    return paymentApi;
  }
}
