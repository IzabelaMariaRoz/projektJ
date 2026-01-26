package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Board;
import model.ShipCard;

public class GameWindow extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private StartPanel startPanel;
    private BoardPanel boardPanel;
    
    // --- NOWOŚĆ: Pasek statusu ---
    private JLabel statusLabel; 

    public GameWindow() {
        super("Przebieggryw BATTLESHIPS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 800); // Troszkę wyższe
        setLocationRelativeTo(null);

        // Pasek statusu na samej górze okna
        statusLabel = new JLabel("Witaj w grze!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.BLACK);
        statusLabel.setForeground(Color.YELLOW);
        add(statusLabel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        startPanel = new StartPanel();
        boardPanel = new BoardPanel();

        mainPanel.add(startPanel, "START");
        mainPanel.add(boardPanel, "BOARD");

        add(mainPanel, BorderLayout.CENTER);
        cardLayout.show(mainPanel, "START");

        setVisible(true);
    }

    public void updateStatus(String text) {
        statusLabel.setText(text);
    }

    public void showBoard() {
        cardLayout.show(mainPanel, "BOARD");
    }

    public StartPanel getStartPanel() { return startPanel; }
    public BoardPanel getBoardPanel() { return boardPanel; }
}