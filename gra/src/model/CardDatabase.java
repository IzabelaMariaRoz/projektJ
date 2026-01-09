package model;


import java.util.HashMap;
import java.util.Map;
import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

/**
 * "Fabryka" kart. Centralna baza danych.
 * Tutaj na podstawie parametrów (Frakcja, Typ, Rzadkość) tworzymy gotowy obiekt ShipCard
 * z odpowiednią nazwą (np. "Bismarck") i statystykami.
 */
public class CardDatabase {
    private static Map<String, ShipCard> cards = new HashMap<>();
    private static void addShipCard(String name, Faction faction, ShipType type, Rarity rarity,
                                    int hp, int attack, int abilityCost) {
        String key = faction.name() + "_" + type.name() + "_" + rarity.name() + "_" + name.replace(" ", "_");
        cards.put(key, new ShipCard(name, faction, type, rarity, hp, attack, abilityCost));
    }
    static{
        /**ShipCard */

 // GERMANY
        //BATTLESHIPS
        addShipCard("Gneisenau", Faction.GERMANY, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Gneisenau", Faction.GERMANY, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Bismarck", Faction.GERMANY, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Lützow", Faction.GERMANY, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("Tirpitz", Faction.GERMANY, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("Scharnhorst", Faction.GERMANY, ShipType.BATTLESHIP, Rarity.LEGENDARY, , , );

        //AIRCRAFT_CARRIERS
        addShipCard("Weser", Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("Elbe", Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("Graf Zeppelin", Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("Jade", Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, , , );
        addShipCard("Friesenland", Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, , , );
        addShipCard("Graf Zeppelin (Premium)", Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.LEGENDARY, , , );

        // CRUISERS
        addShipCard("Leipzig", Faction.GERMANY, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Nürnberg", Faction.GERMANY, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Admiral Hipper", Faction.GERMANY, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Prinz Eugen", Faction.GERMANY, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("Blücher", Faction.GERMANY, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("Admiral Scheer", Faction.GERMANY, ShipType.CRUISER, Rarity.LEGENDARY, , , );

        // DESTROYERS
        addShipCard("Z1 Leberecht Maass", Faction.GERMANY, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Z30", Faction.GERMANY, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Z23", Faction.GERMANY, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Z17 Diether von Roeder", Faction.GERMANY, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("Z38", Faction.GERMANY, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("Z39", Faction.GERMANY, ShipType.DESTROYER, Rarity.LEGENDARY, , , );

        // SUBMARINES
        addShipCard("U-47", Faction.GERMANY, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("U-96", Faction.GERMANY, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("U-99", Faction.GERMANY, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("Typ IX", Faction.GERMANY, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("Typ VII", Faction.GERMANY, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("Typ XXI", Faction.GERMANY, ShipType.SUBMARINE, Rarity.LEGENDARY, , , );


// USA
        // BATTLESHIPS
        addShipCard("USS Arizona", Faction.USA, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("USS Iowa", Faction.USA, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("USS Missouri", Faction.USA, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("USS Texas", Faction.USA, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("USS Washington", Faction.USA, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("USS South Dakota", Faction.USA, ShipType.BATTLESHIP, Rarity.LEGENDARY, , , );

        // AIRCRAFT_CARRIERS
        addShipCard("USS Hornet", Faction.USA, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("USS Yorktown", Faction.USA, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("USS Enterprise", Faction.USA, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("USS Langley", Faction.USA, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, , , );
        addShipCard("USS Saratoga", Faction.USA, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, , , );
        addShipCard("USS Essex", Faction.USA, ShipType.AIRCRAFT_CARRIER, Rarity.LEGENDARY, , , );

        // CRUISERS
        addShipCard("USS Helena", Faction.USA, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("USS San Francisco", Faction.USA, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("USS Indianapolis", Faction.USA, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("USS Baltimore", Faction.USA, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("USS Atlanta", Faction.USA, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("USS Alaska", Faction.USA, ShipType.CRUISER, Rarity.LEGENDARY, , , );

         // DESTROYERS
        addShipCard("USS Johnston", Faction.USA, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("USS Laffey", Faction.USA, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("USS Fletcher", Faction.USA, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("USS Porter", Faction.USA, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("USS Kidd", Faction.USA, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("USS O'Bannon", Faction.USA, ShipType.DESTROYER, Rarity.LEGENDARY, , , );

        //SUBMARINES
        addShipCard("USS Trigger", Faction.USA, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("USS Wahoo", Faction.USA, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("USS Tang", Faction.USA, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("USS Nautilus", Faction.USA, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("USS Gato", Faction.USA, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("USS Barb", Faction.USA, ShipType.SUBMARINE, Rarity.LEGENDARY, , , );


// JAPAN
        // Battleships
        addShipCard("Fusō", Faction.JAPAN, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Nagato", Faction.JAPAN, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Yamato", Faction.JAPAN, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Ise", Faction.JAPAN, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("Mutsu", Faction.JAPAN, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("Musashi", Faction.JAPAN, ShipType.BATTLESHIP, Rarity.LEGENDARY, , , );

        //AIRCRAFT-CARRIERS
        addShipCard("Shōkaku", Faction.JAPAN, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("Kaga", Faction.JAPAN, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("Akagi", Faction.JAPAN, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, , , );
        addShipCard("Ryūjō", Faction.JAPAN, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, , , );
        addShipCard("Zuikaku", Faction.JAPAN, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, , , );
        addShipCard("Shinano", Faction.JAPAN, ShipType.AIRCRAFT_CARRIER, Rarity.LEGENDARY, , , );

        //CRUISERS
        addShipCard("Mogami", Faction.JAPAN, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Takao", Faction.JAPAN, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Atago", Faction.JAPAN, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Kumano", Faction.JAPAN, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("Tone", Faction.JAPAN, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("Chikuma", Faction.JAPAN, ShipType.CRUISER, Rarity.LEGENDARY, , , );

        //DESTROYERS
        addShipCard("Akizuki", Faction.JAPAN, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Yūgumo", Faction.JAPAN, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Kagerō", Faction.JAPAN, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Shiranui", Faction.JAPAN, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("Tokitsukaze", Faction.JAPAN, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("Hatsuyuki", Faction.JAPAN, ShipType.DESTROYER, Rarity.LEGENDARY, , , );

        //submarines
        addShipCard("I-26", Faction.JAPAN, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("I-19", Faction.JAPAN, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("I-168", Faction.JAPAN, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("I-400", Faction.JAPAN, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("I-58", Faction.JAPAN, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("I-201", Faction.JAPAN, ShipType.SUBMARINE, Rarity.LEGENDARY, , , );


//ZSRR
        // BATTLESHIPS
        addShipCard("Parizhskaya Kommuna", Faction.ZSRR, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Oktiabrskaja Riewolucija", Faction.ZSRR, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Marat", Faction.ZSRR, ShipType.BATTLESHIP, Rarity.STANDARD, , , );
        addShipCard("Sewastopol", Faction.ZSRR, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("Gangut", Faction.ZSRR, ShipType.BATTLESHIP, Rarity.UNIQUE, , , );
        addShipCard("Marat", Faction.ZSRR, ShipType.BATTLESHIP, Rarity.LEGENDARY, , , );

        //CRUISERS
        addShipCard("Czerwona Krym", Faction.ZSRR, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Czerwona Ukraina", Faction.ZSRR, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Kirow(projekt 26)", Faction.ZSRR, ShipType.CRUISER, Rarity.STANDARD, , , );
        addShipCard("Kalinin", Faction.ZSRR, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("Maxim Gorki", Faction.ZSRR, ShipType.CRUISER, Rarity.UNIQUE, , , );
        addShipCard("Kirow", Faction.ZSRR, ShipType.CRUISER, Rarity.LEGENDARY, , , );

        //DESTROYERS
        addShipCard("Gromkij", Faction.ZSRR, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Storozhevoy", Faction.ZSRR, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Gnewnyj", Faction.ZSRR, ShipType.DESTROYER, Rarity.STANDARD, , , );
        addShipCard("Soobrazitelnyj", Faction.ZSRR, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("Rekordnyj", Faction.ZSRR, ShipType.DESTROYER, Rarity.UNIQUE, , , );
        addShipCard("Tashkent", Faction.ZSRR, ShipType.DESTROYER, Rarity.LEGENDARY, , , );

        //SUBMARINES
        addShipCard("S-13", Faction.ZSRR, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("Shch-303", Faction.ZSRR, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("D-2", Faction.ZSRR, ShipType.SUBMARINE, Rarity.STANDARD, , , );
        addShipCard("M-class", Faction.ZSRR, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("K-21", Faction.ZSRR, ShipType.SUBMARINE, Rarity.UNIQUE, , , );
        addShipCard("L-3", Faction.ZSRR, ShipType.SUBMARINE, Rarity.LEGENDARY, , , );







    }

    public static ShipCard createCard(Faction faction, ShipType type, Rarity rarity) {
        String key = faction.name() + "_" + type.name() + "_" + rarity.name();
        ShipCard card = cards.get(key);
        if (card == null) {
            // jeśli nie ma w bazie — placeholder
            return new ShipCard("Nieznany", faction, type, rarity, 10, 2, 3);
        }
        return new ShipCard(
                card.getName(),
                card.getFaction(),
                card.getType(),
                card.getRarity(),
                card.getHp(),
                card.getAttack(),
                3
        );
    }
    public static Map<String, ShipCard> getAllCards() {
        return new HashMap<>(cards); // kopia, bezpieczniejsza

    }
}