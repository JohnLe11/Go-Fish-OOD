import java.util.Random;
import java.util.ArrayList;

public class MediumAIStrategy implements AIStrategy {

    @Override
    public String pickCard(ArrayList<String> selectedCards, ArrayList<Card> computerHand) {
        // Create an ArrayList to hold the card names from the computerHand
        ArrayList<String> availableCards = new ArrayList<String>();
        
        // Add the card names from the computerHand to the availableCards list
        for (Card card : computerHand) {
            String cardName = card.getName();
            availableCards.add(cardName);
        }

        // Choose a random index within the size of the availableCards list
        Random random = new Random();
        int randomIndex = random.nextInt(availableCards.size());
        
        // Return the card name at the random index
        String pickedCard = "";
        pickedCard = (availableCards.get(randomIndex));
        return pickedCard;
    }
}