public class SpadeCard implements Card {
    private String name;
    private int value;
    private String suit;

    public SpadeCard(String name,String suit) {
        this.name = name;
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    public String getSuit() {
        return suit;
    }
    public String getColor() {
        return "black";
    }
}