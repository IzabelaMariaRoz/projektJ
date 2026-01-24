package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import model.Board;
import model.ShipCard;

/**
 * Panel graficzny reprezentujący planszę 6x6.
 * Wyświetla siatkę pól, na których mogą znajdować się karty.
 */
public class BoardPanel extends JPanel {

    private CardComponent[][] cells;
    private JPanel handPanel;
    private CardComponent[] handCards;

    public BoardPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 60));

        JPanel gridPanel = new JPanel(new GridLayout(6, 6));
        cells = new CardComponent[6][6];
        // Ustawienie Layoutu na siatkę 6x6
        //Ustawiamy plansze gry 6x6

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                cells[row][col] = new CardComponent(null);
                cells[row][col].setBackground(Color.WHITE);
                cells[row][col].setOpaque(true);
                cells[row][col].setBorder(new LineBorder(Color.DARK_GRAY, 2));
                gridPanel.add(cells[row][col]);
            }
        }

        add(gridPanel, BorderLayout.CENTER);

        // Pasek gracza na dole
        handPanel = new JPanel();
        handPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        handPanel.setBackground(new Color(50, 50, 70));

        handCards = new CardComponent[5];
        for (int i = 0; i < 5; i++) {
            handCards[i] = new CardComponent(null);
            handPanel.add(handCards[i]);
        }

        add(handPanel, BorderLayout.SOUTH);
    }


//    private void initializeGrid() {
//        for (int i = 0; i < 16; i++) {
//            // Tymczasowo dodajemy puste komponenty kart
//            add(new CardComponent(null));
//        }
//    }

    public void refresh(Board board) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ShipCard card = board.getCardAt(row, col);
                cells[row][col].setCard(card);
                cells[row][col].repaint();
            }
        }
    }

    public void setHand(ShipCard[] cards) {
        for (int i = 0; i < handCards.length && i < cards.length; i++) {
            handCards[i].setCard(cards[i]);
            handCards[i].repaint();
        }
    }
}
