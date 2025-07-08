package DTO;
import Enum.VehicleType;
import lombok.Data;

@Data
public class TicketIssueRequestDTO {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String ownerName;
    private String ownerPhoneNumber;
    private Integer entryGateId;
    private String operatorId;


}
