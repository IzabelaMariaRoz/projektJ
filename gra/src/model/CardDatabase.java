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

    /**
     * Główna metoda fabryczna.
     */
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
