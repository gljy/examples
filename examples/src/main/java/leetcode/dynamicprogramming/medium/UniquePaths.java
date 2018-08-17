package leetcode.dynamicprogramming.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * @author guild
 * @date 2018.0.17
 */
public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths s = new UniquePaths();
		System.out.println(s.uniquePaths(3, 2));
		System.out.println(s.uniquePaths(7, 3));
	}

	/*
	 * Example 1:
	 * Input: m = 3, n = 2
	 * Output: 3
	 * Explanation:
	 * From the top-left corner, there are a total of 3 ways to reach the
	 * bottom-right corner:
	 * 1. Right -> Right -> Down
	 * 2. Right -> Down -> Right
	 * 3. Down -> Right -> Right
	 * 
	 * Example 2:
	 * Input: m = 7, n = 3
	 * Output: 28
	 */
	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];
		grid[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0) {
					grid[i][j] += grid[i - 1][j];
				} 
				if (j > 0) {
					grid[i][j] += grid[i][j - 1];
				}
			}
		}
		return grid[m - 1][n - 1];
	}

}
