package com.example.LLD.TIC_TAC_TOE;

import Controller.GameController;
import Model.BotPlayer;
import Model.Game;
import Model.HumanPlayer;
import Model.Player;
import Strategies.ColumnWinningStrategy;
import Strategies.DiagonalWinningStrategy;
import Strategies.RowWinningStrategy;
import Strategies.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Exception.PlayersNotFoundException;
import Exception.WinningStrategiesNotFoundException;
import Exception.InvalidDimensionsException;
import Enum.BotPlayerType;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) throws PlayersNotFoundException, WinningStrategiesNotFoundException, InvalidDimensionsException {

		SpringApplication.run(TicTacToeApplication.class, args);
		System.out.println("Tic Tac Toe Application Started!");

		// Initialization of Game
		// Initialize a new game with default settings
		Player player1 = new HumanPlayer("Player 1", 1, 1, 'X');
		Player player2 = new BotPlayer("Player 2", 2, BotPlayerType.EASY, 'O');

		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);

		List<WinningStrategy> winningStrategies = new ArrayList<>();
		winningStrategies.add(new RowWinningStrategy());
		winningStrategies.add(new ColumnWinningStrategy());
		winningStrategies.add(new DiagonalWinningStrategy());

		GameController gameController = new GameController();
		Game game = gameController.startNewGame(players, 3, winningStrategies);
		gameController.printBoard(game);


		// Start the game
		gameController.makeMove(game);
	}

}
