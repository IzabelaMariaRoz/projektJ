package model;

import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

/**
 * Konkretna implementacja karty statku.
 * Przechowuje statystyki: życie, atak, koszt, stan (zakryta/odkryta).
 */
public class ShipCard extends Card {
    
    private Faction faction;
    private ShipType type;
    private Rarity rarity;
    
    // Statystyki statku
    private int hp;
    private int attack;
    private int abilityCost; // Koszt użycia umiejętności w kredytach
    private boolean isFaceDown; // Czy karta jest zakryta (nieznana dla wroga)

    public ShipCard(String name, Faction faction, ShipType type, Rarity rarity, int hp, int attack, int abilityCost) {
        super(name);
        this.faction = faction;
        this.type = type;
        this.rarity = rarity;
        this.hp = hp;
        this.attack = attack;
        this.abilityCost = abilityCost;
        this.isFaceDown = true; // Domyślnie zakryta przy wystawieniu
    }

    // TODO: Metoda do aktywacji umiejętności specjalnej
    public void activateAbility() {
        // Logika sprawdzania kredytów i wykonywania efektu
    }

    // TODO: Metoda otrzymywania obrażeń
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }

    public boolean isDestroyed() {
        return hp <= 0;
    }

    @Override
    public String getInfo() {
        return name + " [" + faction + "] HP:" + hp + " ATK:" + attack;
    }

    // Gettery potrzebne dla widoku
    public int getHp() { return hp; }
    public Faction getFaction() { return faction; }
    public boolean isFaceDown() { return isFaceDown; }
}
