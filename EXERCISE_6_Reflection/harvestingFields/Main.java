package OOP.EXERCISE_6_Reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Field>> fieldsMap = getModifier();

        Consumer<Field> printerField = field -> {
            System.out.println(Modifier.toString(field.getModifiers())
                    + " "
                    + field.getType().getSimpleName()
                    + " "
                    + field.getName());
        };

        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {
            switch (input) {
                case "private":
                    fieldsMap.get("private").forEach(printerField);
                    break;
                case "protected":
                    fieldsMap.get("protected").forEach(printerField);
                    break;
                case "public":
                    fieldsMap.get("public").forEach(printerField);
                    break;
                case "all":
                    fieldsMap.get("all").forEach(printerField);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static Map<String, List<Field>> getModifier() {
        Map<String, List<Field>> map = new HashMap<>();
        map.put("private", new ArrayList<>());
        map.put("protected", new ArrayList<>());
        map.put("public", new ArrayList<>());

        List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
        map.put("all", allFields);

        allFields.forEach(field -> {
            String modifier = Modifier.toString(field.getModifiers());

            switch (modifier) {
                case "private":
                    map.get("private").add(field);
                    break;
                case "protected":
                    map.get("protected").add(field);
                    break;
                case "public":
                    map.get("public").add(field);
                    break;
            }
        });
        return map;
    }
}
