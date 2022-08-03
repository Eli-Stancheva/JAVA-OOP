package OOP.EXERCISE_5_Polymorphism.P1_Vehicles;

public class Truck extends Vehicles{
    private static final double FUEL_CONSUMPTION_SUMMER = 1.6;
    private static final double THE_HOLE_PROBLEM = 0.95;


    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption += FUEL_CONSUMPTION_SUMMER;
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters * THE_HOLE_PROBLEM;
    }
}
