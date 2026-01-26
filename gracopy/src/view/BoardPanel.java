package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import model.Board;
import model.Card;
import model.ShipCard;

public class BoardPanel extends JPanel {

    private CardComponent[][] cells;
    private CardComponent[] handCards;

    public BoardPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 60));

        JPanel gridPanel = new JPanel(new GridLayout(6, 6));
        cells = new CardComponent[6][6];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                cells[row][col] = new CardComponent(null);
                cells[row][col].setBackground(Color.WHITE);
                cells[row][col].setBorder(new LineBorder(Color.DARK_GRAY, 1));
                gridPanel.add(cells[row][col]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        JPanel handPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        handPanel.setBackground(new Color(50, 50, 70));
        
        handCards = new CardComponent[5];
        for (int i = 0; i < 5; i++) {
            handCards[i] = new CardComponent(null);
            handPanel.add(handCards[i]);
        }
        add(handPanel, BorderLayout.SOUTH);
    }

    /**
     * Odświeża planszę.
     * @param board - Plansza do wyświetlenia
     * @param isEnemyView - TRUE jeśli patrzymy na wroga (wtedy ukrywamy statki)
     */
    public void refresh(Board board, boolean isEnemyView) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ShipCard card = board.getCardAt(row, col);
                boolean isMiss = board.isMiss(row, col);
                
                // Przekazujemy stan do kafelka: Karta, CzyPudło, CzyUkryć
                cells[row][col].setGameState(card, isMiss, isEnemyView);
            }
        }
    }

    public void setHand(List<? extends Card> cards) {
        for (int i = 0; i < handCards.length; i++) {
            if (i < cards.size()) {
                handCards[i].setCard(cards.get(i));
            } else {
                handCards[i].setCard(null);
            }
            handCards[i].setSelected(false);
            handCards[i].repaint();
        }
    }
    
    public CardComponent getGridCell(int row, int col) { return cells[row][col]; }
    public CardComponent[] getHandCards() { return handCards; }
}