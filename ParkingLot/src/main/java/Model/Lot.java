package Model;

import Enum.OccupancyStatus;
import Enum.OperationalStatus;
import Enum.VehicleType;
import Enum.*;

@lombok.Data
public class Lot {
    private Integer LotId;
    private Floor Floor;
    private VehicleType AllowedVehicleType;
    private OperationalStatus operationalStatus;
    private int size;
    private Vehicle vehicle;
    private OccupancyStatus occupancyStatus;

    public Lot(Integer lotId, Floor floor, VehicleType allowedVehicleType, OccupancyStatus occupancyStatus,OperationalStatus operationalStatus, int size) {
        this.LotId = lotId;
        this.Floor = floor;
        this.AllowedVehicleType = allowedVehicleType;
        this.operationalStatus = operationalStatus;
        this.occupancyStatus = occupancyStatus;
        this.size = size;
    }
}
