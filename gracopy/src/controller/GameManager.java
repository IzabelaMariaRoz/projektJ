package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import model.ActionCard;
import model.Card;
import model.Player;
import model.ShipCard;
import view.BoardPanel;
import view.CardComponent;
import view.GameWindow;

public class GameManager {
    
    private GameWindow window;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    
    private boolean isBattlePhase = false;
    private Card selectedCard = null;

    public GameManager(GameWindow window, Player p1, Player p2) {
        this.window = window;
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = player1; 
        
        initGame();
    }

    private void initGame() {
        window.showBoard();
        attachListeners();
        refreshView();
    }

    private void refreshView() {
        if (!isBattlePhase) {
            // --- FAZA ROZSTAWIANIA ---
            // Widzę SWOJĄ planszę, widzę SWOJE statki (fogOfWar = false)
            window.updateStatus("ROZSTAWIANIE | " + currentPlayer.getName());
            window.getBoardPanel().refresh(currentPlayer.getBoard(), false);
            window.getBoardPanel().setHand(currentPlayer.getHand());
            
        } else {
            // --- FAZA BITWY ---
            // Widzę planszę WROGA, ukryte statki to "???" (fogOfWar = true)
            Player enemy = (currentPlayer == player1) ? player2 : player1;
            
            window.updateStatus("BITWA | " + currentPlayer.getName() + " -> Atakuje: " + enemy.getName());
            
            // KLUCZOWA ZMIANA: Pokazujemy planszę wroga!
            window.getBoardPanel().refresh(enemy.getBoard(), true);
            
            // Ale ręka (karty akcji) jest MOJA
            window.getBoardPanel().setHand(currentPlayer.getActionHand());
        }
    }

