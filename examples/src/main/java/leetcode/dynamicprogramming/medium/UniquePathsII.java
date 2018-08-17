package leetcode.dynamicprogramming.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * @author guild
 * @date 2018.0.17
 */
public class UniquePathsII {

	public static void main(String[] args) {
		UniquePathsII s = new UniquePathsII();
		int[][] obstacleGrid = {
			{ 0, 0, 0 },
			{ 0, 1, 0 },
			{ 0, 0, 0 },
		};
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
	}

	/*
	 * Example 1:
	 * Input: 
	 * [ 
	 * 	[0,0,0], 
	 * 	[0,1,0], 
	 * 	[0,0,0] 
	 * ] 
	 * Output: 2 
	 * Explanation: 
	 * There is one obstacle in the middle of the 3x3 grid above. 
	 * There are two ways to reach the bottom-right corner: 
	 * 1. Right -> Right -> Down -> Down 
	 * 2. Down -> Down -> Right -> Right
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		
		int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
		grid[0][0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					grid[i][j] = 0;
					continue;
				}
				
				if (i > 0) {
					grid[i][j] += grid[i - 1][j];
				} 
				if (j > 0) {
					grid[i][j] += grid[i][j - 1];
				}
			}
		}
		return grid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

}
