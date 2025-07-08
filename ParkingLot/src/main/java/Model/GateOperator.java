package Model;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity(name="GateOperator")
public class GateOperator extends BaseModel {
    String Name;
    String EmpId;

    public GateOperator(String name, String empId) {
        Name = name;
        EmpId = empId;
    }
}
