package payment.services;

import user.Bank;
import user.UserRegistration;
import user.UsersApi;
import payment.apis.PaymentApiCreator;

import java.util.Scanner;

public class BankTransfer extends TransferApi {
    
    public BankTransfer(){
         UsersApi usersApi = UserRegistration.usersApi;
         Bank bank = UserRegistration.chooseEntity(usersApi.getBanks(), "bank");
         System.out.println("enter the receiver bank account number");
          Scanner in = new Scanner(System.in);
          String ID=in.next();
          this.reciverID=ID;
         PaymentApiCreator paymentApiCreator = new PaymentApiCreator();
         reciverpaymentApi=paymentApiCreator.createPaymentApi(bank.getName());
            
    }
    
    
}
