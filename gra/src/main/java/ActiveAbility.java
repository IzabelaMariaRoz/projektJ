package model;

@FunctionalInterface
public interface ActiveAbility {
    // Źródło (kto używa) -> Cel (na kim używa)
    void use(ShipCard source, ShipCard target);
}