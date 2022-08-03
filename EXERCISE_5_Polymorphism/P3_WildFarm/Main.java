package OOP.EXERCISE_5_Polymorphism.P3_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String animalInput = scan.nextLine();
        while (!animalInput.equals("End")) {
            String[] animalInfo = animalInput.split("\\s+");
            Animal animal = createAnimal(animalInfo);

            String foodInfo = scan.nextLine();
            Food food = getFood(foodInfo.split("\\s+"));

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            animals.add(animal);
            animalInput = scan.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodInfo) {
        String foodType = foodInfo[0];
        Integer quantity = Integer.parseInt(foodInfo[1]);

        if (foodType.equals("Meat")) {
            return new Meat(quantity);
        } else {
            return new Vegetable(quantity);
        }
    }

    private static Animal createAnimal(String[] animalInfo) {
        String animalType = animalInfo[0];
        String animalName = animalInfo[1];
        Double animalWeight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];

        switch (animalType){
            case "Mouse":
                return new Mouse(animalName,animalType,animalWeight,livingRegion);
            case "Cat":
                return new Cat(animalName,animalType,animalWeight,livingRegion,animalInfo[4]);
            case "Zebra":
                return new Zebra(animalName,animalType,animalWeight,livingRegion);
            case "Tiger":
                return new Tiger(animalName,animalType,animalWeight,livingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}


