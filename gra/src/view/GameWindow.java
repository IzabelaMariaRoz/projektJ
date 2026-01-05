package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Główne okno aplikacji (JFrame).
 * Spina wszystkie panele w jedną całość.
 */
public class GameWindow extends JFrame {

    private BoardPanel playerBoardPanel;
    private BoardPanel enemyBoardPanel;
    
    public GameWindow() {
        super("Przebieggryw BATTLESHIPS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLayout(new BorderLayout());

        // Inicjalizacja komponentów
        initUI();

        setVisible(true);
    }

    private void initUI() {
        // TODO: Podział okna na strefę gracza i przeciwnika
        playerBoardPanel = new BoardPanel();
        add(playerBoardPanel, BorderLayout.CENTER);
        
        // TODO: Dodanie panelu ręki, panelu info itp.
    }
}
