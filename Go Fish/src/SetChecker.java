import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SetChecker {

    public SetChecker() {
        // Constructor
    }

    public void checkCards(ArrayList<Card> cards, AtomicInteger counter) {
        Map<String, Integer> nameCounts = new HashMap<>();

        // Count the occurrences of each card name
        for (Card card : cards) {
            nameCounts.put(card.getName(), nameCounts.getOrDefault(card.getName(), 0) + 1);
        }

        // Iterate through the nameCounts map
        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            if (entry.getValue() == 4) {
                counter.incrementAndGet(); // Increment the counter
                System.out.println("Made a set of: " + entry.getKey()); // Print the message
                
                // Remove the four of a kind cards from the ArrayList
                Iterator<Card> iterator = cards.iterator();
                while (iterator.hasNext()) {
                    Card card = iterator.next();
                    if (card.getName().equals(entry.getKey())) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}