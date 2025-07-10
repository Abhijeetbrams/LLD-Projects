package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class City extends BaseModel {
    private int cityId;
    private String cityName;
    @OneToMany
    private List<Theatre> theatres;

}
