package payment.services;

import payment.apis.PaymentApi;

import java.util.Date;

public abstract class BillApi {
    String billContents;
    double amount;
    String billStatus;
    public String getDate() {
        return new Date().toString();
    }
    public  abstract void createBill();
    public void payBill(String userId, PaymentApi paymentApi) {
        createBill();
        if(paymentApi.withdraw(userId, amount)) {
            billStatus = "paid";
            billContents += "\nBillStatus: " + billStatus;
            System.out.println(billContents);
        } else {
            billStatus = "unpaid";
            billContents += "\nBillStatus: " + billStatus;
            System.out.println(billContents);
            System.out.println("Bill payment failed due to insufficient balance");
        }
    }
}

