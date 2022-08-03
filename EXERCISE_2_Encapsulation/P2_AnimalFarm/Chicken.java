package OOP.EXERCISE_2_Encapsulation.P2_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() >= 1) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    private double calculateProductPerDay() {
        double producedEgs = 0;
        if (age >= 0 && age <= 5) {
            producedEgs = 2;
        } else if (age >= 6 && age <= 11) {
            producedEgs = 1;
        } else {
            producedEgs = 0.75;
        }
        return producedEgs;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken Chichi (age %d) can produce %.2f eggs per day.", age, productPerDay());
    }
}
