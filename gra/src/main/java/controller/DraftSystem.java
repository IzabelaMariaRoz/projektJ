package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    private Random random = new Random(); 

    public List<ShipCard> draftFleet(Faction faction) {
        List<ShipCard> fleet = new ArrayList<>();
        
        // TODO: Zaimplementować logikę losowania rzadkości (Rarity)
        List<ShipType> types = new ArrayList<>(List.of(
            ShipType.BATTLESHIP, ShipType.CRUISER, ShipType.DESTROYER, ShipType.SUBMARINE
        ));

        // Wyjątek dla ZSRR: 
        if (faction == Faction.ZSRR) {
            types.add(ShipType.BATTLESHIP); // Dodatkowy Pancernik
        } else {
            types.add(ShipType.AIRCRAFT_CARRIER); // Standardowy Lotniskowiec
        }
        
        // Przykład użycia bazy:
        for (ShipType type : types) {
            Rarity rarity = rollRarity();
            fleet.add(CardDatabase.createCard(faction, type, rarity));
        }  
        // fleet.add(CardDatabase.createCard(faction, ShipType.BATTLESHIP, Rarity.STANDARD));
        
        return fleet;
    } 

    private Rarity rollRarity() {
        int roll = random.nextInt(100); // 0-99
        if (roll < 5) return Rarity.LEGENDARY;  // 5%
        if (roll < 15) return Rarity.UNIQUE;    // 10%
        return Rarity.STANDARD;                 // 85%
    }
}
