import java.util.List;
import java.util.Set;

public class GameState {
    private Player player;
    private List<Card> aiHand;
    private Set<Card> playedCards;

    public GameState(Player player, List<Card> aiHand, Set<Card> playedCards) {
        this.player = player;
        this.aiHand = aiHand;
        this.playedCards = playedCards;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Card> getAIHand() {
        return aiHand;
    }

    public Set<Card> getPlayedCards() {
        return playedCards;
    }
}
