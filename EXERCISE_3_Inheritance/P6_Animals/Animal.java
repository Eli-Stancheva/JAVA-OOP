package OOP.EXERCISE_3_Inheritance.P6_Animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    protected abstract String produceSound();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        builder.append("\r");
        builder.append("\n");

        builder.append(name);
        builder.append(" ");
        builder.append(age);
        builder.append(" ");
        builder.append(gender);
        builder.append("\r");
        builder.append("\n");

        builder.append(this.produceSound());
        return builder.toString();
    }
}
