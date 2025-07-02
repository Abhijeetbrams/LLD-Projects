package Model;

import java.util.ArrayList;
import java.util.List;

@lombok.Data
public class Board {
    private int dimensions;
    List<List<Cell>> cells;

    // Constructor to initialize the board with a given dimension
    public Board(int dimensions){
        this.dimensions=dimensions;
        for(int i=0;i<dimensions;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<dimensions;j++){
                row.add(new Cell(i, j, null)); // Initialize each cell with null player
            }
            cells.add(row);
        }
    }

}
