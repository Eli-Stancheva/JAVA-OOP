package OOP.EXERCISE_1_WorkingWithAbstraction.P5_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensional = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensional[0];
        int cols = dimensional[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(rows, cols, matrix);


        long sum = 0;
        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] peterPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int evilRow = evil[0];
            int evilCol = evil[1];
            moveEvil(matrix, evilRow, evilCol);

            int peterRow = peterPosition[0];
            int peterCol = peterPosition[1];
            sum = movePeter(matrix, sum, peterRow, peterCol);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long movePeter(int[][] matrix, long sum, int peterRow, int peterCol) {
        while (peterRow >= 0 && peterCol < matrix[1].length) {
            if (peterRow < matrix.length && peterCol >= 0 && peterCol < matrix[0].length) {
                sum += matrix[peterRow][peterCol];
            }
            peterCol++;
            peterRow--;
        }
        return sum;
    }

    private static void moveEvil(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        int value = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = value++;
            }
        }
    }
}
