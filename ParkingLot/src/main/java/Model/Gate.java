package Model;

import Enum.GateType;
import Enum.OperationalStatus;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name="gate")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gate extends BaseModel{
    private GateType gateType;
    private int gateNo;
    private OperationalStatus operationalStatus;

    public Gate(GateType gateType, int gateNo, OperationalStatus operationalStatus) {
        this.gateType = gateType;
        this.gateNo = gateNo;
        this.operationalStatus = operationalStatus;
    }
}
