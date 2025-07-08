package Service;

import Enum.GateType;
import Enum.OperationalStatus;
import Model.*;
import Enum.VehicleType;
import Enum.*;

public class TicketService {

    public Ticket ticketIssue(String vehicleNumber, VehicleType vehicleType, String ownerName, String ownerPhoneNumber, Integer entryGateId, String operatorId) {
        // Fetching Vehicle from Repository if exists, else creating a new one.
        Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, 4, ownerName, ownerPhoneNumber);
        Gate entryGate = new Gate(GateType.ENTRY, entryGateId, OperationalStatus.OPERATIONAL);
        GateOperator gateOperator = new GateOperator("Random  Name",operatorId);
        // This should be fetched from the Strategy Pattern.
        Floor floor2 = new Floor(2);
        Lot lot =new Lot(1, floor2, VehicleType.CAR,OccupancyStatus.VACANT, OperationalStatus.OPERATIONAL,250);
        Ticket ticket=Ticket.getBuilder().
                setVehicle(vehicle).
                setFloor(floor2).
                setGate(entryGate).
                setGateOperator(gateOperator).
                setLot(lot).build();

        return ticket;
    }
}
