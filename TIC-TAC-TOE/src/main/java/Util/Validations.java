package Util;

import Model.Board;

public class Validations {
    public static boolean checkValidMove(Board board, int row, int col) {
        // Check if the row and column are within the bounds of the board
        if (row < 0 || row >= board.getDimensions() || col < 0 || col >= board.getDimensions()) {
            System.out.println("Invalid move, Please choose a valid cell within the board dimensions.");
            return false; // Move is out of bounds
        }
        // Additional checks can be added here, such as checking if the cell is already occupied
        // For example, if you have a method in Board to check if a cell is occupied:
        if(board.getCells().get(row).get(col).getPlayer() != null) {
            System.out.println("Cell is already occupied. Please choose another cell.");
            return false; // Cell is already occupied
        }
        return true; // Move is valid
    }
}
