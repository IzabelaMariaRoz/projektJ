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
                new ShipCard("Schleswig-Holstein"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Gneisenau"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Bismarck"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Lützow"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Tirpitz"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Lützow"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("GERMANY_BATTLESHIPS",
                new ShipCard("Scharnhorst"), Fraction.GERMANY, ShipType.BATTLESHIPS, Rarity.LEGEND, ));



        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Waser"), Fraction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Elbe"), Fraction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Graf Zeppelin"), Fraction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.STANDARD, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Jade"), Fraction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Friesenland"), Fraction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.UNIQUE, ));

        cards.put("GERMANY_AIRCRAFT-CARRIER",
                new ShipCard("Graf Zeppelin(Premium)"), Fraction.GERMANY, ShipType.AIRCRAFT_CARRIER, Rarity.LEGEND, ));



        cards.put("GERMANY_CUISERS",
                new ShipCard("Leipzig"), Fraction.GERMANY, ShipType.CUISERS, Rarity.STANDARD, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Nürnberg"), Fraction.GERMANY, ShipType.CUISERS, Rarity.STANDARD, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Admiral Hipper"), Fraction.GERMANY, ShipType.CUISERS, Rarity.STANDARD, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Prinz Eugen"), Fraction.GERMANY, ShipType.CUISERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Blücher"), Fraction.GERMANY, ShipType.CUISERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_CUISERS",
                new ShipCard("Admiral Scheer"), Fraction.GERMANY, ShipType.CUISERS, Rarity.LENGEND, ));



        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z1 Leberecht Maass"), Fraction.GERMANY, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z30"), Fraction.GERMANY, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z23"), Fraction.GERMANY, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z17 Diether von Roeder"), Fraction.GERMANY, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z38"), Fraction.GERMANY, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("GERMANY_DESTROYERS",
                new ShipCard("Z39"), Fraction.GERMANY, ShipType.DESTROYERS, Rarity.LEGEND, ));



        cards.put("GERMANY_SUBMARINES",
                new ShipCard("U-47"), Fraction.GERMANY, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("U-96"), Fraction.GERMANY, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("U-99"), Fraction.GERMANY, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("Typ IX"), Fraction.GERMANY, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("Typ VII"), Fraction.GERMANY, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("GERMANY_SUBMARINES",
                new ShipCard("Typ XXI"), Fraction.GERMANY, ShipType.SUBMARINES, Rarity.LEGEND, ));



        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Arizona"), Fraction.USA, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Iowa"), Fraction.USA, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Missouri"), Fraction.USA, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Texas"), Fraction.USA, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS Washington"), Fraction.USA, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("USA_BATTLESHIPS",
                new ShipCard("USS South Dakota"), Fraction.USA, ShipType.BATTLESHIPS, Rarity.LENGEND, ));



        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Hornet"), Fraction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Yorktown"), Fraction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Enterprise"), Fraction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Langley"), Fraction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Saratoga"), Fraction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("USA_AIRCRAFT-CARRIERS",
                new ShipCard("USS Essex"), Fraction.USA, ShipType.AIRCRAFT-CARRIERS, Rarity.LENGEND, ));



        cards.put("USA_CRUISERS",
                new ShipCard("USS Helena"), Fraction.USA, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS San Francisco"), Fraction.USA, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Indianapolis"), Fraction.USA, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Baltimore"), Fraction.USA, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Atlanta"), Fraction.USA, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("USA_CRUISERS",
                new ShipCard("USS Alaska"), Fraction.USA, ShipType.CRUISERS, Rarity.LENGEND, ));



        cards.put("USA_DESTROYERS",
                new ShipCard("USS Johnston"), Fraction.USA, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Laffey"), Fraction.USA, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Fletcher"), Fraction.USA, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Porter"), Fraction.USA, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Kidd"), Fraction.USA, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS O'Bannon"), Fraction.USA, ShipType.DESTROYERS, Rarity.LENGEND, ));



        cards.put("USA_SUBMARINES",
                new ShipCard("USS Trigger"), Fraction.USA, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard(" USS Wahoo"), Fraction.USA, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Tang"), Fraction.USA, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Nautilus"), Fraction.USA, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Gato"), Fraction.USA, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("USA_DESTROYERS",
                new ShipCard("USS Barb"), Fraction.USA, ShipType.SUBMARINES, Rarity.LENGEND, ));





        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Fusō"), Fraction.JAPAN, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Nagato"), Fraction.JAPAN, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Yamato"), Fraction.JAPAN, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Ise"), Fraction.JAPAN, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Mutsu"), Fraction.JAPAN, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("JAPAN_BATTLESHIPS",
                new ShipCard("Musashi"), Fraction.JAPAN, ShipType.BATTLESHIPS, Rarity.LENGEND, ));



        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Shōkaku"), Fraction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Kaga"), Fraction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Akagi"), Fraction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.STANDARD, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Ryūjō"), Fraction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Zuikaku"), Fraction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_AIRCRAFT-CARRIERS",
                new ShipCard("Shinano"), Fraction.JAPAN, ShipType.AIRCRAFT-CARRIERS, Rarity.LENGEND, ));



        cards.put("JAPAN_CRUISERS",
                new ShipCard("Mogami"), Fraction.JAPAN, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Takao"), Fraction.JAPAN, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Atago"), Fraction.JAPAN, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Kumano"), Fraction.JAPAN, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Tone"), Fraction.JAPAN, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_CRUISERS",
                new ShipCard("Chikuma"), Fraction.JAPAN, ShipType.CRUISERS, Rarity.LENGEND, ));



        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Akizuki"), Fraction.JAPAN, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Yūgumo"), Fraction.JAPAN, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Kagerō"), Fraction.JAPAN, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Shiranui"), Fraction.JAPAN, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Tokitsukaze"), Fraction.JAPAN, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("Hatsuyuki"), Fraction.JAPAN, ShipType.DESTROYERS, Rarity.LENGEND, ));



        cards.put("JAPAN_SUBMARINES",
                new ShipCard("I-26"), Fraction.JAPAN, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-19"), Fraction.JAPAN, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-168"), Fraction.JAPAN, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-400"), Fraction.JAPAN, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-58"), Fraction.JAPAN, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("JAPAN_DESTROYERS",
                new ShipCard("I-201"), Fraction.JAPAN, ShipType.SUBMARINES, Rarity.LENGEND, ));





        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Parizhskaya Kommuna"), Fraction.ZSRR, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Oktiabrskaja Riewolucija"), Fraction.ZSRR, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Marat"), Fraction.ZSRR, ShipType.BATTLESHIPS, Rarity.STANDARD, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Sewastopol"), Fraction.ZSRR, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Gangut"), Fraction.ZSRR, ShipType.BATTLESHIPS, Rarity.UNIQUE, ));

        cards.put("ZSRR_BATTLESHIPS",
                new ShipCard("Marat"), Fraction.ZSRR, ShipType.BATTLESHIPS, Rarity.LENGEND, ));



        cards.put("ZSRR_CRUISERS",
                new ShipCard("Czerwona Krym"), Fraction.ZSRR, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Czerwona Ukraina"), Fraction.ZSRR, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Kirow"), Fraction.ZSRR, ShipType.CRUISERS, Rarity.STANDARD, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Kalinin"), Fraction.ZSRR, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Maxim Gorki"), Fraction.ZSRR, ShipType.CRUISERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_CRUISERS",
                new ShipCard("Kirow"), Fraction.ZSRR, ShipType.CRUISERS, Rarity.LENGEND, ));



        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Gromkij"), Fraction.ZSRR, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Storozhevoy"), Fraction.ZSRR, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Gnewnyj"), Fraction.ZSRR, ShipType.DESTROYERS, Rarity.STANDARD, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Soobrazitelnyj"), Fraction.ZSRR, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Rekordnyj"), Fraction.ZSRR, ShipType.DESTROYERS, Rarity.UNIQUE, ));

        cards.put("ZSRR_DESTROYERS",
                new ShipCard("Tashkent"), Fraction.ZSRR, ShipType.DESTROYERS, Rarity.LENGEND, ));



        cards.put("ZSRR_SUBMARINES",
                new ShipCard("S-13"), Fraction.ZSRR, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("Shch-303"), Fraction.ZSRR, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("D-2"), Fraction.ZSRR, ShipType.SUBMARINES, Rarity.STANDARD, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("M-class"), Fraction.ZSRR, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("K-21"), Fraction.ZSRR, ShipType.SUBMARINES, Rarity.UNIQUE, ));

        cards.put("ZSRR_SUBMARINES",
                new ShipCard("L-3"), Fraction.ZSRR, ShipType.SUBMARINES, Rarity.LENGEND, ));












    }
}
    /**
     * Główna metoda fabryczna.

    public static ShipCard createCard(Faction faction, ShipType type, Rarity rarity) {
        String name = "Nieznany Statek";
        int hp = 10;
        int atk = 2;
        int cost = 3;

        // TODO: Tutaj będzie wielki Switch/Map z nazwami statków z pliku
        // Na razie placeholder:
        name = faction.getNazwa() + " " + type.getNazwa() + " (" + rarity.getNazwa() + ")";

        return new ShipCard(name, faction, type, rarity, hp, atk, cost);
    }
}
