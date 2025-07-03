package Strategies;

import Model.Board;
import Model.Cell;

public interface WinningStrategy {

    boolean isWinningMove(Board board, Cell cell);
}
