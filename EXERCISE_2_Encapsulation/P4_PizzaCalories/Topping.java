package OOP.EXERCISE_2_Encapsulation.P4_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                String message = String.format("Cannot place %s on top of your pizza.", toppingType);
                throw new IllegalArgumentException(message);
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String massage = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(massage);
        }
    }

    public double calculateCalories() {
        double caloriesTopping = 0;
        switch (this.toppingType) {
            case "Meat":
                caloriesTopping = 1.2;
                break;
            case "Veggies":
                caloriesTopping = 0.8;
                break;
            case "Cheese":
                caloriesTopping = 1.1;
                break;
            case "Sauce":
                caloriesTopping = 0.9;
                break;
        }
        return 2 * weight * caloriesTopping;
    }
}
