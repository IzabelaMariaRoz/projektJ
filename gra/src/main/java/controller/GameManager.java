package controller;

import model.Player;
import model.Board;

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

    // Metoda przejścia do następnej tury
    public void nextTurn() {
        currentTurn++;

        player1.addCredits(1);
        player2.addCredits(1);
        // Logika przyznawania kredytów, dobierania kart itp.
    }

    // Sprawdzenie, czy gra się skończyła
    public boolean checkWinCondition() {

        boolean player1HasShips = false;
        boolean player2HasShips = false;

        Board board1 = player1.getBoard();
        Board board2 = player2.getBoard();

        return false;
    }    
}
