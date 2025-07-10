package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatTypeMap extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private double price;
}
