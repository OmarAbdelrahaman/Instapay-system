package payment.services;
import java.util.Objects;

public class TransferFactory {
    public static TransferApi getTransferApi(int transferType) {
        if (Objects.equals(transferType,1)) {
            return new BankTransfer();
        } else if (Objects.equals(transferType,2)) {
            return new WalletTransfer();
        } else if (Objects.equals(transferType,3)) {
            return new InstapayTransfer();
        }
        return null;
    }
}
