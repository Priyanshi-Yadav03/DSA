import java.util.*;

class Solution {
    boolean board[][];
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        result = new ArrayList<>();
        helper(0, n);
        return result;
    }

    boolean canPlaceQueen(int row, int col) {
        // same column
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) return false;
        }
        // left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        // right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }
        return true;
    }

    void helper(int row, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(row, col)) {
                board[row][col] = true;
                helper(row + 1, n);
                board[row][col] = false; // backtrack
            }
        }
    }

    List<String> construct(boolean[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
