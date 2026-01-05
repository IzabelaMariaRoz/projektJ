package model;

/**
 * Reprezentuje planszę do gry (macierz 4x4).
 * Zarządza umieszczaniem statków i sprawdzaniem kolizji.
 */
public class Board {
    
    // Siatka 4x4 przechowująca statki. Null oznacza puste pole.
    private ShipCard[][] grid;
    
    public Board() {
        this.grid = new ShipCard[6][6];
    }

    /**
     * Próbuje umieścić statek na podanych koordynatach.
     * @return true jeśli się udało, false jeśli pole jest zajęte.
     */
    public boolean placeShip(ShipCard ship, int row, int col) {
        // TODO: Sprawdzenie granic tablicy
        if (grid[row][col] != null) {
            return false; // Pole zajęte
        }
        grid[row][col] = ship;
        return true;
    }

    /**
     * Zwraca kartę na danej pozycji (lub null).
     */
    public ShipCard getCardAt(int row, int col) {
        return grid[row][col];
    }

    /**
     * Usuwa zniszczony statek z planszy.
     */
    public void removeShip(int row, int col) {
        grid[row][col] = null;
    }
}
