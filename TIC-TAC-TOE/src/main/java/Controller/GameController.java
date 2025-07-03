package Controller;

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

public class GameController {

    public Game startNewGame() throws PlayersNotFoundException, WinningStrategiesNotFoundException, InvalidDimensionsException {
        // Initialize a new game with default settings
        Player player1 = new HumanPlayer("Player 1", 1, 1, 'X');
        Player player2 = new BotPlayer("Player 2", 2,BotPlayerType.EASY, 'O');

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = Game.getBuilder()
                .setDimensions(3)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

        return game;
    }
}
