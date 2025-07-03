package Model;

import Enum.PlayerType;

@lombok.Data
public abstract class Player {
    private String name;
    private int gamerId;
    private PlayerType playerType;
    private Character symbol;

    public Player(String name, int gamerId, PlayerType playerType, Character symbol) {
        this.name = name;
        this.gamerId = gamerId;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public abstract Cell makeMove(Board board);
}
