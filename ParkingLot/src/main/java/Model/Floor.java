package Model;

import java.util.*;
import Enum.OperationalStatus;

import Enum.OperationalStatus;
@lombok.Data
public class Floor {
    private int floorNo;
    private List<Lot> parkingLots;
    private OperationalStatus operationalStatus;

    public Floor(int floorNo, List<Lot> parkingLots, OperationalStatus operationalStatus) {
        this.floorNo = floorNo;
        this.parkingLots = parkingLots;
        this.operationalStatus = operationalStatus;
    }
}
