package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
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
        this.nameLabel = new JLabel();
        
        setPreferredSize(new Dimension(100, 140));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.LIGHT_GRAY);

        // TODO: Wyświetlanie danych karty
        nameLabel = new JLabel("", JLabel.CENTER);
        add(nameLabel, BorderLayout.CENTER);

        // od razu wyświetlamy zawartość
        updateDisplay();
    }

    public void setCard(ShipCard card) {
        this.cardData = card;
        updateDisplay();
    }

    private void updateDisplay() {
        if (cardData != null) {
            String text = "<html>" +
                    cardData.getName() + "<br>" +
                    "Typ: " + cardData.getType().name() + "<br>" +
                    "Faction: " + cardData.getFaction().name() +
                    "</html>";
            nameLabel.setText(text);
            setBackground(Color.LIGHT_GRAY);
        } else {
            nameLabel.setText("");
            setBackground(Color.WHITE);
        }
        repaint();
    }
    
    // TODO: Metoda obsługi kliknięcia (do zagrywania/ataku)
}
