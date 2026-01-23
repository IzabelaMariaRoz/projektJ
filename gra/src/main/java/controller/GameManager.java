package controller;

import model.Player;
import model.ShipCard;
import model.ActionCard;
import model.ActionDatabase;
import java.util.Scanner;
import java.util.List;

/**
 * Główny kontroler przepływu gry (Wersja Tekstowa).
 */
public class GameManager {
    
    private Player player1;
    private Player player2;
    private boolean isP1Turn = true;
    private int currentTurn = 1;
    private Scanner scanner = new Scanner(System.in);

    public GameManager(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    // Metoda startująca pętlę gry w konsoli
    public void startGame() {
        System.out.println("=== ROZPOCZYNAMY BITWĘ: " + player1.getName() + " vs " + player2.getName() + " ===");
        
        while (!checkGameOver()) {
            Player active = isP1Turn ? player1 : player2;
            Player opponent = isP1Turn ? player2 : player1;

            System.out.println("\n-------------------------------------------");
            System.out.println("TURA " + currentTurn + " | GRACZ: " + active.getName());
            
            // 1. Dodanie kredytów co turę
            active.addCredits(2);
            System.out.println("Zasoby: " + active.getCredits() + " kredytów.");

            // 2. Dobranie karty akcji z bazy (logika kolegi)
            ActionCard drawn = ActionDatabase.drawCard();
            if (drawn != null) {
                System.out.println("Dobrano kartę akcji: " + drawn.getName());
            }

            // 3. Wyświetlenie stanu floty
            showFleetStatus(active);

            // 4. Menu akcji
            System.out.println("\nWYBIERZ AKCJĘ: [1] Atak statkiem | [2] Koniec tury | [9] Wyjdź");
            int choice = scanner.nextInt();

            if (choice == 1) {
                handleCombat(active, opponent);
            } else if (choice == 9) {
                break;
            }

            // Zmiana tury
            isP1Turn = !isP1Turn;
            if (isP1Turn) currentTurn++;
        }
    }

    private void handleCombat(Player active, Player opponent) {
        List<ShipCard> myShips = active.getHand();
        List<ShipCard> enemyShips = opponent.getHand();

        if (myShips.isEmpty() || enemyShips.isEmpty()) {
            System.out.println("Brak jednostek do walki!");
            return;
        }

        // Uproszczenie: pierwszy statek gracza atakuje pierwszy statek wroga
        ShipCard attacker = myShips.get(0);
        ShipCard target = enemyShips.get(0);

        System.out.println("\n>>> " + attacker.getName() + " używa umiejętności na " + target.getName());
        
        // Wywołanie logiki z Twojego AbilityFactory
        attacker.performAction(target);

        // Usuwanie zniszczonych jednostek
        if (target.getHp() <= 0) {
            System.out.println("!!! Statek " + target.getName() + " został zatopiony!");
            enemyShips.remove(target);
        }
    }

    private void showFleetStatus(Player p) {
        System.out.println("Twoja flota:");
        for (int i = 0; i < p.getHand().size(); i++) {
            ShipCard s = p.getHand().get(i);
            System.out.println("[" + i + "] " + s.getName() + " (HP: " + s.getHp() + "/" + s.getMaxHp() + ")");
        }
    }

    public boolean checkGameOver() {
        if (player1.getHand().isEmpty()) {
            System.out.println("\nKONIEC GRY! Wygrał " + player2.getName());
            return true;
        }
        if (player2.getHand().isEmpty()) {
            System.out.println("\nKONIEC GRY! Wygrał " + player1.getName());
            return true;
        }
        return false;
    }
}
