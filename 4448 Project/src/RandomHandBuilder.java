import java.util.ArrayList;
import java.util.Collections;

public class RandomHandBuilder implements HandBuilder {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public ArrayList<Card> getCards() {
        // Shuffle the cards
        Collections.shuffle(cards);
        
        // Take the first 5 cards as the hand
        return new ArrayList<Card>(cards.subList(0, 5));
    }
}