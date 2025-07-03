package Model;
import java.util.ArrayList;
import java.util.List;
import Exception.InvalidDimensionsException;
import Exception.PlayersNotFoundException;
import Exception.WinningStrategiesNotFoundException;
import Enum.GameState;
import Strategies.WinningStrategy;

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
        this.board=new Board(dimensions);
        this.players = players;
        this.currentPlayer = players.get(0); // Start with the first player
        this.timerLeft = 60;
        this.moves=new ArrayList();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies=winningStrategies;
    }
    public static GameBuilder getBuilder() {
        return new GameBuilder();
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
            return new Game(players,dimensions,winningStrategies);
        }
    }
}
