package Strategies;

import Model.Board;
import Model.Cell;
import Model.Player;
import org.springframework.boot.autoconfigure.web.WebProperties;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinningMove(Board board, Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();
        Player player=cell.getPlayer();

        boolean isWinning=true;

        for(int i=0; i<board.getDimensions(); i++) {
            Cell currentCell = board.getCells().get(row).get(i);
            if (currentCell.getPlayer() == null || !currentCell.getPlayer().equals(player)) {
                isWinning = false;
                break;
            }
        }
        return isWinning;
    }
}
