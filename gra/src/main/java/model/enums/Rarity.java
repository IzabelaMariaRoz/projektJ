package model.enums;

public enum Rarity {
    STANDARD("Standard", 85),
    UNIQUE("Unikalny", 10),
    LEGENDARY("Legendarny", 5);

    private final String nazwa;
    private final int szansa;

    Rarity(String nazwa, int szansa) {
        this.nazwa = nazwa;
        this.szansa = szansa;
    }

    public String getNazwa() { return nazwa; }
    public int getSzansa() { return szansa; }
}
