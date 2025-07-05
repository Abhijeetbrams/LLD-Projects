package Model;

import Enum.GateType;
import Enum.OperationalStatus;

@lombok.Data
public class Gate {
    private GateType gateType;
    private int gateNo;
    private OperationalStatus operationalStatus;

    public Gate(GateType gateType, int gateNo, OperationalStatus operationalStatus) {
        this.gateType = gateType;
        this.gateNo = gateNo;
        this.operationalStatus = operationalStatus;
    }
}
