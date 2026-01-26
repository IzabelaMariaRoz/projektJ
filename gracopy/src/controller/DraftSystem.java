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

        // 5 slot - Wyjątek dla ZSRR (brak lotniskowców, dodatkowy pancernik)
        // Uwaga: Używam nazwy enum ZSR zgodnie z Twoim plikiem Faction.java
        // Jeśli masz tam ZSRR, zmień poniżej 'ZSR' na 'ZSRR'
        if (faction.name().equals("ZSR") || faction.name().equals("ZSRR")) {
            types.add(ShipType.BATTLESHIP); 
        } else {
            types.add(ShipType.AIRCRAFT_CARRIER); 
        }
        
        // Pętla tworzenia kart
        for (ShipType type : types) {
            // 1. Losujemy rzadkość (Matematyka dropu)
            Rarity rarity = rollRarity();
            
            // 2. Pobieramy kartę z bazy danych
            ShipCard card = CardDatabase.createCard(faction, type, rarity);
            
            // 3. Dodajemy do floty
            fleet.add(card);
            
            // Log w konsoli dla pewności
            System.out.println("DRAFT: Wylosowano " + card.getName() + " [" + rarity + "]");
        }  
        
        return fleet;
    }

    /**
     * Algorytm losujący rzadkość karty.
     * Szanse:
     * - STANDARD: 85% (1-85)
     * - UNIQUE: 10% (86-95)
     * - LEGENDARY: 5% (96-100)
     */
    private Rarity rollRarity() {
        int roll = random.nextInt(100) + 1; // Liczba od 1 do 100

        if (roll > 95) {
            return Rarity.LEGENDARY; // 5% szans
        } else if (roll > 85) {
            return Rarity.UNIQUE;    // 10% szans
        } else {
            return Rarity.STANDARD;  // 85% szans
        }
    }
}