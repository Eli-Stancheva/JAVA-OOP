package OOP.EXERCISE_5_Polymorphism.P2_VehiclesExtension;

public class Car extends Vehicles {
    private static final double FUEL_CONSUMPTION_SUMMER = 0.9;

    public Car(double fuelQuantity, double littersPerKmConsumption, double tankCapacity) {
        super(fuelQuantity, littersPerKmConsumption, tankCapacity);
        this.fuelConsumption += FUEL_CONSUMPTION_SUMMER;
    }
}
