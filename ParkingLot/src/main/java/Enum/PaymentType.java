package Enum;

public enum PaymentType {
    CASH,CARD,UPI,WALLET;

    @Override
    public String toString() {
        return this.name().toUpperCase();
    }
}
