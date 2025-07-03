package Strategies;

import Model.Board;
import Model.Cell;
import Model.Player;

public class MediumBotPlayerStrategy implements BotPlayingStrategy {
    Player player;

    public MediumBotPlayerStrategy(Player player) {
        this.player = player;
    }

    @Override
    public Cell makeMove(Board board) {
        // Implement the logic for the medium bot player strategy here
        // This could involve checking for winning moves, blocking opponent's moves, etc.
        // For now, returning null as a placeholder
        return null;
    }
}
