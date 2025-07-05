package Model;

import java.sql.Timestamp;
import Enum.OperationalStatus;
import Exception.GateNotOperationalException;
import Exception.GateOperatorNotFoundException;
import Exception.VehicleNotFoundException;
import Exception.FloorNotOperationalException;
import Model.Lot;
import Exception.LotNotAvailableException;
import Enum.OccupancyStatus;

public class Ticket {
    private int ticketId;
    private Vehicle vehicle;
    private Timestamp entryTime;
    private Gate gate;
    private Floor floor;
    private GateOperator gateOperator;
    private Lot lot;


    private Ticket(Vehicle vehicle, Gate gate, GateOperator gateOperator, Lot lot, Floor floor) {
        this.vehicle = vehicle;
        this.gate = gate;
        this.gateOperator = gateOperator;
        this.lot = lot;
        this.floor = floor;
        this.entryTime = new Timestamp(System.currentTimeMillis());
    }
    public Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Vehicle vehicle;
        private Gate gate;
        private GateOperator gateOperator;
        private Lot lot;
        private Floor floor;

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }
        public Builder setGate(Gate gate) {
            this.gate = gate;
            return this;
        }
        public Builder setGateOperator(GateOperator gateOperator) {
            this.gateOperator = gateOperator;
            return this;
        }
        public Builder setLot(Lot lot) {
            this.lot = lot;
            return this;
        }
        public Builder setFloor(Floor floor) {
            this.floor = floor;
            return this;
        }
        public Ticket build() {
            if(vehicle== null){
                throw new VehicleNotFoundException("Vehicle not found");
            }
            if(gate.getOperationalStatus() != OperationalStatus.OPERATIONAL){
                throw new GateNotOperationalException("Gate is not operational");
            }
            if(gateOperator == null){
                throw new GateOperatorNotFoundException("Gate operator not found");
            }
            if(lot == null || lot.getOperationalStatus()!=OperationalStatus.OPERATIONAL || lot.getOccupancyStatus()== OccupancyStatus.OCCUPIED){
                throw new LotNotAvailableException("Lot is not available");
            }
            if(floor ==null || floor.getOperationalStatus() != OperationalStatus.OPERATIONAL){
                throw new FloorNotOperationalException("Floor is not operational");
            }

            return new Ticket(vehicle, gate, gateOperator, lot, floor);
        }
    }

}
