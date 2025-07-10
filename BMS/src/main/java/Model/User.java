package Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String username;
    private String name;
    private String email;
    private String phoneNumber;

    public User() {
        // Default constructor for JPA
    }

    public User(String username, String name, String email, String phoneNumber) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
