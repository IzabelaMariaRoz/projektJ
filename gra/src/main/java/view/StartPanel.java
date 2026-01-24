package view;

import view.BoardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StartPanel extends JPanel {

    private JButton playButton;

    public StartPanel(){
        super();
        setBackground(new Color(30,30,60));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Battleships — gra strategiczna");
        title.setFont(new Font("SansSerif", Font.BOLD, 42));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Zanurz się w morskiej przygodzie!");
        subtitle.setFont(new Font("SansSerif", Font.ITALIC, 20));
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        playButton = new JButton("Rozpocznij grę");
        playButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        playButton.setFocusPainted(false);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(120));
        add(title);
        add(Box.createVerticalStrut(20));
        add(subtitle);
        add(Box.createVerticalStrut(50));
        add(playButton);
    }

    public void setPlayAction(ActionListener listener) {
        playButton.addActionListener(listener);
    }
}