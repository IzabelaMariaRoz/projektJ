package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezentuje gracza.
 * Przechowuje jego rękę, talię, kredyty oraz referencję do jego planszy.
 */
public class Player {
    
    private String nickname;
    private int credits;
    private List<ShipCard> hand; // Karty w ręce
    private List<ShipCard> deck; // Karty w talii (do dobrania)
    private Board board;         // Plansza gracza

    public Player(String nickname) {
        this.nickname = nickname;
        this.credits = 0;
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.board = new Board();
    }

    // TODO: Dodawanie kredytów co turę
    public void addCredits(int amount) {
        this.credits += amount;
    }

    // TODO: Dobieranie karty z talii do ręki
    public void drawCard() {
        if (!deck.isEmpty()) {
            hand.add(deck.remove(0));
        }
    }

    public Board getBoard() { return board; }
    public List<ShipCard> getHand() { return hand; }
    public void setDeck(List<ShipCard> newDeck) { this.deck = newDeck; }
}
