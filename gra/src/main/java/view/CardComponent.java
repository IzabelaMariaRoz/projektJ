package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import model.ShipCard;



/**
 * Komponent wizualny pojedynczej karty.
 * Rysuje prostokąt z nazwą statku i jego statystykami.
 */
public class CardComponent extends JPanel {

    private ShipCard cardData;
    private JLabel nameLabel;
    private Image shipImage;

    private static final int CARD_WIDTH = 150;
    private static final int CARD_HEIGHT = 100;

    public CardComponent(ShipCard card) {
        this.cardData = card;
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.DARK_GRAY, 2));
        setBackground(Color.WHITE);

        nameLabel = new JLabel("", SwingConstants.CENTER);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        add(nameLabel, BorderLayout.CENTER);

        updateDisplay();
    }

    public void setCard(ShipCard card) {
        this.cardData = card;
        updateDisplay();
    }

    private void updateDisplay() {
        if (cardData != null) {
            String text = "<html><center>" +
                    "<b>" + cardData.getName() + "</b><br>" +
                    "Typ: " + cardData.getType().name() + "<br>" +
                    "Faction: " + cardData.getFaction().name() +
                    "</center></html>";
            nameLabel.setText(text);
            setBackground(Color.LIGHT_GRAY);

            if (cardData.getImage() != null) {
                shipImage = cardData.getImage(); // konwertujemy ImageIcon na Image
            } else {
                shipImage = null;
            }
        } else {
            nameLabel.setText("");
            setBackground(Color.WHITE);
        }
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(CARD_WIDTH, CARD_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image shipImage = null;
        if (cardData != null) {
            shipImage = cardData.getImage();
        }

        if (shipImage != null) {
            int x = 10, y = 10;
            int drawWidth = 100;
            int drawHeight = 150;
            g.drawImage(shipImage, x, y, drawWidth, drawHeight, this);
        }
    }
}
