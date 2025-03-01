import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


public class EasyAIStrategy implements AIStrategy {

    @Override
    public String pickCard(ArrayList<String> selectedCards, ArrayList<Card> computerHand) {
        // Define an array of card names
        String[] cardNames = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        
        // Create an ArrayList to hold the available card names
        ArrayList<String> availableCards = new ArrayList<String>(Arrays.asList(cardNames));
        
        
        // Choose a random index within the size of the availableCards list
        Random random = new Random();
        int randomIndex = random.nextInt(availableCards.size());
        
        // Return the card name at the random index
        String pickedCard = "";
        pickedCard = (availableCards.get(randomIndex));
        return pickedCard;
    }
}