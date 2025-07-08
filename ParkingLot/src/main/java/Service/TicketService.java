package Service;

import Enum.GateType;
import Enum.OperationalStatus;
import Model.*;
import Enum.VehicleType;
import Enum.*;
import Repository.GateOperatorRepository;
import Repository.GateRepository;
import Repository.VehicleRepository;
import Exception.GateNotOperationalException;
import Exception.GateOperatorNotFoundException;

import java.util.Optional;

public class TicketService {
      VehicleRepository vehicleRepository;
      GateRepository gateRepository;
      GateOperatorRepository gateOperatorRepository;

      Vehicle vehicle;
      Gate entryGate;

    public TicketService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public Ticket ticketIssue(String vehicleNumber, VehicleType vehicleType, String ownerName, String ownerPhoneNumber, Integer entryGateId, String operatorId) {
        // Fetching Vehicle from Repository if exists, else creating a new one.
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            if (!vehicle.getVehicleType().equals(vehicleType)) {
                throw new IllegalArgumentException("Vehicle type mismatch for vehicle number: " + vehicleNumber);
            }
        } else {
            // If the vehicle does not exist, create a new one.
            Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, 4, ownerName, ownerPhoneNumber);
            vehicleRepository.save(vehicle);
        }

        // Fetching the entry gate
        Optional<Gate> entryGateOptional = gateRepository.findById(entryGateId);
        if(entryGateOptional.isPresent()) {
            entryGate = entryGateOptional.get();
            if(!entryGate.getOperationalStatus().equals(OperationalStatus.OPERATIONAL)) {
                throw new GateNotOperationalException("Entry gate with ID " + entryGateId + " is not operational.");
            }
            if(!entryGate.getGateType().equals(GateType.ENTRY)){
                throw new IllegalArgumentException("Gate with ID " + entryGateId + " is not an entry gate.");
            }
        }else{
            throw new IllegalArgumentException("Entry gate with ID " + entryGateId + " is not operational or does not exist.");
        }

        // Getting the gate operator
        Optional<GateOperator> gateOperatorOptional = gateOperatorRepository.findByEmpId(operatorId);
        GateOperator gateOperator =null;
        if(gateOperatorOptional.isPresent()) {
            gateOperator = gateOperatorOptional.get();
        }else{
            throw new GateOperatorNotFoundException("Gate operator with ID " + operatorId + " not found.");
        }


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
