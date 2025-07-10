package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private Integer seatId;
    private String seatNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
    private int column;
    private int row;


}
