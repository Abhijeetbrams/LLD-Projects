package Model;

import java.util.ArrayList;
import java.util.List;
import Enum.CellState;

@lombok.Data
public class Board {
    private int dimensions;
    List<List<Cell>> cells;

    // Constructor to initialize the board with a given dimension
    public Board(int dimensions){
        this.dimensions=dimensions;
        this.cells = new ArrayList<>();
        for(int i=0;i<dimensions;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<dimensions;j++){
                row.add(new Cell(i, j, null, CellState.EMPTY)); // Initialize each cell with null player
            }

            //System.out.println("Row " + i + " initialized: ");
            cells.add(row);
        }
    }

    public void display() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                System.out.print("|"+ cell.printBoardCell() +"|");
            }
            System.out.println();
        }
    }

}
