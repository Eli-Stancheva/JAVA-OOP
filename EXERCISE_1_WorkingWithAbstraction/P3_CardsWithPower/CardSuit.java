package OOP.EXERCISE_1_WorkingWithAbstraction.P3_CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int rankSuit;

    CardSuit(int rankSuit) {
        this.rankSuit = rankSuit;
    }

    public int getRankSuit() {
        return rankSuit;
    }
}
