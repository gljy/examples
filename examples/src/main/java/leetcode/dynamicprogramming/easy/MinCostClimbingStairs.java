package leetcode.dynamicprogramming.easy;

import java.util.Arrays;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps.
 * 
 * You need to find minimum cost to reach the top of the floor, and you can
 * either start from the step with index 0, or the step with index 1.
 * 
 * @author guild
 * @date 2018.8.15
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		MinCostClimbingStairs s = new MinCostClimbingStairs();
		System.out.println(s.minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(s.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost.length < 2) {
			return 0;
		}

		int[] res = Arrays.copyOf(cost, cost.length);
		for (int i = 2; i < cost.length; i++) {
			res[i] += Math.min(res[i - 2], res[i - 1]);
		}
		return Math.min(res[res.length - 1], res[res.length - 2]);
	}

}
