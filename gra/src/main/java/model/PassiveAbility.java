package model;

@FunctionalInterface
public interface PassiveAbility {
    // Obiekt pasywki (self) -> Ten, kto go zaatakował/odkrył (attacker)
    void trigger(ShipCard self, ShipCard attacker);
}