    private void attachListeners() {
        BoardPanel panel = window.getBoardPanel();

        // 1. RĘKA
        CardComponent[] handCards = panel.getHandCards();
        for (CardComponent comp : handCards) {
            for(var l : comp.getMouseListeners()) comp.removeMouseListener(l);
            comp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Card card = comp.getCard();
                    if (card != null) {
                        selectedCard = card;
                        // Zaznaczamy
                        for (CardComponent c : handCards) c.setSelected(false);
                        comp.setSelected(true);
                    }
                }
            });
        }

        // 2. PLANSZA
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                final int row = r;
                final int col = c;
                CardComponent cell = panel.getGridCell(row, col);
                for(var l : cell.getMouseListeners()) cell.removeMouseListener(l);

                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleGridClick(row, col);
                    }
                });
            }
        }
    }

 // W klasie GameManager.java

    private void handleGridClick(int row, int col) {
        if (!isBattlePhase) {
            // ... (logika rozstawiania bez zmian) ...
            if (selectedCard != null && selectedCard instanceof ShipCard) {
                ShipCard ship = (ShipCard) selectedCard;
                boolean success = currentPlayer.getBoard().placeShip(ship, row, col);
                if (success) {
                    currentPlayer.getHand().remove(ship);
                    selectedCard = null;
                    refreshView();
                    checkDeploymentFinished();
                } else {
                    JOptionPane.showMessageDialog(window, "Pole zajęte!");
                }
            }
        } else {
            // --- BITWA ---
            if (selectedCard != null && selectedCard instanceof ActionCard) {
                
                Player enemy = (currentPlayer == player1) ? player2 : player1;
                ShipCard targetShip = enemy.getBoard().getCardAt(row, col);
                
                if (enemy.getBoard().isMiss(row, col) || (targetShip != null && !targetShip.isFaceDown() && targetShip.getHp() <= 0)) {
                     JOptionPane.showMessageDialog(window, "To pole jest już sprawdzone/zniszczone!");
                     return;
                }

                ActionCard action = (ActionCard) selectedCard;
                
                // ATAK
                if (targetShip != null) {
                    JOptionPane.showMessageDialog(window, "TRAFIENIE! " + targetShip.getName() + " obrywa!");
                    targetShip.setFaceDown(false); 
                    
                    int dmg = 3; 
                    if(action.getName().contains("Torpeda")) dmg = 7;
                    if(action.getName().contains("Bomba")) dmg = 10;
                    if(action.getName().contains("Precyzyjny")) dmg = 4;
                    
                    targetShip.takeDamage(dmg);
                    
                    // --- SPRAWDZENIE ZWYCIĘSTWA ---
                    if (!enemy.getBoard().hasAliveShips()) {
                        refreshView(); // Żeby pokazać ostatni wybuch
                        gameOver(currentPlayer); // Gracz atakujący wygrał
                        return;
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(window, "PUDŁO!");
                    enemy.getBoard().markMiss(row, col);
                }
                
                currentPlayer.getActionHand().remove(action);
                currentPlayer.refillActionHand(); 
                
                selectedCard = null;
                endTurn();
            } else {
                JOptionPane.showMessageDialog(window, "Wybierz kartę ataku z ręki!");
            }
        }
    }

    // --- NOWA METODA: KONIEC GRY ---
    private void gameOver(Player winner) {
        String msg = "BITWA ZAKOŃCZONA!\nZwycięża: " + winner.getName() + " (" + winner.getFaction() + ")";
        JOptionPane.showMessageDialog(window, msg, "KONIEC GRY", JOptionPane.INFORMATION_MESSAGE);
        
        saveReport(winner);
        System.exit(0); // Zamknięcie aplikacji
    }

 // Importy, które mogą być potrzebne (dodaj na górze pliku, jeśli ich nie ma):
    // import java.io.File;
    // import java.io.PrintWriter;
    // import java.io.IOException;

    private void saveReport(Player winner) {
        java.io.File file = new java.io.File("raport_bitwy.txt");
        
        // ZMIANA: Używamy FileWriter z flagą 'true' (append mode)
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(file, true))) {
            
            writer.println(""); // Pusta linia odstępu przed nowym wpisem
            writer.println("========== NOWA BITWA ==========");
            writer.println("Data: " + new java.util.Date());
            writer.println("Zwycięzca: " + winner.getName());
            writer.println("Frakcja:   " + winner.getFaction());
            writer.println("================================");
            
            System.out.println("Raport dopisano do: " + file.getAbsolutePath());
            
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void checkDeploymentFinished() {
        if (currentPlayer.getHand().isEmpty()) {
            if (currentPlayer == player1) {
                JOptionPane.showMessageDialog(window, "Gracz 1 gotowy! Tura Gracza 2.");
                currentPlayer = player2;
                selectedCard = null;
                refreshView();
            } else {
                startBattlePhase();
            }
        }
    }
    
 // W pliku controller/GameManager.java znajdź metodę startBattlePhase i zamień ją na to:

    private void startBattlePhase() {
        isBattlePhase = true;
        JOptionPane.showMessageDialog(window, "BITWA! Teraz będziesz widział planszę przeciwnika.");
        
        // === NAPRAWA BŁĘDU NR 2 ===
        // Ukrywamy wszystkie statki na obu planszach przed rozpoczęciem walki.
        // Dzięki temu Gracz 1 nie zobaczy od razu statków Gracza 2.
        hideAllShips(player1);
        hideAllShips(player2);

        // Rozdajemy karty akcji
        player1.refillActionHand();
        player2.refillActionHand();
        
        currentPlayer = player1;
        selectedCard = null;
        refreshView();
    }

    // Dodaj tę metodę pomocniczą na dole klasy GameManager
    private void hideAllShips(Player p) {
        // Iterujemy po liście statków na planszy i zakrywamy je
        for (ShipCard ship : p.getBoard().getShipsOnBoard()) {
            ship.setFaceDown(true);
        }
    }
    
    private void endTurn() {
        // Zmiana gracza
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        selectedCard = null;
        
        JOptionPane.showMessageDialog(window, "Koniec tury! Teraz: " + currentPlayer.getName());
        refreshView();
    }
}