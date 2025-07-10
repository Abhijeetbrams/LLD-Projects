package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private Integer showId;
    private String showName;
    private Timestamp startTime;
    private Timestamp endTime;
    @ManyToOne
    private Screen screen;
    @OneToOne
    private Movie movie;



}
