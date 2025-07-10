package Model;

import java.util.List;
import Enum.FormatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private Integer screenId;

    @Enumerated(EnumType.ORDINAL)
    private FormatType formatType;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;


}
