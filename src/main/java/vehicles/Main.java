package vehicles;

public class Main {
    private static final String[] BRANDS = {"Toyota", "Mazda", "Chevrolet", "Renault"};
    private static final String[] COLORS = {"White", "Black", "Red"};
    private static final String[] MODELS = {"Corolla", "CX-5", "Onix", "Duster"};

    public static void main(String[] args) {
        int totalVehicles = args.length > 0 ? Integer.parseInt(args[0]) : 4_000_000;
        Runtime runtime = Runtime.getRuntime();

        Fleet fleet = new Fleet();

        long start = System.currentTimeMillis();

        for (int i = 0; i < totalVehicles; i++) {
            String brand = BRANDS[i % BRANDS.length];
            String color = COLORS[i % COLORS.length];
            String model = MODELS[i % MODELS.length];
            String plate = String.format("CAR%07d", i);
            float x = (i % 1000) * 1.25f;
            float y = (i % 500) * 2.50f;
            float speed = (i % 140) + 10.0f;

            fleet.createVehicle(brand, color, model, plate, x, y, speed);
        }

        long end = System.currentTimeMillis();

        long totalMemoryMB = runtime.totalMemory() / (1024 * 1024);
        long freeMemoryMB = runtime.freeMemory() / (1024 * 1024);
        long maxMemoryMB = runtime.maxMemory() / (1024 * 1024);
        long usedMemoryMB = totalMemoryMB - freeMemoryMB;

        System.out.println("=== Flyweight Vehicles ===");
        System.out.println("Total vehicles: " + fleet.getTotalVehicles());
        System.out.println("Shared flyweights created: " + fleet.getTotalSharedTypes());
        System.out.println("Execution time (ms): " + (end - start));
        System.out.println("Memory Usage (MB):");
        System.out.println("Total: " + totalMemoryMB);
        System.out.println("Free: " + freeMemoryMB);
        System.out.println("Used: " + usedMemoryMB);
        System.out.println("Max: " + maxMemoryMB);

        fleet.showSample(5);
    }
}
