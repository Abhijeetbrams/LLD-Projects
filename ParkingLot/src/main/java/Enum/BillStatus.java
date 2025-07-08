package Enum;

public enum BillStatus {
    UNPAID,
    PARTIALLY_PAID,
    PAID;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
