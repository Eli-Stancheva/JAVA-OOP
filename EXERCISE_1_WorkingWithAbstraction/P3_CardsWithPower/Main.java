package OOP.EXERCISE_1_WorkingWithAbstraction.P3_CardsWithPower;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        CardRank cardRank = CardRank.valueOf(rank);
        CardSuit cardSuit = CardSuit.valueOf(suit);
        int sum = cardRank.getRank() + cardSuit.getRankSuit();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank.name(), cardSuit.name(), sum);
    }
}
