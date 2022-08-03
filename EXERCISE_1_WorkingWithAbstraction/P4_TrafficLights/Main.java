package OOP.EXERCISE_1_WorkingWithAbstraction.P4_TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] trafficLights = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        List<Lights> lights = new ArrayList<>();
        for (String tl : trafficLights) {
            Lights newLight = new Lights(Color.valueOf(tl));
            lights.add(newLight);
        }

        for (int i = 0; i < n; i++) {
            lights.forEach(l -> {
                l.changeColor();
                System.out.print(l.getColor() + " ");
            });
            System.out.println();
        }
    }
}
