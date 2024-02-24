package payment.services;

public class BillApiFactory {
    public static BillApi getBillApi(String billType) {
        if (billType == null) {
            return null;
        }
        if (billType.equalsIgnoreCase("GAS")) {
            return new GasBillApi();
        } else if (billType.equalsIgnoreCase("ELECTRICITY")) {
            return new ElectricityBillApi();
        } else if (billType.equalsIgnoreCase("WATER")) {
            return new WaterBillApi();
        }
        return null;
    }
}
