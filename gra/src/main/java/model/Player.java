package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezentuje gracza.
 * Przechowuje jego rękę (flotę), talię, kredyty oraz referencję do jego planszy.
 */
public class Player {

    private String nickname;
    private int credits;
    private List<ShipCard> hand; // Karty w ręce (obecna flota na planszy)
    private List<ShipCard> deck; // Karty w talii (do dobrania)
    private Board board;         // Plansza gracza

    public Player(String nickname) {
        this.nickname = nickname;
        this.credits = 0;
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.board = new Board();
    }

    // Dodawanie kredytów co turę
    public void addCredits(int amount) {
        this.credits += amount;
    }

    // Dobieranie karty z talii do ręki
    public void drawCard() {
        if (!deck.isEmpty()) {
            hand.add(deck.remove(0));
        }
    }

    // --- METODY POTRZEBNE DO LOGIKI GRY ---

    public String getName() {
        return nickname;
    }

    public int getCredits() {
        return credits;
    }

    public List<ShipCard> getHand() {
        return hand;
    }

    /**
     * Ustawia startową flotę (np. po losowaniu w DraftSystem)
     */
    public void setHand(List<ShipCard> newHand) {
        this.hand = newHand;
    }

    public void setDeck(List<ShipCard> newDeck) {
        this.deck = newDeck;
    }

    public Board getBoard() {
        return board;
    }
}
