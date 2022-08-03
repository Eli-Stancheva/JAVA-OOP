package OOP.LAB_7_ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class P1_NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numRange = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minNum = numRange[0];
        int maxNum = numRange[1];

        System.out.printf("Range: [%s...%s]\n", minNum, maxNum);
        while (true){
            String input = scanner.nextLine();
            try {
                int numFromInput = Integer.parseInt(input);
                if (numFromInput >= minNum && numFromInput <= maxNum){
                    System.out.printf("Valid number: %d\n", numFromInput);
                    return;
                } else {
                    System.out.printf("Invalid number: %d\n", numFromInput);
                }
            } catch (IllegalArgumentException exception){
                System.out.printf("Invalid number: %s\n", input);
            }
        }
    }
}
