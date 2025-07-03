package Strategies;

import Model.Board;
import Model.Cell;

public interface BotPlayingStrategy {
    public abstract Cell makeMove(Board board);
}
