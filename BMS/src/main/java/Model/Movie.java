package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private Integer movieId;
    private String title;
    private String runtime;
    private String genre;
    private List<String> actors;
    private double rating;


}
