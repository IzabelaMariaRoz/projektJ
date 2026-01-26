package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    private ShipCard[][] grid;
    // NOWOŚĆ: Tablica pamiętająca pudła (true = tu strzelano i nic nie ma)
    private boolean[][] missedShots; 
    
    public Board() {
        this.grid = new ShipCard[6][6];
        this.missedShots = new boolean[6][6];
    }

    public boolean placeShip(ShipCard ship, int row, int col) {
        if (row >= 0 && row < 6 && col >= 0 && col < 6) {
            if (this.grid[row][col] == null) {
                this.grid[row][col] = ship;
                ship.setBoard(this); 
                return true;
            }
        }
        return false;
    }

    // --- NOWE METODY DO OBSŁUGI PUDEŁ ---
    public void markMiss(int row, int col) {
        if (isValid(row, col)) {
            missedShots[row][col] = true;
        }
    }

    public boolean isMiss(int row, int col) {
        if (isValid(row, col)) {
            return missedShots[row][col];
        }
        return false;
    }
    // -------------------------------------

    public ShipCard getCardAt(int row, int col) {
        if (isValid(row, col)) {
            return grid[row][col];
        }
        return null;
    }

    public void removeShip(int row, int col) {
        grid[row][col] = null;
    }
    
    public List<ShipCard> getShipsOnBoard() {
        List<ShipCard> ships = new ArrayList<>();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (grid[row][col] != null) ships.add(grid[row][col]);
            }
        }
        return ships;
    }
    
    private boolean isValid(int row, int col) {
        return row >= 0 && row < 6 && col >= 0 && col < 6;
    }
    
    /**
     * Zwraca listę statków, które są jeszcze zakryte (isFaceDown == true).
     * Używane przez umiejętność RADAR_SCAN.
     */
    public List<ShipCard> getHiddenShips() {
        List<ShipCard> hidden = new ArrayList<>();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                ShipCard card = grid[row][col];
                if (card != null && card.isFaceDown()) {
                    hidden.add(card);
                }
            }
        }
        return hidden;
    }
    
// Dodaj to do klasy Board.java
    
    public boolean hasAliveShips() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (grid[row][col] != null && grid[row][col].getHp() > 0) {
                    return true; // Jest przynajmniej jeden żywy
                }
            }
        }
        return false; // Wszyscy martwi
    }
}