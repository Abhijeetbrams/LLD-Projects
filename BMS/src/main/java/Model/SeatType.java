package Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatType extends BaseModel {
    private Integer seatTypeId;
    private String seatTypeName;

}
