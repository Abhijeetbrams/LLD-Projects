package Controller;

import DTO.TicketIssueRequestDTO;
import DTO.TicketIssueResponseDTO;
import Enum.VehicleType;
import Model.Ticket;
import Service.TicketService;
import org.springframework.web.bind.annotation.ResponseStatus;
import Enum.VehicleType;

public class TicketIssueController {
    TicketService ticketService;

    public TicketIssueController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketIssueResponseDTO issueTicket(TicketIssueRequestDTO ticketIssueRequestDTO) {
        String vehicleNumber = ticketIssueRequestDTO.getVehicleNumber();
        VehicleType vehicleType = ticketIssueRequestDTO.getVehicleType();
        String ownerName = ticketIssueRequestDTO.getOwnerName();
        String ownerPhoneNumber = ticketIssueRequestDTO.getOwnerPhoneNumber();
        Integer entryGateId = ticketIssueRequestDTO.getEntryGateId();
        String operatorId = ticketIssueRequestDTO.getOperatorId();
        Ticket ticket=null;
        TicketIssueResponseDTO response = new TicketIssueResponseDTO();
        try{
            ticket= ticketService.issueTicket(vehicleNumber, vehicleType, ownerName, ownerPhoneNumber, entryGateId, operatorId);
            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("Ticket issued successfully");
        }catch(Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage());
            return response;
        }
    }


}
