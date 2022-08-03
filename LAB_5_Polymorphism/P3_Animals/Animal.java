package OOP.LAB_5_Polymorphism.P3_Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    abstract String explainSelf();

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
}
