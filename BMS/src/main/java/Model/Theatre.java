package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private Integer theatreId;
    private String theatreName;
    private String theatreAddress;
    @OneToMany
    private List<Screen> screens;


}

