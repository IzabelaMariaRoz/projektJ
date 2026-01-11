package model;

/**
 * Reprezentuje planszę do gry (macierz 6x6).
 * Zarządza umieszczaniem statków i sprawdzaniem kolizji.
 */
public class Board {

    // Siatka 6x6 przechowująca statki. Null oznacza puste pole.
    private ShipCard[][] grid;

    public Board() {
        this.grid = new ShipCard[6][6];
    }

    /**
     * Próbuje umieścić statek na podanych koordynatach.
     * @return true jeśli się udało, false jeśli pole jest zajęte
     *         lub współrzędne są poza planszą.
     */
    public boolean placeShip(ShipCard ship, int row, int col) {

        // sprawdzenie granic tablicy
        if (row < 0 || row >= 6 || col < 0 || col >= 6) {
            return false;
        }

        if (grid[row][col] != null) {
            return false; // pole zajęte
        }

        grid[row][col] = ship;
        return true;
    }

    /**
     * Zwraca kartę na danej pozycji (lub null).
     */
    public ShipCard getCardAt(int row, int col) {
        if (row < 0 || row >= 6 || col < 0 || col >= 6) {
            return null;
        }
        return grid[row][col];
    }

    /**
     * Usuwa zniszczony statek z planszy.
     */
    public void removeShip(int row, int col) {
        if (row < 0 || row >= 6 || col < 0 || col >= 6) {
            return;
        }
        grid[row][col] = null;
    }
}
