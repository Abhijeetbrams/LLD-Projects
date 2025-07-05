package Strategies;

import Model.Board;
import Model.Cell;

public class DiagonalWinningStrategy implements WinningStrategy{

    // Check if the move is in a winning diagonal
    @Override
    public boolean isWinningMove(Board board, Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();
        boolean isWinning = false;
        // Check for the main diagonal (top-left to bottom-right)
        if (row == col) {
            isWinning = true;
            for(int i=0;i< board.getDimensions();i++){
                Cell currentCell = board.getCells().get(i).get(i);
                if (currentCell.getPlayer() == null || !currentCell.getPlayer().equals(cell.getPlayer())) {
                    isWinning = false;
                    break;
                }
            }
        }

        // Check for the anti-diagonal (top-right to bottom-left)
        if (row + col == board.getDimensions() - 1) {
            isWinning = true;
            for(int i=0;i< board.getDimensions();i++){
                Cell currentCell = board.getCells().get(board.getDimensions()-i-1).get(i);
                if (currentCell.getPlayer() == null || !currentCell.getPlayer().equals(cell.getPlayer())) {
                    isWinning = false;
                    break;
                }
            }
        }

        return isWinning;
    }
}
