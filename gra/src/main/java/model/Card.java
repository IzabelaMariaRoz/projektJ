package model;

/**
 * Klasa abstrakcyjna reprezentująca dowolną kartę w grze.
 * Jest to baza zarówno dla statków (ShipCard), jak i ewentualnych kart akcji w przyszłości.
 */
public abstract class Card {
    protected String name;
    protected String description;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    // Metoda, którą każda karta musi zaimplementować inaczej
    public abstract String getInfo();
}
