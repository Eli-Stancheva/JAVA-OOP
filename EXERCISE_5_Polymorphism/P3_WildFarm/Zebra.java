package OOP.EXERCISE_5_Polymorphism.P3_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight,livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.eat(food);
        }else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
