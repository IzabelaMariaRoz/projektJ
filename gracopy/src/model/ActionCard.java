package model;

import model.enums.Rarity;

public class ActionCard extends Card {

    private Rarity rarity;
    private String description;
    
    // Logika działania (używamy tego samego silnika co statki!)
    private String actionEnum;
    private int value;
    private ActiveAbility effect; // Interfejs funkcyjny

    public ActionCard(String name, Rarity rarity, String actionEnum, int value, String description) {
        super(name);
        this.rarity = rarity;
        this.actionEnum = actionEnum;
        this.value = value;
        this.description = description;
    }

    /**
     * Zagranie karty z ręki.
     * @param user - Statek gracza, który "wykonuje" rozkaz (może być null, jeśli to rozkaz ogólny)
     * @param target - Cel (wrogi statek lub sojusznik do uleczenia)
     */
    public void play(ShipCard user, ShipCard target) {
        System.out.println(">>> ZAGRYWAM KARTĘ: " + this.name + " (" + rarity + ")");
        System.out.println("Opis: " + description);
        
        if (effect != null) {
            effect.use(user, target);
        } else {
            System.out.println("Błąd: Karta nie ma przypisanego efektu!");
        }
    }

    // Settery/Gettery
    public void setEffect(ActiveAbility effect) { this.effect = effect; }
    public Rarity getRarity() { return rarity; }
    public String getDescription() { return description; }
    
    @Override
    public String getInfo() {
        return String.format("[AKCJA] %s | %s", name, description);
    }
}