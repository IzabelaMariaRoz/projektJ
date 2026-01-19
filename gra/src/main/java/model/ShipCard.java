package model;

import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

public class ShipCard extends Card {
    
    private Faction faction;
    private ShipType type;
    private Rarity rarity;
    
    // Statystyki podstawowe
    private int maxHp;
    private int currentHp;
    private boolean isFaceDown;
    
    // Referencja do planszy (dla Radaru)
    private Board board;

    // --- DANE Z CSV (Opisy i parametry) ---
    private String activeAbilityName;  
    private String activeAbilityEnum;  
    private int abilityCost;           
    private int activeParams;          

    private String passiveAbilityName; 
    private String passiveAbilityEnum; 
    private int passiveParams;         

    // --- INTERFEJSY FUNKCYJNE (Logika) ---
    private ActiveAbility activeAbility;   
    private PassiveAbility passiveAbility; 

    // Konstruktor
    public ShipCard(String name, Faction faction, ShipType type, Rarity rarity, int hp,
                    String activeName, int cost, String activeEnum, int activeVal,
                    String passiveName, String passiveEnum, int passiveVal) {
        super(name);
        this.faction = faction;
        this.type = type;
        this.rarity = rarity;
        
        this.maxHp = hp;
        this.currentHp = hp;
        this.isFaceDown = true;

        // Przypisanie danych z CSV
        this.activeAbilityName = activeName;
        this.abilityCost = cost;
        this.activeAbilityEnum = activeEnum;
        this.activeParams = activeVal;
        
        this.passiveAbilityName = passiveName;
        this.passiveAbilityEnum = passiveEnum;
        this.passiveParams = passiveVal;
    }

    // --- METODY LOGICZNE (Używane przez AbilityFactory) ---

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    public void heal(int amount) {
        this.currentHp += amount;
        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
        System.out.println(this.name + " naprawiony o " + amount + " HP. (Obecnie: " + currentHp + "/" + maxHp + ")");
    }

    public void addAttackBuff(int amount) {
        System.out.println("BUFF: " + this.name + " zwiększa siłę ognia o " + amount + "!");
    }

    // Wywołanie aktywnej umiejętności
    public void performAction(ShipCard target) {
        if (this.activeAbility != null) {
            System.out.println(this.name + " używa: " + this.activeAbilityName);
            this.activeAbility.use(this, target);
        } else {
            System.out.println(this.name + " nie ma aktywnej umiejętności.");
        }
    }

    // Wywołanie pasywki i odsłonięcie
    public void reveal(ShipCard attacker) {
        if (this.isFaceDown) {
            this.isFaceDown = false;
            System.out.println(">>> ODKRYTO JEDNOSTKĘ: " + this.getName() + " [" + this.getHp() + " HP]");
            triggerPassive(attacker);
        }
    }

    public void triggerPassive(ShipCard attacker) {
        if (this.passiveAbility != null) {
            this.passiveAbility.trigger(this, attacker);
        }
    }

    public void takeDamage(int dmg) {
        this.currentHp -= dmg;
        if (this.currentHp < 0) this.currentHp = 0;
        System.out.println(this.name + " otrzymuje " + dmg + " obrażeń. Zostało: " + currentHp);
        
        // Jeśli oberwał, a był zakryty -> odsłaniamy
        if (this.isFaceDown) {
            reveal(null); // null, bo nie zawsze znamy źródło przy zwykłym dmg
        }
    }

    // --- GETTERY I SETTERY ---

    public void setActiveAbility(ActiveAbility ability) { this.activeAbility = ability; }
    public void setPassiveAbility(PassiveAbility ability) { this.passiveAbility = ability; }

    public ActiveAbility getActiveAbility() { return activeAbility; }
    public PassiveAbility getPassiveAbility() { return passiveAbility; }

    public Faction getFaction() { return faction; }
    public ShipType getType() { return type; }
    public Rarity getRarity() { return rarity; }
    public int getHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getAbilityCost() { return abilityCost; }
    public boolean isFaceDown() { return isFaceDown; }
    public void setFaceDown(boolean faceDown) { this.isFaceDown = faceDown; }

    // --- KLUCZOWE GETTERY DO NAPRAWY BŁĘDU ---
    public String getActiveAbilityName() { return activeAbilityName; }
    public String getPassiveAbilityName() { return passiveAbilityName; }
    // ------------------------------------------

    public String getActiveAbilityEnum() { return activeAbilityEnum; }
    public int getActiveParams() { return activeParams; }
    public String getPassiveAbilityEnum() { return passiveAbilityEnum; }
    public int getPassiveParams() { return passiveParams; }

    @Override
    public String getInfo() {
        return String.format("%s [%s] HP:%d | Skill: %s (%d kr)", 
                name, rarity, currentHp, activeAbilityName, abilityCost);
    }
}
