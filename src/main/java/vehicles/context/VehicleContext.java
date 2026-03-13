package vehicles.context;

import vehicles.extrinsic.Position;
import vehicles.flyweight.VehicleType;

public class VehicleContext {
    private final String plate;
    private Position currentPosition;
    private float currentSpeed;
    private final VehicleType vehicleType;

    public VehicleContext(String plate, Position currentPosition, float currentSpeed, VehicleType vehicleType) {
        this.plate = plate;
        this.currentPosition = currentPosition;
        this.currentSpeed = currentSpeed;
        this.vehicleType = vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(float currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void showVehicle() {
        vehicleType.showVehicleData(this);
    }
}
