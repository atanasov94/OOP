package cardrank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (int i = 0; i < CardRanks.values().length; i++) {
            System.out.print(String.format("Ordinal value: %d; ", i));
            System.out.println(String.format("Name value: %s", CardRanks.values()[i]));
        }
    }
}
