package payment.services;

import payment.apis.PaymentApiCreator;
import user.UserRegistration;
import user.PaymentInfo;
import user.UsersApi;

import java.util.Scanner;

public class InstapayTransfer extends TransferApi{
    public InstapayTransfer(){
        UsersApi usersApi = UserRegistration.usersApi;
        System.out.println("enter the receiver User Name");
        Scanner in = new Scanner(System.in);
        String name=in.next();
        int userid=usersApi.getUserId(name);
        PaymentInfo paymentInfo = usersApi.getUserPaymentInfo(userid);
        PaymentApiCreator paymentApiCreator = new PaymentApiCreator();
        reciverpaymentApi=paymentApiCreator.createPaymentApi(paymentInfo.getPaymentProviderName());
        this.reciverID=paymentInfo.getPaymentKey();
    }
    
}
