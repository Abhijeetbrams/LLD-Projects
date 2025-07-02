package Model;
import Util.Validations;

import java.util.Scanner;
import Enum.PlayerType;


public class HumanPlayer extends Player{
    private int ranking;
    private String email;

    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, int gamerId, PlayerType playerType, Character symbol, int ranking, String email) {
        super(name, gamerId, playerType, symbol);
        this.ranking = ranking;
        this.email = email;
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Enter your move (row and column): ");
        int row=0;
        int col=0;
        do {
            row = scanner.nextInt();
            col = scanner.nextInt();
        }while(!Validations.checkValidMove(board, row, col));

        // Create a new Cell with the given row and column
        return new Cell(row, col, this);
    }
}
