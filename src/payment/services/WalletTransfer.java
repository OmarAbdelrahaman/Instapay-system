package payment.services;

import payment.apis.PaymentApiCreator;
import user.UserRegistration;
import user.UsersApi;
import user.WalletProvider;

import java.util.Scanner;

public class WalletTransfer extends TransferApi{
    
     public WalletTransfer(){
         UsersApi usersApi = UserRegistration.usersApi;
         WalletProvider wallet = UserRegistration.chooseEntity(usersApi.getWalletProviders(), "wallet provider");
         System.out.println("enter the receiver wallet mobile number");
         Scanner in = new Scanner(System.in);
         String ID=in.next();
         this.reciverID=ID;
         PaymentApiCreator paymentApiCreator = new PaymentApiCreator();
         reciverpaymentApi=paymentApiCreator.createPaymentApi(wallet.getName());
     }
}
