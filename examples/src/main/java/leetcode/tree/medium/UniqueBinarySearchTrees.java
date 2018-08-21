package leetcode.tree.medium;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
		for (int i = 1; i <= 5; i++) {
			System.out.println(s.numTrees(i));
		}
	}

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

}
