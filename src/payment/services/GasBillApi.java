package payment.services;

public class GasBillApi extends BillApi {
    double gasUsage;
    double gasUnitPrice;
    public void createBill() {
        gasUsage = Math.random() * 100;
        gasUnitPrice = 1.5;
        amount = gasUsage * gasUnitPrice;
        billContents = "Gas bill created\ngas usage: " + gasUsage + " m3\ngas unit price: " +
                gasUnitPrice + "\ntotal amount: " + amount + "\nBill date: " + getDate();
    }
}
