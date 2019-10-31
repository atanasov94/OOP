package cardsuits;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (int i = 0; i < CardSuits.values().length; i++) {
            System.out.print(String.format("Ordinal value: %d; ",i));
            System.out.println(String.format("Name value: %s", CardSuits.values()[i]));
        }
    }
}
