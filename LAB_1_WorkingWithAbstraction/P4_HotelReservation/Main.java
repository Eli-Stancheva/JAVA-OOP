package OOP.LAB_1_WorkingWithAbstraction.P4_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(input[0]);
        int countDays = Integer.parseInt(input[1]);
        Seasons currSeason = Seasons.valueOf(input[2]);
        DiscountType discountType = DiscountType.valueOf(input[3]);

        double finalPrice = PriceCalculator.calculateFinalPrise(pricePerDay, countDays, currSeason, discountType);
        System.out.printf("%.2f", finalPrice);
    }
}
