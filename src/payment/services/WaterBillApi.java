package payment.services;

public class WaterBillApi extends BillApi {
    double waterUsage;
    double waterUnitPrice;
    public void createBill() {
        waterUsage = Math.random() * 40;
        waterUnitPrice = 0.9;
        amount = waterUsage * waterUnitPrice;
        billContents = "Water bill Created\n" +
                "Date" + getDate() + "\n" +
                "Water usage: " + waterUsage + "\n" +
                "Water unit price: " + waterUnitPrice + "\n" +
                "Total amount: " + amount + "\n";
    }
}
