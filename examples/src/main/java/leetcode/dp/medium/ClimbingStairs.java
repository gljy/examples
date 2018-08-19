package leetcode.dp.medium;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author guild
 * @date 2018.8.16
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs s = new ClimbingStairs();
		for (int n = 2; n < 10; n++) {
		System.out.println(s.climbStairs(n));
		}
	}

	/*
	 * Example 1:
	 * Input: 2 
	 * Output: 2 
	 * Explanation: There are two ways to climb to the top. 
	 * 1. 1 step + 1 step 
	 * 2. 2 steps 
	 * 
	 * Example 2:
	 * Input: 3 
	 * Output: 3 
	 * Explanation: There are three ways to climb to the top. 
	 * 1. 1 step + 1 step + 1 step 
	 * 2. 1 step + 2 steps 
	 * 3. 2 steps + 1 step
	 */
	public int climbStairs(int n) {
		int[] array = new int[n + 1];
		Arrays.fill(array, 1);
		for (int i = 2; i <= n; i++) {
			array[i] = array[i - 2] + array[i - 1];
		}
		return array[n];
	}

}
