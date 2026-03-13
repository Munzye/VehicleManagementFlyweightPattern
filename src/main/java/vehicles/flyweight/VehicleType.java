package vehicles.flyweight;

import vehicles.context.VehicleContext;

public class VehicleType {
    private final String brand;
    private final String color;
    private final String model;

    public VehicleType(String brand, String color, String model) {
        this.brand = brand;
        this.color = color;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void showVehicleData(VehicleContext context) {
        System.out.println(
            "Vehicle -> brand=" + brand +
            ", model=" + model +
            ", color=" + color +
            ", plate=" + context.getPlate() +
            ", position=" + context.getCurrentPosition() +
            ", speed=" + context.getCurrentSpeed()
        );
    }
}
