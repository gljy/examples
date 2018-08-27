package leetcode.backtracking.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearchII {

	public static void main(String[] args) {
		WordSearchII s = new WordSearchII();
		char[][] board = {
			{'o','a','a','n'},
			{'e','t','a','e'},
			{'i','h','k','r'},
			{'i','f','l','v'}
		};
		s.findWords(board, new String[] { "oath", "pea", "eat", "rain" }).forEach(System.out::println);
	}

	public List<String> findWords(char[][] board, String[] words) {
		return Arrays.stream(words)
				.filter(word -> exist(board, word))
				.collect(Collectors.toList());
	}
	
	private boolean[][] flag;

	private boolean exist(char[][] board, String word) {
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
