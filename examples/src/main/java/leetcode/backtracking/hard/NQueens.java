package leetcode.backtracking.hard;

import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		NQueens s = new NQueens();
		s.solveNQueens(4).forEach(System.out::println);
	}

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board, '.');
		}
		
		return null;
	}
	
	boolean isValid(char[][] board, int x, int y) {
		int z = Math.min(x, y);
		for (int i = 0; i < board.length; i++) {
			if (board[i][y] == 'Q' || board[x][i] == 'Q') {
				return false;
			}
			if (x - z + i < board.length && y - z + i < board.length && board[x - z + i][y - z + i] == 'Q') {
				return false;
			}
			// TODO
			if (x - z + i < board.length && y - z + i < board.length && board[x - z + i][y - z + i] == 'Q') {
				return false;
			}
		}
		/*1 1 1 1
		  1 1 1 1
		  1 1 1 1
		  1 1 1 1*/
		return false;
	}

}
