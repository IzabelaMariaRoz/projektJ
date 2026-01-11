import controller.DraftSystem;
import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;
import model.ShipCard;
import java.util.List;


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
    }
}