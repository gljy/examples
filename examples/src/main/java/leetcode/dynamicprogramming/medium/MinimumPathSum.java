package leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * @author guild
 * @date 2018.8.15
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		MinimumPathSum s = new MinimumPathSum();
		int[][] grid = new int[3][];
		grid[0] = new int[] { 1, 3, 1 };
		grid[1] = new int[] { 1, 5, 1 };
		grid[2] = new int[] { 4, 2, 1 };
//		System.out.println(s.minPathSum(grid));
		grid[0] = new int[] { 1, 2 };
		grid[1] = new int[] { 5, 6 };
		grid[2] = new int[] { 1, 1 };
		System.out.println(s.minPathSum(grid));
	}

	/*
	 * Example:
	 * 
	 * Input: 
	 * [
	 * 	[1,3,1],
	 * 	[1,5,1],
	 * 	[4,2,1] 
	 * ] 
	 * Output: 7 
	 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
	 */
	public int minPathSum(int[][] grid) {
		int[][] m = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				m[i][j] = grid[i][j];
				if (i == 0 && j > 0) {
					m[i][j] += m[i][j - 1];
				} else if (i > 0 && j == 0) {
					m[i][j] += m[i - 1][j];
				} else if (i > 0 && j > 0) {
					m[i][j] += Math.min(m[i][j - 1], m[i - 1][j]);
				}
			}
		}
		System.out.println(Arrays.toString(m[0]));
		System.out.println(Arrays.toString(m[1]));
		System.out.println(Arrays.toString(m[2]));
		return m[m.length - 1][m[0].length - 1];
	}

}
