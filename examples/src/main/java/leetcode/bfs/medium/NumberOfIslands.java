package leetcode.bfs.medium;

import common.ArrayUtils;

public class NumberOfIslands {

	public static void main(String[] args) {
		NumberOfIslands s = new NumberOfIslands();
		char[][] grid = ArrayUtils.toCharArray("[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]");
		System.out.println(s.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					removeIslands(grid, i, j);
				}
			}
		}
		return res;
	}
	
	void removeIslands(char[][] grid, int i, int j) {
		if (grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		if (i > 0) {
			removeIslands(grid, i - 1, j);
		}
		if (i < grid.length - 1) {
			removeIslands(grid, i + 1, j);
		}
		if (j > 0) {
			removeIslands(grid, i, j - 1);
		}
		if (j < grid[0].length - 1) {
			removeIslands(grid, i, j + 1);
		}
	}

}
