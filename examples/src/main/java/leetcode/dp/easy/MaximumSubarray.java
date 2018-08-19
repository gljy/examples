package leetcode.dp.easy;

import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * @author guild
 * @date 2018.8.17
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray s = new MaximumSubarray();
		System.out.println(s.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	/*
	 * Example:
	 * 
	 * Input: [-2,1,-3,4,-1,2,1,-5,4]
	 * Output: 6 
	 * Explanation: [4,-1,2,1] has the largest sum = 6.
	 */
	public int maxSubArray(int[] nums) {
		int[] array = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			array[i] = nums[i];
			if (i > 0) {
				if (array[i - 1] > 0) {
					array[i] += array[i - 1];
				}
			}
		}
		return Arrays.stream(array).reduce(Integer.MIN_VALUE, Math::max);
	}

}
