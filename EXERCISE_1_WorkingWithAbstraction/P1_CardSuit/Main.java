package OOP.EXERCISE_1_WorkingWithAbstraction.P1_CardSuit;

import OOP.EXERCISE_1_WorkingWithAbstraction.P3_CardsWithPower.CardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuit[] cardSuit = CardSuit.values();
        System.out.println("Card Suits: ");
        for (CardSuit suit : cardSuit) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", suit.ordinal(), suit);
        }
    }
}
