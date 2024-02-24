package payment.services;
import payment.apis.PaymentApi;
import java.util.Scanner;

public abstract class TransferApi {
    PaymentApi senderpaymentApi,reciverpaymentApi;
    protected String reciverID;
    double amount;
    
    public void SetsenderpaymentApi(PaymentApi paymentApi) {
        this.senderpaymentApi = paymentApi;
    }
    
    public void EnterAmount(){
        System.out.println("Write the amount you want to transfer");
        Scanner in = new Scanner(System.in);
        double amount = 0.0;
        try {
            amount=in.nextDouble();
        } catch (Exception e) {
            System.out.println("Error occurred, please enter a valid amount");
            EnterAmount();
        }
        this.amount=amount;
    }
    
    public void TransferExec(String senderID){
        if (reciverpaymentApi.isBankApi() && !senderpaymentApi.isBankApi()){
            System.out.println("Transfer failed, You must login with Bank account");
            return;
        }
        
        boolean depo=reciverpaymentApi.deposit(reciverID, amount);
        boolean with=senderpaymentApi.withdraw(senderID, amount);
        if(depo && with){
            System.out.println("Transfer succeed ");
            double sendercurbalance=senderpaymentApi.inquireBalance(senderID);
            System.out.println("Your current balance is :" + sendercurbalance);
            double receivercurbalance=reciverpaymentApi.inquireBalance(reciverID);
            System.out.println("The receiver balance is :" + receivercurbalance);
        }
        else if(!depo && with){
            System.out.println("Error occurred, check the selected Bank/Wallet provider");
            with=senderpaymentApi.deposit(senderID, amount);
            return;
        }else if (depo && !with){
            System.out.println("Error occurred, you dent have enough balance ");
            depo=reciverpaymentApi.withdraw(reciverID, amount);
            return;
        }else {
            System.out.println("Error occurred");
        }
        
    }
    
    
    
  
}
