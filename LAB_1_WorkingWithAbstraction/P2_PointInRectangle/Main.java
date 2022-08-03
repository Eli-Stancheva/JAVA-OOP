package OOP.LAB_1_WorkingWithAbstraction.P2_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        Point pointBottomLeft = new Point(bottomLeftX, bottomLeftY);

        int topRightX = coordinates[2];
        int topRightY = coordinates[3];
        Point pointTopRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(pointBottomLeft, pointTopRight);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] points = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = points[0];
            int y = points[1];

            Point currPoint = new Point(x, y);
            System.out.println(rectangle.contains(currPoint));
        }
    }
}
