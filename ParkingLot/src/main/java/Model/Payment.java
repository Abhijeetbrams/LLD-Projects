package Model;

import java.sql.Timestamp;
import Enum.PaymentType;
import Enum.PaymentStatus;

@lombok.Data
public class Payment {
    private PaymentType paymentType;
    private double amount;
    private String transactionId;
    private PaymentStatus paymentStatus;
    private Timestamp paymentDate;
}
