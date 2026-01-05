package controller;

import java.util.ArrayList;
import java.util.List;
import model.CardDatabase;
import model.ShipCard;
import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

/**
 * Odpowiada za mechanikę doboru floty na początku gry.
 * Obsługuje logikę procentową (85/10/5) oraz wyjątek dla ZSRR.
 */
public class DraftSystem {

    public List<ShipCard> draftFleet(Faction faction) {
        List<ShipCard> fleet = new ArrayList<>();
        
        // TODO: Zaimplementować logikę losowania rzadkości (Rarity)
        
        // Przykład użycia bazy:
        // fleet.add(CardDatabase.createCard(faction, ShipType.BATTLESHIP, Rarity.STANDARD));
        
        return fleet;
    }
}
