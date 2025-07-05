package Model;

import Enum.OperationalStatus;
import Enum.VehicleType;

@lombok.Data
public class Lot {
    private String LotId;
    private Floor Floor;
    private VehicleType AllowedVehicleType;
    private OperationalStatus operationalStatus;
    private int size;
    private Vehicle vehicle;
    private OccupancyStatus occupancyStatus;

    public Lot(String lotId, Floor floor, VehicleType allowedVehicleType, OperationalStatus operationalStatus, int size) {
        this.LotId = lotId;
        this.Floor = floor;
        this.AllowedVehicleType = allowedVehicleType;
        this.operationalStatus = operationalStatus;
        this.size = size;
    }
}
