package leetcode.backtracking.medium;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch s = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(s.exist(board, "ABCCED"));
		System.out.println(s.exist(board, "SEE"));
		System.out.println(s.exist(board, "ABCB"));

		board = new char[][] { { 'A' } };
		System.out.println(s.exist(board, "A"));
	}

	private boolean[][] flag;

	public boolean exist(char[][] board, String word) {
		if (word.isEmpty()) {
			return false;
		}

		flag = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean search(char[][] board, int i, int j, String word, int index) {
		if (index == word.length()) {
			return true;
		}

		if (i < 0 || i > board.length - 1
				|| j < 0  || j > board[i].length - 1 
				|| board[i][j] != word.charAt(index) || flag[i][j]) {
			return false;
		}

		flag[i][j] = true;
		if (search(board, i - 1, j, word, index + 1) 
				|| search(board, i, j - 1, word, index + 1)
				|| search(board, i + 1, j, word, index + 1) 
				|| search(board, i, j + 1, word, index + 1)) {
			return true;
		}
		flag[i][j] = false;
		return false;
	}

}
