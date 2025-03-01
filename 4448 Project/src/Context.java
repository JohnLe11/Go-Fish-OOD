import java.util.ArrayList;
public class Context {
    private AIStrategy strategy;
 
    public Context(AIStrategy strategy){
       this.strategy = strategy;
    }
 
    public String pickCard(ArrayList<String> selectedCard, ArrayList<Card> computerHand){
       return strategy.pickCard( selectedCard, computerHand );
    }
 }