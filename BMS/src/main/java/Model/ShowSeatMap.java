package Model;

import Enum.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeatMap extends BaseModel{
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Show show;
    private ShowSeatStatus showSeatStatus;
    private Date lockedAt;
}
