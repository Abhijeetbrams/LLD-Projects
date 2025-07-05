package Model;

import Enum.VehicleType;

@lombok.Data
public class Vehicle {
    public String vehicleNumber;
    public VehicleType vehicleType;
    public int vehicleSize;
    public String ownerName;
    public String ownerPhoneNumber;

    public void Vehicle(String vehicleNumber, VehicleType vehicleType, int vehicleSize, String ownerName, String ownerPhoneNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleSize = vehicleSize;
        this.ownerName = ownerName;
        this.ownerPhoneNumber = ownerPhoneNumber;
    }
}
