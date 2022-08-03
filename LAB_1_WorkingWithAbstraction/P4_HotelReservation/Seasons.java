package OOP.LAB_1_WorkingWithAbstraction.P4_HotelReservation;

public enum Seasons {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int multiplier;

    Seasons(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
