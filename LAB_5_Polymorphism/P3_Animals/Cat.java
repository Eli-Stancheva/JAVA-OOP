package OOP.LAB_5_Polymorphism.P3_Animals;

public class Cat extends Animal{
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("I am %s and my favourite food is %s\nMEEOW", super.getName(), super.getFavouriteFood());
    }
}
