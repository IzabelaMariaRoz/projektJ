package controller;

import model.Player;
import model.ShipCard;
import model.ActionCard;
import model.ActionDatabase;
import java.util.Scanner;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.io.IOException;

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

    public void startGame() {
        System.out.println("=== ROZPOCZYNAMY BITWĘ: " + player1.getName() + " vs " + player2.getName() + " ===");
        
        while (!checkGameOver()) {
            Player active = isP1Turn ? player1 : player2;
            Player opponent = isP1Turn ? player2 : player1;

            System.out.println("\n-------------------------------------------");
            System.out.println("TURA " + currentTurn + " | GRACZ: " + active.getName());
            
            active.addCredits(2);
            System.out.println("Zasoby: " + active.getCredits() + " kredytów.");

            ActionCard drawn = ActionDatabase.drawCard();
            if (drawn != null) {
                System.out.println("Dobrano kartę akcji: " + drawn.getName());
            }

            showFleetStatus(active);

            System.out.println("\nWYBIERZ AKCJĘ: [1] Atak statkiem | [2] Koniec tury | [9] Wyjdź");
            int choice = scanner.nextInt();

            if (choice == 1) {
                handleCombat(active, opponent);
            } else if (choice == 9) {
                break;
            }

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

        ShipCard attacker = myShips.get(0);
        ShipCard target = enemyShips.get(0);

        System.out.println("\n>>> " + attacker.getName() + " używa umiejętności na " + target.getName());
        attacker.performAction(target);

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
        // Sprawdzamy czy gracz nie ma już kart w ręce ORAZ statków na planszy
        if (player1.getHand().isEmpty() && player1.getBoard().getShipsOnBoard().isEmpty()) {
            saveWinReport(player2);
            return true;
        }
        if (player2.getHand().isEmpty() && player2.getBoard().getShipsOnBoard().isEmpty()) {
            saveWinReport(player1);
            return true;
        }
        return false;
    }

 /* Generuje raport końcowy bitwy do pliku tekstowego po spełnieniu warunków wygranej.
     * Zapisuje kluczowe statystyki: nazwę zwycięzcy, liczbę tur oraz pozostałe zasoby.
     * * @param winner Obiekt gracza, który wygrał pojedynek. */
    private void saveWinReport(Player winner) {
        try (PrintWriter writer = new PrintWriter("win_report.txt")) {
            writer.println("=== RAPORT KOŃCOWY BITWY ===");
            writer.println("Zwycięzca: " + winner.getName());
            writer.println("Tury: " + currentTurn);
            writer.println("Pozostałe kredyty: " + winner.getCredits());
            writer.println("Data: " + new java.util.Date());
            System.out.println("LOGIKA: Raport zapisany w win_report.txt");
        } catch (IOException e) {
            System.err.println("Błąd zapisu raportu: " + e.getMessage());
        }
    }

    public boolean placeShipFromHand(Player player, ShipCard ship, int row, int col) {
        // Próba postawienia na planszy
        if (player.getBoard().placeShip(ship, row, col)) {
            // Jeśli się udało, usuwamy z ręki (decka)
            boolean removed = player.getHand().remove(ship); 
            if (removed) {
                System.out.println("LOGIKA: Statek " + ship.getName() + " postawiony i usunięty z decka.");
                return true;
            }
        }
        System.out.println("LOGIKA: Nie udało się postawić statku na polu [" + row + "][" + col + "]");
        return false;
    }

    public MouseAdapter getMouseHandler(Player player, ShipCard ship) {
        return new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // Obliczanie pola (zakładając standardową siatkę w GUI)
                int row = e.getY() / 100; 
                int col = e.getX() / 100;
                
                System.out.println("Myszka puszczona na: " + row + ", " + col);
                
                if (placeShipFromHand(player, ship, row, col)) {
                    System.out.println("Myszka: Sukces postawienia statku.");
                }
            }
        };
    }
}
