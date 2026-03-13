package vehicles;

import java.util.ArrayList;
import java.util.List;

import vehicles.context.VehicleContext;
import vehicles.extrinsic.Position;
import vehicles.factory.VehicleTypeFactory;

public class Fleet {
    private final List<VehicleContext> vehicles;

    public Fleet() {
        this.vehicles = new ArrayList<>();
    }

    public void createVehicle(String brand, String color, String model,
                              String plate, float x, float y, float currentSpeed) {
        VehicleContext vehicle = new VehicleContext(
            plate,
            new Position(x, y),
            currentSpeed,
            VehicleTypeFactory.getVehicleType(brand, color, model)
        );
        vehicles.add(vehicle);
    }

    public int getTotalVehicles() {
        return vehicles.size();
    }

    public int getTotalSharedTypes() {
        return VehicleTypeFactory.getTotalFlyweights();
    }

    public void showSample(int limit) {
        int max = Math.min(limit, vehicles.size());
        for (int i = 0; i < max; i++) {
            vehicles.get(i).showVehicle();
        }
    }
}
