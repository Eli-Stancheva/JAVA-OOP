package OOP.EXERCISE_5_Polymorphism.P2_VehiclesExtension;

public class Truck extends Vehicles {
    private static final double FUEL_CONSUMPTION_SUMMER = 1.6;
    private static final double THE_HOLE_PROBLEM = 0.95;


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = this.getFuelConsumption() + FUEL_CONSUMPTION_SUMMER;
    }

    @Override
    public void refuel(double liters) {
        liters *= THE_HOLE_PROBLEM;
        super.refuel(liters);
    }
}
