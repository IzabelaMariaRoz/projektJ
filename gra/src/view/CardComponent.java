package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import model.ShipCard;

/**
 * Komponent wizualny pojedynczej karty.
 * Rysuje prostokąt z nazwą statku i jego statystykami.
 */
public class CardComponent extends JPanel {

    private ShipCard cardData;
    private JLabel nameLabel;

    public CardComponent(ShipCard card) {
        this.cardData = card;
        
        setPreferredSize(new Dimension(100, 140));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.LIGHT_GRAY);

        // TODO: Wyświetlanie danych karty
        if (card != null) {
            nameLabel = new JLabel(card.getName());
            add(nameLabel);
        } else {
            add(new JLabel("Puste"));
        }
    }
    
    // TODO: Metoda obsługi kliknięcia (do zagrywania/ataku)
}
