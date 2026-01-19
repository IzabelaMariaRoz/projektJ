package model;

import java.util.Collections;
import java.util.List;

public class AbilityFactory {

    public static ActiveAbility createActive(String enumCode, int value) {
        switch (enumCode) {
            case "HEAVY_SHOT":
            case "LIGHT_SHOT":
            case "PRECISION_SHOT":
            case "SNIPE_SHOT":
                return (source, target) -> {
                    if (target != null) {
                        System.out.println(">> STRZAŁ za " + value + " dmg!");
                        target.takeDamage(value);
                    }
                };

            case "DOUBLE_SHOT":
                return (source, target) -> {
                    if (target != null) {
                        System.out.println(">> PODWÓJNY STRZAŁ!");
                        target.takeDamage(value);
                        target.takeDamage(value);
                    }
                };

            case "TORPEDO":
            case "PIERCING_SHOT":
                return (source, target) -> {
                    if (target != null) {
                        System.out.println(">> TORPEDA/PRZEBICIE za " + value + "!");
                        target.takeDamage(value);
                    }
                };

            case "HEAL":
                return (source, target) -> {
                    // Jeśli target null, leczymy siebie
                    ShipCard healingTarget = (target != null) ? target : source;
                    healingTarget.heal(value);
                };

            case "BUFF_ATTACK":
            case "BUFF_DEFENSE":
                return (source, target) -> {
                     ShipCard buffTarget = (target != null) ? target : source;
                     buffTarget.addAttackBuff(value);
                };

            case "AIRSTRIKE_SINGLE":
            case "AIRSTRIKE_ROW":
            case "AIRSTRIKE_AOE":
                return (source, target) -> {
                    if (target != null) {
                        System.out.println(">> BOMBY SPADAJĄ (" + value + " dmg)!");
                        target.takeDamage(value);
                    }
                };
            
            case "SCOUT":
                 return (source, target) -> {
                    if (target != null) target.reveal(source);
                 };

            // --- NOWA UMIEJĘTNOŚĆ: RADAR_SCAN ---
            case "RADAR_SCAN":
                return (source, target) -> {
                    // Target w tym przypadku oznacza cel ataku (np. wrogi statek).
                    // Pobieramy planszę przeciwnika z tego celu.
                    if (target == null) {
                        System.out.println("Błąd: Musisz wybrać cel z planszy wroga, aby użyć radaru.");
                        return;
                    }

                    Board enemyBoard = target.getBoard();
                    if (enemyBoard == null) return;

                    List<ShipCard> hiddenShips = enemyBoard.getHiddenShips();
                    
                    if (hiddenShips.isEmpty()) {
                        System.out.println(">> RADAR: Brak celów do wykrycia.");
                        return;
                    }

                    // Mieszamy i odkrywamy X kart
                    Collections.shuffle(hiddenShips);
                    int count = Math.min(value, hiddenShips.size());
                    
                    System.out.println(">> RADAR SKANUJE OBSZAR... Wykryto " + count + " obiekty!");
                    for (int i = 0; i < count; i++) {
                        // Źródłem odkrycia jest 'source' (ten kto użył radaru)
                        hiddenShips.get(i).reveal(source);
                    }
                };
            // ------------------------------------

            case "NONE":
            default:
                return (source, target) -> System.out.println("... (Brak efektu)");
        }
    }

    public static PassiveAbility createPassive(String enumCode, int value) {
        switch (enumCode) {
            case "PASSIVE_COUNTER":
                return (self, attacker) -> {
                    if (attacker != null) {
                        System.out.println(">> KONTRATAK! " + self.getName() + " oddaje za " + value);
                        attacker.takeDamage(value);
                    }
                };
            case "PASSIVE_ARMOR":
                return (self, attacker) -> {
                    System.out.println(">> PANCERZ absorbuje obrażenia.");
                    self.heal(value); 
                };
            case "PASSIVE_BLOCK_FIRST":
            case "PASSIVE_DODGE":
                return (self, attacker) -> System.out.println(">> UNIK/BLOK!");
            case "PASSIVE_REVEAL_ATTACKER":
                return (self, attacker) -> {
                    if (attacker != null) {
                        System.out.println(">> RADAR PASYWNY: Wykryto pozycję wroga: " + attacker.getName());
                        attacker.reveal(self);
                    }
                };
            default:
                return null;
        }
    }
}