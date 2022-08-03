package OOP.LAB_7_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P2_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            if (number >= 0){
                System.out.printf("%.2f\n", Math.sqrt(number));
            } else {
                System.out.println("Invalid");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
