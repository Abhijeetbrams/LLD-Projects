package Model;

import java.util.List;
import Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    private int bookingID;
    @ManyToOne
    private User user;

    @OneToMany
    private List<ShowSeatMap> showSeatMaps;
    private double amountToBePaid;

    @Enumerated(EnumType.ORDINAL) // Using ORDINAL to store the enum as an integer
    private BookingStatus bookingStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private List<Payment> payments;

}
