package model;

import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

/**
 * "Fabryka" kart. Centralna baza danych.
 * Tutaj na podstawie parametrów (Frakcja, Typ, Rzadkość) tworzymy gotowy obiekt ShipCard
 * z odpowiednią nazwą (np. "Bismarck") i statystykami.
 */
public class CardDatabase {
    private static final Map<String, ShipCards> cards = new HashMap<>();

    static{
        /**ShipCard */
        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Schleswig-Holstein"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Gneisenau"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Bismarck"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Lützow"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Tirpitz"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Lützow"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Scharnhorst"), Faction.GERMANY, ShipType.BATTLESHIPS, Rarity.LEGENDARY, ));



        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Waser"), Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Elbe"), Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Graf Zeppelin"), Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Jade"), Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Friesenland"), Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Graf Zeppelin(Premium)"), Faction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.LEGENDARY, ));



        cards.put("GERMANY_CUISERS",
                new ShipCard("Leipzig"), Faction.GERMANY, ShipType.CUISERS, Rarity.STANDARD, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Nürnberg"), Faction.GERMANY, ShipType.CUISERS, Rarity.STANDARD, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Admiral Hipper"), Faction.GERMANY, ShipType.CUISERS, Rarity.STANDARD, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Prinz Eugen"), Faction.GERMANY, ShipType.CUISERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Blücher"), Faction.GERMANY, ShipType.CUISERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Admiral Scheer"), Faction.GERMANY, ShipType.CUISERS, Rarity.LENGENDARY, ));



        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z1 Leberecht Maass"), Faction.GERMANY, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z30"), Faction.GERMANY, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z23"), Faction.GERMANY, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z17 Diether von Roeder"), Faction.GERMANY, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z38"), Faction.GERMANY, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z39"), Faction.GERMANY, ShipType.DESTROYERS, Rarity.LEGENDARY, ));



        cards.put("GERMANY_SUBMARINES",
                new ShipCard("U-47"), Faction.GERMANY, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("U-96"), Faction.GERMANY, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("U-99"), Faction.GERMANY, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("Typ IX"), Faction.GERMANY, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("Typ VII"), Faction.GERMANY, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("Typ XXI"), Faction.GERMANY, ShipType.SUBMARINES, Rarity.LEGENDARY, ));



        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Arizona"), Faction.USA, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Iowa"), Faction.USA, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Missouri"), Faction.USA, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Texas"), Faction.USA, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Washington"), Faction.USA, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS South Dakota"), Faction.USA, ShipType.BATTLESHIPS, Rarity.LEGENDARY, ));



        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Hornet"), Faction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Yorktown"), Faction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Enterprise"), Faction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Langley"), Faction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Saratoga"), Faction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Essex"), Faction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.LEGENDARY, ));



        cards.put("USA_CRUISERS",
                new ShipCard("USS Helena"), Faction.USA, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS San Francisco"), Faction.USA, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Indianapolis"), Faction.USA, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Baltimore"), Faction.USA, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Atlanta"), Faction.USA, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Alaska"), Faction.USA, ShipType.CRUISERS, Rarity.LEGENDARY, ));



        cards.put("USA_DESTROYERS",
                new ShipCard("USS Johnston"), Faction.USA, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Laffey"), Faction.USA, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Fletcher"), Faction.USA, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Porter"), Faction.USA, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Kidd"), Faction.USA, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS O'Bannon"), Faction.USA, ShipType.DESTROYERS, Rarity.LEGENDARY, ));



        cards.put("USA_SUBMARINES",
                new ShipCard("USS Trigger"), Faction.USA, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard(" USS Wahoo"), Faction.USA, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Tang"), Faction.USA, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Nautilus"), Faction.USA, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Gato"), Faction.USA, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Barb"), Faction.USA, ShipType.SUBMARINES, Rarity.LEGENDARY, ));





        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Fusō"), Faction.JAPAN, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Nagato"), Faction.JAPAN, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Yamato"), Faction.JAPAN, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Ise"), Faction.JAPAN, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Mutsu"), Faction.JAPAN, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Musashi"), Faction.JAPAN, ShipType.BATTLESHIPS, Rarity.LEGENDARY, ));



        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Shōkaku"), Faction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Kaga"), Faction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Akagi"), Faction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Ryūjō"), Faction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Zuikaku"), Faction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Shinano"), Faction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.LEGENDARY, ));



        cards.put("JAPAN_CRUISERS",
                new ShipCard("Mogami"), Faction.JAPAN, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Takao"), Faction.JAPAN, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Atago"), Faction.JAPAN, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Kumano"), Faction.JAPAN, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Tone"), Faction.JAPAN, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Chikuma"), Faction.JAPAN, ShipType.CRUISERS, Rarity.LEGENDARY, ));



        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Akizuki"), Faction.JAPAN, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Yūgumo"), Faction.JAPAN, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Kagerō"), Faction.JAPAN, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Shiranui"), Faction.JAPAN, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Tokitsukaze"), Faction.JAPAN, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Hatsuyuki"), Faction.JAPAN, ShipType.DESTROYERS, Rarity.LEGENDARY, ));



        cards.put("JAPAN_SUBMARINES",
                new ShipCard("I-26"), Faction.JAPAN, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-19"), Faction.JAPAN, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-168"), Faction.JAPAN, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-400"), Faction.JAPAN, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-58"), Faction.JAPAN, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-201"), Faction.JAPAN, ShipType.SUBMARINES, Rarity.LEGENDARY, ));





        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Parizhskaya Kommuna"), Faction.ZSRR, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Oktiabrskaja Riewolucija"), Faction.ZSRR, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Marat"), Faction.ZSRR, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Sewastopol"), Faction.ZSRR, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Gangut"), Faction.ZSRR, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Marat"), Faction.ZSRR, ShipType.BATTLESHIPS, Rarity.LEGENDARY, ));



        cards.put("ZSRR_CRUISERS",
                new ShipCard("Czerwona Krym"), Faction.ZSRR, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Czerwona Ukraina"), Faction.ZSRR, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Kirow"), Faction.ZSRR, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Kalinin"), Faction.ZSRR, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Maxim Gorki"), Faction.ZSRR, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Kirow"), Faction.ZSRR, ShipType.CRUISERS, Rarity.LEGENDARY, ));



        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Gromkij"), Faction.ZSRR, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Storozhevoy"), Faction.ZSRR, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Gnewnyj"), Faction.ZSRR, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Soobrazitelnyj"), Faction.ZSRR, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Rekordnyj"), Faction.ZSRR, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Tashkent"), Faction.ZSRR, ShipType.DESTROYERS, Rarity.LEGENDARY, ));



        cards.put("ZSRR_SUBMARINES",
                new ShipCard("S-13"), Faction.ZSRR, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("Shch-303"), Faction.ZSRR, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("D-2"), Faction.ZSRR, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("M-class"), Faction.ZSRR, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("K-21"), Faction.ZSRR, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("L-3"), Faction.ZSRR, ShipType.SUBMARINES, Rarity.LEGENDARY, ));












    }

    public static ShipCard createCard(Faction faction, ShipType type, Rarity rarity) {
        String key = faction.name() + "_" + type.name() + "_" + rarity.name();
        ShipCard card = cards.get(key);
        if (card == null) {
            // jeśli nie ma w bazie — placeholder
            return new ShipCard("Nieznany", faction, type, rarity, 10, 2, 3);
        }
        return card;
    }
}
