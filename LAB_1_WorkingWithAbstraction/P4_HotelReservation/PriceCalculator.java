package OOP.LAB_1_WorkingWithAbstraction.P4_HotelReservation;

public class PriceCalculator {
    public static double calculateFinalPrise(double pricePerDay, int numberDays, Seasons season, DiscountType discountType) {
        double price = pricePerDay * numberDays;
        price = price * season.getMultiplier();
        price = price * (100 - discountType.getDiscount()) / 100.0;
        return price;
    }
}
