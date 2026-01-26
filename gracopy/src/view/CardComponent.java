package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import model.Card;
import model.ShipCard;
import model.ActionCard;
import model.enums.Rarity;

public class CardComponent extends JPanel {

    private Card card;
    private JLabel centerLabel;
    private JLabel infoLabel;
    private boolean isSelected = false;
    private boolean isMiss = false; 
    private boolean fogOfWar = false;

    public CardComponent(Card card) {
        this.card = card;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 100));
        
        centerLabel = new JLabel("", SwingConstants.CENTER);
        add(centerLabel, BorderLayout.CENTER);
        
        infoLabel = new JLabel("", SwingConstants.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

        updateView();
    }

    public void setGameState(Card card, boolean isMiss, boolean fogOfWar) {
        this.card = card;
        this.isMiss = isMiss;
        this.fogOfWar = fogOfWar;
        this.isSelected = false;
        updateView();
    }
    
    public void setCard(Card card) { setGameState(card, false, false); }
    public Card getCard() { return card; }
    public void setSelected(boolean selected) { this.isSelected = selected; updateView(); }

    private void updateView() {
        setBorder(new LineBorder(Color.GRAY, 1));
        
        // PUDŁO
        if (isMiss) {
            setBackground(new Color(240, 240, 240));
            centerLabel.setText("<html><font size='6' color='red'><b>X</b></font></html>");
            infoLabel.setText("");
            return;
        }

        if (card != null) {
            if (card instanceof ShipCard) {
                ShipCard ship = (ShipCard) card;
                
                // UKRYTY (MGŁA WOJNY) -> Białe pole
                if (fogOfWar && ship.isFaceDown()) {
                    setBackground(Color.WHITE);
                    centerLabel.setText("");
                    infoLabel.setText("");
                } 
                // WIDOCZNY (Mój lub Odkryty Wrogi)
                else {
                    // === NOWOŚĆ: CZY STATEK JEST ZNISZCZONY? ===
                    if (ship.getHp() <= 0) {
                        setBackground(Color.LIGHT_GRAY); // Szary kolor dla wraku
                        centerLabel.setText("<html><center><s>" + ship.getName() + "</s><br/><font color='red'><b>ZATOPIONY</b></font></center></html>");
                        infoLabel.setText("HP: 0/" + ship.getMaxHp());
                    } else {
                        // ŻYWY STATEK (Kolory Rzadkości)
                        if (ship.getRarity() == Rarity.LEGENDARY) setBackground(new Color(255, 215, 0));
                        else if (ship.getRarity() == Rarity.UNIQUE) setBackground(new Color(186, 85, 211));
                        else setBackground(new Color(135, 206, 250));
        
                        centerLabel.setText("<html><center><b>" + ship.getName() + "</b><br/><small>" + ship.getType() + "</small></center></html>");
                        infoLabel.setText("HP: " + ship.getHp() + "/" + ship.getMaxHp());
                    }
                }
            } 
            else if (card instanceof ActionCard) {
                ActionCard action = (ActionCard) card;
                setBackground(new Color(255, 160, 122)); 
                centerLabel.setText("<html><center><b>" + action.getName() + "</b><br/><small>AKCJA</small></center></html>");
                infoLabel.setText("<html><center><small>" + action.getDescription() + "</small></center></html>");
            }

            if (isSelected) {
                setBorder(new LineBorder(Color.GREEN, 4));
            }
        } else {
            // Puste pole
            centerLabel.setText("");
            infoLabel.setText("");
            setBackground(Color.WHITE);
        }
        repaint();
    }
}