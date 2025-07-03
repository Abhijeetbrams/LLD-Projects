package Strategies;

import Model.Cell;
import Model.Board;
import Enum.CellState;
import Model.Player;

public class EasyBotPlayerStrategy implements BotPlayingStrategy {

    private Player player;

    public EasyBotPlayerStrategy(Player player) {
        this.player = player;
    }

    public Cell makeMove(Board board) {
        // Implement bot logic to make a move.
        // For EasyBotPlayerStrategy, we can just return the first empty cell.
        for (int row = 0; row < board.getCells().size(); row++) {
            for (int col = 0; col < board.getCells().get(row).size(); col++) {
                if (board.getCells().get(row).get(col).getCellState() == CellState.EMPTY) {
                    Cell cell = new Cell(row, col, player, CellState.FILLED);
                    // Update the board with the new cell
                    board.getCells().get(row).set(col, cell);
                    return cell;
                }
            }
        }
        return null; // No valid move found.
    }
}
