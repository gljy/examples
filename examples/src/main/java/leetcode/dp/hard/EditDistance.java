package leetcode.dp.hard;

/**
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 1.Insert a character
 * 2.Delete a character
 * 3.Replace a character
 * 
 * @author guild
 * @date 2018.8.18
 */
public class EditDistance {

	public static void main(String[] args) {
		EditDistance s = new EditDistance();
		System.out.println(s.minDistance("horse", "ros"));
		System.out.println(s.minDistance("intention", "execution"));
	}

	/*
	 * Example 1:
	 * Input: word1 = "horse", word2 = "ros"
	 * Output: 3
	 * Explanation:
	 * horse -> rorse (replace 'h' with 'r')
	 * rorse -> rose (remove 'r')
	 * rose -> ros (remove 'e')
	 * 
	 * Example 2:
	 * Input: word1 = "intention", word2 = "execution"
	 * Output: 5
	 * Explanation:
	 * intention -> inention (remove 't')
	 * inention -> enention (replace 'i' with 'e')
	 * enention -> exention (replace 'n' with 'x')
	 * exention -> exection (replace 'n' with 'c')
	 * exection -> execution (insert 'u')
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int replace = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1),
						insert = dp[i - 1][j] + 1,
						delete = dp[i][j - 1] + 1;
				dp[i][j] = Math.min(Math.min(insert, delete), replace);
			}
		}
		return dp[m][n];
	}

}
