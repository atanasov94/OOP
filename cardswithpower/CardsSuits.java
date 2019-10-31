package cardswithpower;

public enum CardsSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    CardsSuits(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
