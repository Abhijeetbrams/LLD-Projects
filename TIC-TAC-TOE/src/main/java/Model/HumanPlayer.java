package Model;
import Util.Validations;

import java.util.Scanner;
import Enum.PlayerType;
import Enum.CellState;


public class HumanPlayer extends Player{
    int ranking;
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, int gamerId, int ranking, Character symbol) {
        super(name, gamerId, PlayerType.HUMAN, symbol);
        this.ranking = ranking;
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
        return new Cell(row, col, this, CellState.FILLED);
    }
}
