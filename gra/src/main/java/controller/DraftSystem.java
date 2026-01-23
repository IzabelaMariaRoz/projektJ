package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.CardDatabase;
import model.ShipCard;
import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

public class DraftSystem {
    private Random random = new Random(); 

    public List<ShipCard> draftFleet(Faction faction) {
        List<ShipCard> fleet = new ArrayList<>();
        
        // Definiujemy bazowe typy (4 sloty)
        List<ShipType> types = new ArrayList<>(List.of(
            ShipType.BATTLESHIP, ShipType.CRUISER, ShipType.DESTROYER, ShipType.SUBMARINE
        ));

        // 5 slot - Wyjątek dla ZSRR: dodatkowy Pancernik zamiast Lotniskowca
        if (faction == Faction.ZSRR) {
            types.add(ShipType.BATTLESHIP); 
        } else {
            types.add(ShipType.AIRCRAFT_CARRIER); 
        }
        
        // Losujemy rzadkość dla każdego slotu i tworzymy kartę
        for (ShipType type : types) {
            Rarity rarity = rollRarity();
            // Wywołujemy bazę danych kolegi, żeby stworzyć obiekt
            fleet.add(CardDatabase.createCard(faction, type, rarity));
        }  
        
        return fleet;
    } 

    private Rarity rollRarity() {
        int roll = random.nextInt(100); 
        if (roll < 5) return Rarity.LEGENDARY;  // 5% szans
        if (roll < 15) return Rarity.UNIQUE;    // 10% szans (5+10)
        return Rarity.STANDARD;                 // 85% szans
    }
}
