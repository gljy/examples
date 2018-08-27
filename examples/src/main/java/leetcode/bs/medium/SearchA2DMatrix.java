package leetcode.bs.medium;

import common.ArrayUtils;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		SearchA2DMatrix s = new SearchA2DMatrix();
		int[][] matrix = ArrayUtils.toIntArray("[[1,3,5,7],[10,11,16,20],[23,30,34,50]]");
		System.out.println(s.searchMatrix(matrix, 23));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int m, n;
		if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) {
			return false;
		}

		int l = 0, r = m - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
				int l2 = 0, r2 = n - 1;
				while (l2 <= r2) {
					int mid2 = (l2 + r2) / 2;
					if (matrix[mid][mid2] == target) {
						return true;
					} else if (matrix[mid][mid2] < target) {
						l2 = mid2 + 1;
					} else {
						r2 = mid2 - 1;
					}
				}
				break;
			} else if (matrix[mid][n - 1] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return false;
	}

}
