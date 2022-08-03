package OOP.LAB_1_WorkingWithAbstraction;

import java.util.Scanner;

public class P1_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            buildRhombus(n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            buildRhombus(n, i);
        }
    }

    private static void buildRhombus(int n, int i) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        for (int k = 0; k < i - 1; k++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
