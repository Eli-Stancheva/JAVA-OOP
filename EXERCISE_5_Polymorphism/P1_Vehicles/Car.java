package OOP.EXERCISE_5_Polymorphism.P1_Vehicles;

public class Car extends Vehicles{
    private static final double FUEL_CONSUMPTION_SUMMER = 0.9;
    public Car(double fuelQuantity, double littersPerKmConsumption) {
        super(fuelQuantity, littersPerKmConsumption);
        this.fuelConsumption += FUEL_CONSUMPTION_SUMMER;
    }
}
