package OOP.EXERCISE_5_Polymorphism.P2_VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicles {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    public Vehicles(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        double neededFuel = distance * fuelConsumption;

        if (fuelQuantity < neededFuel){
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        } else {
           this.fuelQuantity -= neededFuel;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
        }
    }

    public void refuel(double liters) {
        if (liters <= 0){
            System.out.println("Fuel must be a positive number");
            return;
        }

        if (liters > this.tankCapacity - this.fuelQuantity){
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        this.fuelQuantity += liters;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(int fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
