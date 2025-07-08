package DTO;

import Model.Ticket;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Data;

@Data
public class TicketIssueResponseDTO {
    Ticket ticket;
    ResponseStatus responseStatus;
    String message;
}
