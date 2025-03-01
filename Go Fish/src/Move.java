public class Move {
    private Card card;
    private Player player;

    public Move(Card card, Player player) {
        this.card = card;
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public Player getPlayer() {
        return player;
    }
}