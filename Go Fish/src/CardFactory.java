public class CardFactory {
    public Card createCard(String suit, String name) {
        if (suit.equalsIgnoreCase("Spades")) {
            return new SpadeCard(name, suit);
        } else if (suit.equalsIgnoreCase("Hearts")) {
            return new HeartCard(name, suit);
        } else if (suit.equalsIgnoreCase("Diamonds")) {
            return new HeartCard(name, suit);
        } else if (suit.equalsIgnoreCase("Clubs")) {
            return new HeartCard(name, suit);
            
        } else {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
    }
}