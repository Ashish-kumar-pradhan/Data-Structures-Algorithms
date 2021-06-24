package backtracking;

import java.util.ArrayList;

public class NQueens {
	
	static private boolean isSafe(int[][] board, int row, int col, int n) {
        int i, j;

        // Check this coloumn
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static private void addSolution(int[][] board, int n, ArrayList<ArrayList<Integer>> ans) {
        ArrayList<Integer> currentAnswer = new ArrayList<>();

        for (int[] row : board) {
            for (int element : row) {
                currentAnswer.add(element);
            }
        }

        ans.add(currentAnswer);
    }

    static private void solveNQueensHelper(int[][] board, int row, int n, ArrayList<ArrayList<Integer>> ans) {
        if (row >= n) {
            addSolution(board, n, ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i, n)) {

                board[row][i] = 1; // Place the queen and move to the next row
                solveNQueensHelper(board, row + 1, n, ans);
                board[row][i] = 0; // Un-mark the queen and backtrack

            }
        }
    }


    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solveNQueensHelper(board, 0, n, ans);
        return ans;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(4);

	}

}
