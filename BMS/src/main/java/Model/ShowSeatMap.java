package Model;

import Enum.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatMap extends BaseModel{
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Show show;
    private Status status;
}
