package payment.apis;

import payment.accounts.Account;
import payment.services.BillApi;
import payment.services.BillApiFactory;
import payment.services.TransferApi;
import payment.services.TransferFactory;

import java.util.HashMap;
import java.util.Objects;

public abstract class PaymentApi {
  protected abstract Account getAccount(String paymentKey);
  public double inquireBalance(String paymentKey) {
    Account account = getAccount(paymentKey);
    return Objects.isNull(account) ? -1 : account.getBalance();
  }
  public boolean deposit(String paymentKey, double amount) {
    Account account = getAccount(paymentKey);
    if (Objects.isNull(account)) {
      return false;
    }
    account.setBalance(account.getBalance() + amount);
    return true;
  }
  public boolean withdraw(String paymentKey, double amount) {
    Account account = getAccount(paymentKey);
    if (Objects.isNull(account) || account.getBalance() < amount) {
      return false;
    }
    account.setBalance(account.getBalance() - amount);
    return true;
  }
  public void payBill(String userId,String billType) {
    BillApi billApi = BillApiFactory.getBillApi(billType);
    if (billApi == null) {
      System.out.println("Bill type not found");
      return;
    }
    billApi.payBill(userId, this);
  }

  public void Transfer(String userId,int transferType) {
    TransferApi transferApi = TransferFactory.getTransferApi(transferType);
    transferApi.SetsenderpaymentApi(this);
    transferApi.EnterAmount();
    transferApi.TransferExec(userId);
  }
  public abstract String verify(HashMap<String, String> credentials);
  public abstract HashMap<String, String> getCredentials();
  public abstract boolean isBankApi();
}
