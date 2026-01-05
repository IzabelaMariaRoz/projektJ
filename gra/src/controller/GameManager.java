package controller;

import model.Player;

/**
 * Główny kontroler przepływu gry.
 * Zarządza turami, sprawdza warunki zwycięstwa.
 */
public class GameManager {
    
    private Player player1;
    private Player player2;
    private int currentTurn;

    public GameManager(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.currentTurn = 1;
    }

    // TODO: Metoda przejścia do następnej tury
    public void nextTurn() {
        currentTurn++;
        // Logika przyznawania kredytów, dobierania kart itp.
    }

    // TODO: Sprawdzenie, czy gra się skończyła
    public boolean checkWinCondition() {
        return false;
    }
}
