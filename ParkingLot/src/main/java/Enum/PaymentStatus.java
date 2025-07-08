package Enum;

public enum PaymentStatus {
    PENDING,
    COMPLETED,
    FAILED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
