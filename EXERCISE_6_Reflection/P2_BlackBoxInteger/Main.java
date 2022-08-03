package OOP.EXERCISE_6_Reflection.P2_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt box = constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());


        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "add":
                    executeCommand(box, innerValue, number, "add", methods);
                    break;
                case "subtract":
                    executeCommand(box, innerValue, number, "subtract", methods);
                    break;
                case "multiply":
                    executeCommand(box, innerValue, number, "multiply", methods);
                    break;
                case "divide":
                    executeCommand(box, innerValue, number, "divide", methods);
                    break;
                case "leftShift":
                    executeCommand(box, innerValue, number, "leftShift", methods);
                    break;
                case "rightShift":
                    executeCommand(box, innerValue, number, "rightShift", methods);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void executeCommand(BlackBoxInt box, Field innerValue, int number, String command, List<Method> methods) throws InvocationTargetException, IllegalAccessException {
        Method currentMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(command)) {
                currentMethod = method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(box, number);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(box));
    }
}
