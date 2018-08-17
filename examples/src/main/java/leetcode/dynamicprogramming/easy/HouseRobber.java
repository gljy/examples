package leetcode.dynamicprogramming.easy;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * 
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author guild
 * @date 2018.8.17
 */
public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber s = new HouseRobber();
		System.out.println(s.rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(s.rob(new int[] { 2, 7, 9, 3, 1 }));
	}

	/*
	 * Example 1:
	 * Input: [1,2,3,1]
	 * Output: 4
	 * Explanation:
	 * Rob house 1 (money = 1) and then rob house 3 (money = 3).
	 * Total amount you can rob = 1 + 3 = 4. 
	 * 
	 * Example 2:
	 * Input: [2,7,9,3,1]
	 * Output: 12
	 * Explanation:
	 * Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	 * Total amount you can rob = 2 + 9 + 1 = 12.
	 */
	public int rob(int[] nums) {
		int[] array = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			array[i] = nums[i];
			if (i >= 3) {
				array[i] += Math.max(array[i - 2], array[i - 3]);
			} else if (i >= 2) {
				array[i] += array[i - 2];
			}
		}
		return Arrays.stream(array).reduce(0, Math::max);
	}

}
