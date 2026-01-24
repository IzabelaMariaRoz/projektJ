import controller.DraftSystem;
import view.GameWindow;
import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;
import model.ShipCard;
import model.Board;
import view.BoardPanel;
import java.util.List;
import javax.swing.*;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args){
        DraftSystem draft = new DraftSystem();
        List<ShipCard> fleet = draft.draftFleet(Faction.USA);
        BoardPanel boardPanel = new BoardPanel();
        Board board = new Board();

        ShipCard[] hand = fleet.stream().limit(5).toArray(ShipCard[]::new);
        boardPanel.setHand(hand);

        for (int i = 0; i < hand.length && i < 6; i++) {
            board.placeShip(hand[i], 0, i);
        }
        boardPanel.refresh(board);


        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GameWindow(board, hand);
            }
        });
    }
}