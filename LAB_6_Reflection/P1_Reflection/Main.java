package OOP.LAB_6_Reflection.P1_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //This class type
        Class reflectionClass = Reflection.class;
        System.out.println("class " + reflectionClass.getSimpleName());

        //Super class type
        Class superClass = reflectionClass.getSuperclass();
        System.out.println(superClass);

        //All interfaces that are implemented by this class
        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        //Instantiate object using reflection and print it too
        Object objectReflection = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(objectReflection);
    }
}
