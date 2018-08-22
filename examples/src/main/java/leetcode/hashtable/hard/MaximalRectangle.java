package leetcode.hashtable.hard;

import java.util.Arrays;

public class MaximalRectangle {

	public static void main(String[] args) {
		MaximalRectangle s = new MaximalRectangle();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		System.out.println(s.maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		int m, n;
		if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) {
			return 0;
		}

		int res = 0;
		int[] right = new int[n], left = new int[n], height = new int[n];
		Arrays.fill(right, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}

			int curleft = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], curleft);
				} else {
					left[j] = 0;
					curleft = j + 1;
				}
			}

			int curright = n;
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], curright);
				} else {
					right[j] = n;
					curright = j;
				}
			}
			for (int j = 0; j < n; j++) {
				res = Math.max(res, (right[j] - left[j]) * height[j]);
			}
		}
		return res;
	}

}
