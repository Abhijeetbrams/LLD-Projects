package Model;

import Enum.VehicleType;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// JPA requires this, since it uses reflection to instantiate the class and it forces
// to create a no-arg constructor,
// thus to meet JPA's requirement without exposing the constructor unnecessarily.
@Entity(name="Vehicle")
public class Vehicle extends BaseModel{
    public String vehicleNumber;
    public VehicleType vehicleType;
    public int vehicleSize;
    public String ownerName;
    public String ownerPhoneNumber;


    public Vehicle(String vehicleNumber, VehicleType vehicleType, int vehicleSize, String ownerName, String ownerPhoneNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleSize = vehicleSize;
        this.ownerName = ownerName;
        this.ownerPhoneNumber = ownerPhoneNumber;
    }
}
