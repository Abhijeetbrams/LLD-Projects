package Enum;

public enum OperationalStatus {
    OPERATIONAL,
    NON_OPERATIONAL,
    UNDER_MAINTENANCE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
