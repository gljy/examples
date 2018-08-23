package leetcode.bfs.medium;

import common.ArrayUtils;

public class SurroundedRegions {

	public static void main(String[] args) {
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = ArrayUtils.toCharArray(
				"[[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"]]");
		s.solve(board);
		ArrayUtils.print(board);
	}

	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boolean flag = i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1;
				if (flag && board[i][j] == 'O') {
					solve(board, i, j);
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
			}
		}
	}

	void solve(char[][] board, int i, int j) {
		if (board[i][j] != 'O') {
			return;
		}

		board[i][j] = 'Z';
		if (i > 0) {
			solve(board, i - 1, j);
		}
		if (i < board.length - 1) {
			solve(board, i + 1, j);
		}
		if (j > 0) {
			solve(board, i, j - 1);
		}
		if (j < board[0].length - 1) {
			solve(board, i, j + 1);
		}
	}

}
