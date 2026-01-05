package model.enums;

public enum Faction {
    GER("Niemcy"),
    USA("Stany Zjednoczone"),
    JAP("Japonia"),
    ZSR("Związek Radziecki");

    private final String nazwa;

    Faction(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}
