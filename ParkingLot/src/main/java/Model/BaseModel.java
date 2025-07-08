package Model;

import jakarta.persistence.*;

@MappedSuperclass// This annotation indicates that this class is a base class for JPA entities
// and should not be instantiated on its own.
// It allows the fields to be inherited by subclasses.
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
