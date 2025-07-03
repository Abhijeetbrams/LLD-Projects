package Strategies;

import Model.Board;
import Model.Cell;
import Model.Player;

public class HardBotPlayerStrategy implements BotPlayingStrategy{
    Player player;

    public HardBotPlayerStrategy(Player player) {
        this.player = player;
    }

    @Override
    public Cell makeMove(Board board){
        // Implement the logic for the hard bot player strategy here

        return null;
    }
}
