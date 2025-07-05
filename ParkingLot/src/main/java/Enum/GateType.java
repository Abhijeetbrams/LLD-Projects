package Enum;

public enum GateType {
    ENTRY,
    EXIT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
