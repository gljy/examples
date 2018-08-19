package leetcode.dp.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * @author guild
 * @date 2018.8.17
 */
public class RangeSumQuery {
	
	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		RangeSumQuery s = new RangeSumQuery(nums);
		System.out.println(s.sumRange(0, 2));
		System.out.println(s.sumRange(2, 5));
		System.out.println(s.sumRange(0, 5));
	}

	private int[] sum;

	public RangeSumQuery(int[] nums) {
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	/*
	 * Example: 
	 * Given nums = [-2, 0, 3, -5, 2, -1]
	 * 
	 * sumRange(0, 2) -> 1 
	 * sumRange(2, 5) -> -1 
	 * sumRange(0, 5) -> -3
	 */
	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}

}
