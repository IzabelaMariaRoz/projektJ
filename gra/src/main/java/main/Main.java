import controller.DraftSystem;
import controller.GameManager;
import model.Player;
import view.GameWindow;
import model.enums.Faction;
import model.ShipCard;
import model.Board;
import view.BoardPanel;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        DraftSystem draft = new DraftSystem();
        
        Player p1 = new Player("Gracz 1", Faction.USA);
        Player p2 = new Player("Gracz 2", Faction.ZSRR);
        
        List<ShipCard> fleet = draft.draftFleet(p1.getFaction());
        p1.setHand(fleet);
        
        GameManager gm = new GameManager(p1, p2);
        
        BoardPanel boardPanel = new BoardPanel();
        Board board = p1.getBoard();

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
