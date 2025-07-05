package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.InvalidDimensionsException;
import Exception.PlayersNotFoundException;
import Exception.WinningStrategiesNotFoundException;
import Enum.GameState;
import Strategies.WinningStrategy;
import Enum.CellState;

@lombok.Data
public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private Player currentPlayer;
    private int timerLeft;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;


    private Game(List<Player> players, int dimensions,
                 List<WinningStrategy> winningStrategies) {
        // Private constructor to enforce the use of the builder
        System.out.println("Creating a new board with dimensions: " + dimensions);
        this.board = new Board(dimensions);
        this.players = players;
        this.currentPlayer = players.get(0); // Start with the first player
        this.timerLeft = 60;
        this.moves = new ArrayList();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public void printBoard() {
        System.out.println("Current Board:");
        board.display();
    }

    public void makeMove(){
        Move move=null;
        int len = players.size();
        int index =0;
        while(gameState==GameState.IN_PROGRESS){
            while(!moves.isEmpty()){
                System.out.println("Do you want to undo the last move? Type (Y/N)");
                Scanner sc = new Scanner(System.in);
                String choice = sc.nextLine();

                if(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")){
                    System.out.println("Please enter a valid choice");
                    continue;
                }

                if(choice.equalsIgnoreCase("N") || moves.isEmpty()){
                    break;
                }else{
                    this.undo();
                    System.out.println("Last move undone.");
                    index--;
                }
            }
            Player currentPlayer = players.get(index%len);
            Cell cell = currentPlayer.makeMove(board);
            if(cell==null){
               gameState=GameState.DRAW;
                this.printBoard();
               System.out.println("Game is a draw! No valid moves left.");
               return;
            }else{
                move = new Move(currentPlayer, cell);
                moves.add(move);
                this.checkForWinner(cell);
            }
            index++;
            this.printBoard();
        }
    }

    private void checkForWinner(Cell cell) {
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.isWinningMove(board,cell)){
                winner = currentPlayer;
                gameState = GameState.CONCLUDED;
                this.printBoard();
                System.out.println("Player - " + winner + " has won the game!");
                return;
            }
        }
    }
    public void undo() {
        if (moves.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        } else {
            Move move = moves.remove(moves.size() - 1);
            board.getCells().get(move.getCell().getRow()).set(move.getCell().getCol(),
                    new Cell(move.getCell().getRow(), move.getCell().getCol(), null, CellState.EMPTY));
            this.setCurrentPlayer(move.getPlayer());
        }
    }

    public static class GameBuilder{
        private List<Player> players;
        private int dimensions; // Although it is not present in the Game class, however
        // we need this because we need to create a board with specific dimensions and also to validate.
        private List<WinningStrategy> winningStrategies;

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() throws PlayersNotFoundException, WinningStrategiesNotFoundException, InvalidDimensionsException {
            if (players == null || players.size() < 2) {
                throw new PlayersNotFoundException("Invalid game configuration");
            }
            if(winningStrategies == null || winningStrategies.isEmpty()) {
                throw new WinningStrategiesNotFoundException("No winning strategies provided");
            }
            if(dimensions <= 0) {
                throw new InvalidDimensionsException("Invalid board dimensions");
            }
            if(players.size() != dimensions-1) {
                throw new PlayersNotFoundException("Number of players must be equal to dimensions - 1");
            }
            return new Game(players,dimensions,winningStrategies);
        }
    }
}
