package view;

import javax.swing.JPanel;
import java.awt.GridLayout;

import model.Board;
import model.ShipCard;

/**
 * Panel graficzny reprezentujący planszę 6x6.
 * Wyświetla siatkę pól, na których mogą znajdować się karty.
 */
public class BoardPanel extends JPanel {

    private CardComponent[][] cells;

    public BoardPanel() {
        // Ustawienie Layoutu na siatkę 6x6
    	setLayout(new GridLayout(6, 6));
        cells = new CardComponent[6][6];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                cells[row][col] = new CardComponent(null); // tworzymy obiekt
                add(cells[row][col]);                       // dodajemy do JPanel
            }
        }
        // TODO: Wypełnienie siatki pustymi polami lub kartami
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < 16; i++) {
            // Tymczasowo dodajemy puste komponenty kart
            add(new CardComponent(null)); 
        }
    }

    public void refresh(Board board) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ShipCard card = board.getCardAt(row, col);
                cells[row][col].setCard(card);
                cells[row][col].repaint();
            }
        }
    }
}
