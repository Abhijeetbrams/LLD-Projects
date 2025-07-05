package Enum;

public enum OccupancyStatus {
    OCCUPIED,
    VACANT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
