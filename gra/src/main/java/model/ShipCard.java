package model;

import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

import java.io.Serializable;

public class ShipCard extends Card implements Serializable {
    private static final long serialVersionUID = 1L; // Wersjonowanie klasy

    private Faction faction;
    private ShipType type;
    private Rarity rarity;

    private int hp;
    private int attack;
    private int abilityCost;
    private boolean isFaceDown;

    public ShipCard(String name, Faction faction, ShipType type, Rarity rarity, int hp, int attack, int abilityCost) {
        super(name);
        this.faction = faction;
        this.type = type;
        this.rarity = rarity;
        this.hp = hp;
        this.attack = attack;
        this.abilityCost = abilityCost;
        this.isFaceDown = true;
    }

    // Gettery
    public Rarity getRarity() { return rarity; }
    public int getAttack() { return attack; }
    public ShipType getType() { return type; }
    public int getHp() { return hp; }
    public Faction getFaction() { return faction; }
    public boolean isFaceDown() { return isFaceDown; }

    public void activateAbility() { /* logika */ }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (hp < 0) hp = 0;
    }

    public boolean isDestroyed() { return hp <= 0; }

    @Override
    public String getInfo() {
        return name + " [" + faction + "] HP:" + hp + " ATK:" + attack;
    }
}
