package view;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Panel graficzny reprezentujący planszę 6x6.
 * Wyświetla siatkę pól, na których mogą znajdować się karty.
 */
public class BoardPanel extends JPanel {

    public BoardPanel() {
        // Ustawienie Layoutu na siatkę 6x6
    	setLayout(new GridLayout(6, 6));
        
        // TODO: Wypełnienie siatki pustymi polami lub kartami
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < 16; i++) {
            // Tymczasowo dodajemy puste komponenty kart
            add(new CardComponent(null)); 
        }
    }
    
    // TODO: Metoda odświeżająca widok na podstawie obiektu model.Board
    public void refresh() {
        // ...
    }
}
