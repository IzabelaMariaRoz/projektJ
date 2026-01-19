package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    // Siatka 6x6
    private ShipCard[][] grid;
    
    public Board() {
        this.grid = new ShipCard[6][6];
    }

    public boolean placeShip(ShipCard ship, int row, int col) {
        if (row >= 0 && row < 6 && col >= 0 && col < 6) {
            if (this.grid[row][col] == null) {
                this.grid[row][col] = ship;
                
                // WAŻNE: Przypisujemy statkowi referencję do tej planszy
                ship.setBoard(this); 
                
                return true;
            }
        }
        return false;
    }

    public ShipCard getCardAt(int row, int col) {
        if (row >= 0 && row < 6 && col >= 0 && col < 6) {
            return grid[row][col];
        }
        return null;
    }

    public void removeShip(int row, int col) {
        grid[row][col] = null;
    }
    
    /**
     * Zwraca listę wszystkich statków na tej planszy, które są jeszcze zakryte.
     * Potrzebne dla umiejętności RADAR_SCAN.
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
}
