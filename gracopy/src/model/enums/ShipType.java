package model.enums;

public enum ShipType {
    AIRCRAFT_CARRIER("Lotniskowiec"),
    BATTLESHIP("Pancernik"),
    CRUISER("Krążownik"),
    DESTROYER("Niszczyciel"),
    SUBMARINE("Okręt podwodny");

    private final String nazwa;

    ShipType(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() { return nazwa; }
}