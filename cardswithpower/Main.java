package cardswithpower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();
        int totalPower = CardsRanks.valueOf(cardRank).getPower()
                + CardsSuits.valueOf(cardSuit).getPower();

        System.out.println(String.format(
                "Card name: %s of %s; Card power: %d",
                cardRank, cardSuit, totalPower
        ));
    }
}
