
import java.util.Random;
import java.util.ArrayList;

public class HardAIStrategy implements AIStrategy {

    @Override
    public String pickCard(ArrayList<String> selectedCards, ArrayList<Card> computerHand) {
        // Create two ArrayLists to hold the card names from the computerHand
        ArrayList<String> preferredCards = new ArrayList<String>();
        ArrayList<String> otherCards = new ArrayList<String>();
        
        Random random = new Random();
        String pickedCard = "";

        //problem somewhere in here causing program to fail
        if (computerHand.isEmpty()) {
            
            int randomIndex = random.nextInt(preferredCards.size());
            pickedCard = (preferredCards.get(randomIndex));
            return pickedCard ;
        }
        // Add the card names from the computerHand to the respective lists
        
        for (Card card : computerHand) {
            String cardName = card.getName();
            if (selectedCards.contains(cardName)) {
                preferredCards.add(cardName);
            } else {
                otherCards.add(cardName);
            }
        }

        // Choose a random index and pick a card from the preferredCards list, if not empty

        
        
        if (!preferredCards.isEmpty()) {
            int randomIndex = random.nextInt(preferredCards.size());
            pickedCard = (preferredCards.get(randomIndex));
        } else {
            int randomIndex = random.nextInt(otherCards.size());
            pickedCard = (otherCards.get(randomIndex));
        }

        return pickedCard;
    }
}