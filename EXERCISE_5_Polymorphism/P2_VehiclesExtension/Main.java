package OOP.EXERCISE_5_Polymorphism.P2_VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicleInfo = scanner.nextLine().split(" ");
        Vehicles car = createVehicle(vehicleInfo);

        vehicleInfo = scanner.nextLine().split(" ");
        Vehicles truck = createVehicle(vehicleInfo);

        vehicleInfo = scanner.nextLine().split(" ");
        Vehicles bus = createVehicle(vehicleInfo);

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();
        vehiclesMap.put("Car", car);
        vehiclesMap.put("Truck", truck);
        vehiclesMap.put("Bus", bus);


        int commandsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsNumber; i++) {
            vehicleInfo = scanner.nextLine().split(" ");
            String command = vehicleInfo[0];
            String typeVehicle = vehicleInfo[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(vehicleInfo[2]);
                    Vehicles vehicle = vehiclesMap.get(typeVehicle);

                    if (vehicle instanceof Bus) {
                        bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                        System.out.println(bus.drive(distance));
                        bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                        continue;
                    }

                    String driveMessage = vehicle.drive(distance);
                    System.out.println(driveMessage);
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(vehicleInfo[2]);
                    vehiclesMap.get(typeVehicle).refuel(fuelAmount);
                    break;
                case "DriveEmpty":
                    double driveEmptyDistance = Double.parseDouble(vehicleInfo[2]);
                    String driveEmptyMessage = bus.drive(driveEmptyDistance);
                    System.out.println(driveEmptyMessage);
                    break;
            }
        }
        vehiclesMap.values().forEach(System.out::println);
    }

    private static Vehicles createVehicle(String[] vehicleInfo) {
        String vehicleType = vehicleInfo[0];
        double quantity = Double.parseDouble(vehicleInfo[1]);
        double consumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);

        Vehicles vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(quantity, consumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(quantity, consumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(quantity, consumption, tankCapacity);
                break;
        }
        return vehicle;
    }
}
