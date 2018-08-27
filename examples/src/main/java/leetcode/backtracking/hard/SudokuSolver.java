package leetcode.backtracking.hard;

import common.ArrayUtils;

public class SudokuSolver {

	public static void main(String[] args) {
		SudokuSolver s = new SudokuSolver();
		String input = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
		char[][] board = ArrayUtils.toCharArray(input);
		s.solveSudoku(board);
		ArrayUtils.print(board);

		input = "[[\".\",\".\",\"5\",\"3\",\".\",\".\",\".\",\".\",\".\"],[\"8\",\".\",\".\",\".\",\".\",\".\",\".\",\"2\",\".\"],[\".\",\"7\",\".\",\".\",\"1\",\".\",\"5\",\".\",\".\"],[\"4\",\".\",\".\",\".\",\".\",\"5\",\"3\",\".\",\".\"],[\".\",\"1\",\".\",\".\",\"7\",\".\",\".\",\".\",\"6\"],[\".\",\".\",\"3\",\"2\",\".\",\".\",\".\",\"8\",\".\"],[\".\",\"6\",\".\",\"5\",\".\",\".\",\".\",\".\",\"9\"],[\".\",\".\",\"4\",\".\",\".\",\".\",\".\",\"3\",\".\"],[\".\",\".\",\".\",\".\",\".\",\"9\",\"7\",\".\",\".\"]]";
		board = ArrayUtils.toCharArray(input);
		s.solveSudoku(board);
		ArrayUtils.print(board);
	}

	public void solveSudoku(char[][] board) {
		solve(board);
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					char ch = board[i][j];
					board[i][j] = '.';
					if (!isValid(board, i, j, ch)) {
						return false;
					}
					board[i][j] = ch;
				}
			}
		}
		return true;
	}

	boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char ch = '1'; ch <= '9'; ch++) {
						if (isValid(board, i, j, ch)) {
							board[i][j] = ch;
							if (solve(board)) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int x, int y, char ch) {
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == ch || board[x][i] == ch || board[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == ch) {
				return false;
			}
		}
		return true;
	}

}
