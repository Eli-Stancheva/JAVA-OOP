package OOP.LAB_4_InterfacesAndAbstraction.P3_SayHello;

public class Bulgarian extends BasePerson implements Person{
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
