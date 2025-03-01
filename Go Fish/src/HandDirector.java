import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandDirector {
    public ArrayList<Card> buildHand(HandBuilder builder, List<Card> deck) {
        for (Card card : deck) {
            builder.addCard(card);
        }
        
        return builder.getCards();
    }
}