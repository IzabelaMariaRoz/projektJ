import controller.DraftSystem;
import view.GameWindow;
import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;
import model.ShipCard;
import model.Board;
import view.BoardPanel;
import java.util.List;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

        //---------TESTOWY MAIN--------------///
        DraftSystem draft = new DraftSystem();
        List<ShipCard> fleet = draft.draftFleet(Faction.USA);


        for (ShipCard ship : fleet) {
            System.out.println(
                    ship.getName() + " | Typ: " + ship.getType() + " | Atak: " + ship.getAttack()
            );
        }

        Board board = new Board();
        int i = 0;
        for (ShipCard ship : fleet) {
            board.placeShip(ship, i, i);
            i++;
        }

        BoardPanel panel = new BoardPanel();
        panel.refresh(board); // pokazujemy aktualny stan planszy

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}