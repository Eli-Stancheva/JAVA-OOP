package OOP.EXERCISE_5_Polymorphism.P1_Vehicles;

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

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();
        vehiclesMap.put("Car", car);
        vehiclesMap.put("Truck", truck);


        int commandsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsNumber; i++) {
            vehicleInfo = scanner.nextLine().split(" ");
            String command = vehicleInfo[0];
            String typeVehicle = vehicleInfo[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(vehicleInfo[2]);
                    String driveMassage = vehiclesMap.get(typeVehicle).drive(distance);
                    System.out.println(driveMassage);
                    break;
                case "Refuel":
                    double litters = Double.parseDouble(vehicleInfo[2]);
                    vehiclesMap.get(typeVehicle).refuel(litters);
                    break;
            }
        }
        vehiclesMap.values().forEach(System.out::println);
    }

    private static Vehicles createVehicle(String[] vehicleInfo) {
        String vehicleType = vehicleInfo[0];
        double quantity = Double.parseDouble(vehicleInfo[1]);
        double consumption = Double.parseDouble(vehicleInfo[2]);

        Vehicles vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(quantity, consumption);
                break;
            case "Truck":
                vehicle = new Truck(quantity, consumption);
                break;
        }
        return vehicle;
    }
}
