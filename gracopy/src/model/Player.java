package model;

import java.util.ArrayList;
import java.util.List;
import model.enums.Faction;

public class Player {

    private String nickname;
    private Faction faction;
    private int credits;
    
    // FLOTA (Statki)
    private List<ShipCard> hand;      // Statki do rozstawienia
    private Board board;              // Statki na planszy

    // NOWOŚĆ: RĘKA AKCJI (Karty zagrywek)
    private List<ActionCard> actionHand; 

    public Player(String nickname, Faction faction) {
        this.nickname = nickname;
        this.faction = faction;
        this.credits = 0;
        this.hand = new ArrayList<>();
        this.actionHand = new ArrayList<>(); // Inicjalizacja
        this.board = new Board();
    }

    /**
     * NOWOŚĆ: Dopełnia rękę kartami akcji do 5 sztuk.
     */
    public void refillActionHand() {
        while (actionHand.size() < 5) {
            ActionCard newCard = ActionDatabase.drawCard();
            if (newCard != null) {
                actionHand.add(newCard);
            } else {
                break; // Brak kart w bazie (mało prawdopodobne)
            }
        }
    }

    // --- GETTERY I SETTERY ---
    
    public List<ActionCard> getActionHand() {
        return actionHand;
    }

    public void addCredits(int amount) { this.credits += amount; }
    
    public String getName() { return nickname; }
    public Faction getFaction() { return faction; }
    public List<ShipCard> getHand() { return hand; }
    public Board getBoard() { return board; }
}