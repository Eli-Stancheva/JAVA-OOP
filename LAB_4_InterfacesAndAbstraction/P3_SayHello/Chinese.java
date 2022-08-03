package OOP.LAB_4_InterfacesAndAbstraction.P3_SayHello;

public class Chinese extends BasePerson implements Person{
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
