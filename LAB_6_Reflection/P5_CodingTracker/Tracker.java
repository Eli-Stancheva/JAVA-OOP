package OOP.LAB_6_Reflection.P5_CodingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    public static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null){
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }
        for(Map.Entry<String, List<String>> map : methodsByAuthor.entrySet()){
            System.out.println(map.getValue());
        }
    }
}
