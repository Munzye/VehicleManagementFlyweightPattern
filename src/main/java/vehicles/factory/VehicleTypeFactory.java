package vehicles.factory;

import java.util.HashMap;
import java.util.Map;

import vehicles.flyweight.VehicleType;

public class VehicleTypeFactory {
    private static final Map<String, VehicleType> VEHICLE_TYPES = new HashMap<>();

    private VehicleTypeFactory() {
    }

    public static VehicleType getVehicleType(String brand, String color, String model) {
        String key = buildKey(brand, color, model);
        return VEHICLE_TYPES.computeIfAbsent(key, k -> new VehicleType(brand, color, model));
    }

    public static int getTotalFlyweights() {
        return VEHICLE_TYPES.size();
    }

    private static String buildKey(String brand, String color, String model) {
        return brand + "|" + color + "|" + model;
    }
}
