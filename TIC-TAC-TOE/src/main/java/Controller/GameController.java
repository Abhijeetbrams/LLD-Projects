package Controller;

import Enum.GameState;
import Enum.PlayerType;
import Model.*;
import Enum.BotPlayerType;

import java.util.ArrayList;
import java.util.List;
import Exception.PlayersNotFoundException;
import Exception.WinningStrategiesNotFoundException;
import Exception.InvalidDimensionsException;
import Strategies.WinningStrategy;
import Strategies.RowWinningStrategy;
import Strategies.ColumnWinningStrategy;
import Strategies.DiagonalWinningStrategy;
import Enum.GameState;

public class GameController {

    public Game startNewGame(List<Player> players, int dimensions, List<WinningStrategy> winningStrategies) throws PlayersNotFoundException, WinningStrategiesNotFoundException, InvalidDimensionsException {

        Game game = Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

        return game;
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undoLastMove(Game game) {
        game.undo();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
}
