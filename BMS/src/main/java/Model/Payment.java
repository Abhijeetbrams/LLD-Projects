package Model;

import Enum.PaymentMethod;
import Enum.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String transactionID;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    private double amountPaid;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
