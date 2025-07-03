package Model;
import Enum.BotPlayerType;
import Enum.PlayerType;
import Enum.CellState;
import Strategies.EasyBotPlayerStrategy;
import Strategies.HardBotPlayerStrategy;
import Strategies.MediumBotPlayerStrategy;

public class BotPlayer extends Player{
    BotPlayerType botPlayerType;

    public BotPlayer(String name, int gamerId, BotPlayerType botPlayerType, Character symbol) {
        super(name, gamerId, PlayerType.BOT, symbol);
        this.botPlayerType = botPlayerType;
    }

    @Override
    public Cell makeMove(Board board) {
        if (board == null || board.getCells() == null || board.getCells().isEmpty()) {
            throw new IllegalArgumentException("Invalid board state.");
        }
        if (botPlayerType == null) {
            throw new IllegalArgumentException("Bot player type cannot be null.");
        }
        if(botPlayerType.equals(BotPlayerType.EASY)) {
            return new EasyBotPlayerStrategy(this).makeMove(board);
        } else if(botPlayerType.equals(BotPlayerType.MEDIUM)) {
            return new MediumBotPlayerStrategy(this).makeMove(board);
        } else if(botPlayerType.equals(BotPlayerType.HARD)) {
            return new HardBotPlayerStrategy(this).makeMove(board);
        } else {
            throw new UnsupportedOperationException("Unsupported bot player type: " + botPlayerType);
        }
    }

}
