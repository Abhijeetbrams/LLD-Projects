package Model;

import java.sql.Timestamp;
import java.util.List;
import Enum.BillStatus;

@lombok.Data
public class Invoice {
    private Ticket ticket;
    private List<Payment> payments;
    private Timestamp exitTime;
    private double totalAmount;
    private BillStatus billStatus;
    private Gate gate;
    private GateOperator gateOperator;

}
