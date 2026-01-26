package main;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.List;

import controller.DraftSystem;
import controller.GameManager; // Importujemy Twój nowy kontroler
import model.Player;
import model.ShipCard;
import model.enums.Faction;
import view.GameWindow;

public class Main {

    public static void main(String[] args) {
        // Uruchamiamy aplikację w wątku Swinga (wymagane dla GUI)
        SwingUtilities.invokeLater(() -> {
            
            // 1. Tworzymy główne okno (na początku pokaże StartPanel)
            GameWindow window = new GameWindow();

            // 2. Definiujemy, co się stanie po kliknięciu "Rozpocznij grę"
            window.getStartPanel().setPlayAction(e -> {
                
                try {
                    // A. Pobieramy wybrane przez gracza frakcje
                    Faction f1 = window.getStartPanel().getFaction1();
                    Faction f2 = window.getStartPanel().getFaction2();

                    System.out.println("LOG: Wybrano starcie: " + f1 + " vs " + f2);

                    // B. Uruchamiamy system losowania (Draft)
                    DraftSystem draft = new DraftSystem();
                    
                    // --- TWORZENIE GRACZA 1 ---
                    Player p1 = new Player("Gracz 1", f1);
                    List<ShipCard> fleetP1 = draft.draftFleet(f1);
                    // Przepisujemy wylosowane statki do ręki gracza
                    for(ShipCard ship : fleetP1) {
                        p1.getHand().add(ship);
                    }

                    // --- TWORZENIE GRACZA 2 ---
                    Player p2 = new Player("Gracz 2", f2);
                    List<ShipCard> fleetP2 = draft.draftFleet(f2);
                    for(ShipCard ship : fleetP2) {
                        p2.getHand().add(ship);
                    }

                    // C. Budujemy Raport z losowania (dla informacji graczy)
                    StringBuilder draftReport = new StringBuilder();
                    draftReport.append("=== RAPORT Z POBORU FLOTY ===\n\n");
                    
                    // Sekcja Gracza 1
                    draftReport.append("GRACZ 1 (").append(f1).append("):\n");
                    for(ShipCard ship : p1.getHand()) {
                        draftReport.append(" • ").append(ship.getName())
                                   .append(" [").append(ship.getRarity()).append("]\n");
                    }
                    
                    draftReport.append("\n----------------------------------\n\n");
                    
                    // Sekcja Gracza 2
                    draftReport.append("GRACZ 2 (").append(f2).append("):\n");
                    for(ShipCard ship : p2.getHand()) {
                        draftReport.append(" • ").append(ship.getName())
                                   .append(" [").append(ship.getRarity()).append("]\n");
                    }

                    // Wyświetlamy raport w okienku z przewijaniem (JTextArea)
                    JTextArea textArea = new JTextArea(draftReport.toString());
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                    JOptionPane.showMessageDialog(window, scrollPane, 
                        "Gotowość Bojowa", JOptionPane.INFORMATION_MESSAGE);

                    // D. PRZEKAZANIE STEROWANIA DO GAMEMANAGERA
                    // To jest kluczowy moment - Main kończy pracę, a GameManager przejmuje okno.
                    new GameManager(window, p1, p2);
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(window, 
                        "Błąd krytyczny podczas startu: " + ex.getMessage(),
                        "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
    }
}