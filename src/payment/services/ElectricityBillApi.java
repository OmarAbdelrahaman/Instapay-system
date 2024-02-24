package payment.services;

public class ElectricityBillApi extends BillApi {
    double electricityUsage;
    double electricityUnitPrice;
    public void createBill() {
        electricityUsage =  Math.random() * 70;
        electricityUnitPrice = 0.5;
        amount = electricityUsage * electricityUnitPrice;
        billContents = "Electricity bill created\nUsage: " + electricityUsage + " kWh\nelectricity unit price: " +
                electricityUnitPrice+ "\ntotal amount: " + amount + "\nBill date: " + getDate();
    }
}
