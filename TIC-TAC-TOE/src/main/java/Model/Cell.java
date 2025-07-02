package Model;

import Enum.CellState;

@lombok.Data
public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.cellState = CellState.EMPTY; // Default state is empty
    }


}
