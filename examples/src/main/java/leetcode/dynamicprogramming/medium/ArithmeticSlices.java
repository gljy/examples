package leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * A sequence of number is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 * 
 * @author guild
 * @date 2018.8.15
 */
public class ArithmeticSlices {

	public static void main(String[] args) {
		ArithmeticSlices s = new ArithmeticSlices();
		System.out.println(s.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4, 5, 8, 9, 10 }));
	}

	public int numberOfArithmeticSlices(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		
		int res = 0;
		for (int i = 0, len = A.length; i < len - 2; i++) {
			for (int j = i + 2; j < len; j++) {
				if (isArithmeticSlices(A, i, j)) {
					res++;
				}
			}
		}
		return res;
	}
	
	private boolean isArithmeticSlices(int[] array, int begin, int end) {
		boolean flag = true;
		int n = array[begin + 1] - array[begin];
		for (int i = begin + 2; i <= end; i++) {
			if (array[i] - array[i - 1] != n) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
