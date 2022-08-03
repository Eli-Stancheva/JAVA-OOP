package OOP.EXERCISE_1_WorkingWithAbstraction.P6_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long entrance = Long.parseLong(scanner.nextLine());
        String[] itemsAndQuantity = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gem = 0;
        long money = 0;

        for (int i = 0; i < itemsAndQuantity.length; i += 2) {
            String name = itemsAndQuantity[i];
            long amount = Long.parseLong(itemsAndQuantity[i + 1]);

            String itemsLetters = "";
            if (name.length() == 3) {
                itemsLetters = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                itemsLetters = "Gem";
            } else if (name.equalsIgnoreCase("gold")) {
                itemsLetters = "Gold";
            }

            if (itemsLetters.equals("")) {
                continue;
            } else if (entrance < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount) {
                continue;
            }

            switch (itemsLetters) {
                case "Gem":
                    if (!bag.containsKey(itemsLetters)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemsLetters).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemsLetters)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemsLetters).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemsLetters)) {
                bag.put((itemsLetters), new LinkedHashMap<>());
            }

            if (!bag.get(itemsLetters).containsKey(name)) {
                bag.get(itemsLetters).put(name, 0L);
            }

            bag.get(itemsLetters).put(name, bag.get(itemsLetters).get(name) + amount);
            if (itemsLetters.equals("Gold")) {
                gold += amount;
            } else if (itemsLetters.equals("Gem")) {
                gem += amount;
            } else if (itemsLetters.equals("Cash")) {
                money += amount;
            }
        }

        for (Map.Entry<String, Map<String, Long>> entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.printf("<%s> $%s\n", entry.getKey(), sumValues);
            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.printf("##%s - %s\n", i.getKey(), i.getValue()));
        }
    }
}
