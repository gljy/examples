package leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * Given a non negative integer number num.
 * 
 * For every numbers i in the range 0 �� i �� num calculate the number of 1's in
 * their binary representation and return them as an array.
 * 
 * @author guild
 * @date 2018.8.15
 */
public class CountingBits {

	public static void main(String[] args) {
		CountingBits s = new CountingBits();
		System.out.println(Arrays.toString(s.countBits(2)));
		System.out.println(Arrays.toString(s.countBits(5)));
	}

	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		for (int i = 1, n = 0; i <= num; i++) {
			if (Math.pow(2, n) == i) {
				res[i] = 1;
				n++;
			} else {
				int prev = (int) Math.pow(2, n - 1);
				res[i] = res[prev] + res[i - prev];
			}
		}
		return res;
	}

}
