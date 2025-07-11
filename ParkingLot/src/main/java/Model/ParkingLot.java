package Model;

import java.util.*;

@lombok.Data
public class ParkingLot {
    String parkingLotName;
    String parkingLotAddress;
    List<Vehicle> vehicles;
    List<Gate> gates;
    List<Ticket> tickets;
    List<Floor> floor;

    public ParkingLot(String parkingLotName, String parkingLotAddress) {
        this.parkingLotName = parkingLotName;
        this.parkingLotAddress = parkingLotAddress;
        this.vehicles = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.floor = new ArrayList<>();
    }
}
