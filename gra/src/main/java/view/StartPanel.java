package view;

import view.BoardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.enums.Faction;


public class StartPanel extends JPanel {

    private JButton playButton;
    private JComboBox<Faction> factionComboBox1;
    private JComboBox<Faction> factionComboBox2;


    public StartPanel(){
        super();
        setBackground(new Color(30,30,60));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Battleships");
        title.setFont(new Font("SansSerif", Font.BOLD, 42));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Gra strategiczna");
        subtitle.setFont(new Font("SansSerif", Font.ITALIC, 20));
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel player1Label = new JLabel("Frakcja gracza 1:");
        player1Label.setForeground(Color.WHITE);
        player1Label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        player1Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        factionComboBox1 = new JComboBox<>(Faction.values());
        factionComboBox1.setAlignmentX(Component.CENTER_ALIGNMENT);
        factionComboBox1.setMaximumSize(new Dimension(200, 30));

        JLabel player2Label = new JLabel("Frakcja Gracza 2:");
        player2Label.setForeground(Color.WHITE);
        player2Label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        player2Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        factionComboBox2 = new JComboBox<>(Faction.values());
        factionComboBox2.setAlignmentX(Component.CENTER_ALIGNMENT);
        factionComboBox2.setMaximumSize(new Dimension(200, 30));
        if (factionComboBox2.getItemCount() > 1) {
            factionComboBox2.setSelectedIndex(1);
        }


        factionComboBox1.addActionListener(e -> {
            Faction selected = (Faction) factionComboBox1.getSelectedItem();
            factionComboBox2.removeAllItems();
            for (Faction f : Faction.values()) {
                if (f != selected) {
                    factionComboBox2.addItem(f);
                }
            }
        });

        playButton = new JButton("Rozpocznij grę");
        playButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        playButton.setFocusPainted(false);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(120));
        add(title);
        add(Box.createVerticalStrut(20));
        add(subtitle);
        add(Box.createVerticalStrut(50));
        add(player1Label);
        add(Box.createVerticalStrut(5));
        add(factionComboBox1);
        add(Box.createVerticalStrut(20));
        add(player2Label);
        add(Box.createVerticalStrut(5));
        add(factionComboBox2);
        add(Box.createVerticalStrut(50));
        add(playButton);
    }

    public void setPlayAction(ActionListener listener) {
        playButton.addActionListener(listener);
}


    public Faction getPlayer1Faction() {
         return (Faction) factionComboBox1.getSelectedItem();
    }

    public Faction getPlayer2Faction() {
        return (Faction) factionComboBox2.getSelectedItem();
    }
}