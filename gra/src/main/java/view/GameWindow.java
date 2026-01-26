package view;

import view.BoardPanel;
import view.StartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import model.Board;
import model.ShipCard;
import model.enums.Faction;
import controller.DraftSystem;
import java.util.List;

/**
 * Główne okno aplikacji (JFrame).
 * Spina wszystkie panele w jedną całość.
 */
public class GameWindow extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private BoardPanel boardPanel;

    public GameWindow(Board board, ShipCard[] hand) {
        super("BATTLESHIPS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);     //metoda do zamykania naszego okna
        setSize(1024, 768);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        StartPanel startPanel = new StartPanel();
        BoardPanel boardPanel = new BoardPanel();

        boardPanel.setHand(hand);
        boardPanel.refresh(board);

        setBackground(new Color(30, 30, 60));


        mainPanel.add(startPanel, "START");
        mainPanel.add(boardPanel, "BOARD");

        cardLayout.show(mainPanel, "START");


        startPanel.setPlayAction(e -> cardLayout.show(mainPanel, "BOARD"));

        add(mainPanel);
        setVisible(true);
    }

    public void showBoardPanel(){
        cardLayout.show(mainPanel, "BOARD");
    }


}
