package leetcode.array.medium;

public class SpiralMatrixII {

	public static void main(String[] args) {
		SpiralMatrixII s = new SpiralMatrixII();
		int[][] matrix = s.generateMatrix(10);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		for (int i = 0, start = 1; n > 0; n -= 2) {
			int len = (n - 1) * 4;
			len = len == 0 ? 1 : len;
			fill(matrix, i++, start, len);
			start += len;
		}
		return matrix;
	}

	private void fill(int[][] matrix, int layer, int num, int len) {
		int l = layer, r = matrix.length - 1 - layer;
		for (int i = 0, trun = (len + 3) / 4; i < len; i++, num++) {
			if (i >= 3 * trun) {
				matrix[r - i % trun][l] = num;
			} else if (i >= 2 * trun) {
				matrix[r][r - i % trun] = num;
			} else if (i >= 1 * trun) {
				matrix[l + i % trun][r] = num;
			} else {
				matrix[l][l + i] = num;
			}
		}
	}

}
