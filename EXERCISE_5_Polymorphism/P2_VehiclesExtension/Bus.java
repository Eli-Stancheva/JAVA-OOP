package OOP.EXERCISE_5_Polymorphism.P2_VehiclesExtension;

public class Bus extends Vehicles {
    private static final double FUEL_CONSUMPTION_SUMMER = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }
}
