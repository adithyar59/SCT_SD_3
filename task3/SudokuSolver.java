package task3;
public class SudokuSolver {
    public static final int SIZE = 9;
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num)
                    return false;
            }
        }
        return true;
    }
    public static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] board = {
            {5, 1, 7, 6, 0, 0, 0, 3, 4},
            {2, 8, 9, 0, 0, 4, 0, 0, 0},
            {3, 4, 6, 2, 0, 5, 0, 9, 0},
            {6, 0, 2, 0, 0, 0, 0, 1, 0},
            {0, 3, 8, 0, 0, 6, 0, 4, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 7, 8},
            {7, 0, 3, 4, 0, 0, 5, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        if (solveSudoku(board)) {
            System.out.println("Sudoku solved successfully:");
            printBoard(board);
        } else {
            System.out.println("solution not exists for the given Sudoku.");
        }
    }
}