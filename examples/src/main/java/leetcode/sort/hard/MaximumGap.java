package leetcode.sort.hard;

import java.util.Arrays;

public class MaximumGap {

	public static void main(String[] args) {
		MaximumGap s = new MaximumGap();
		System.out.println(s.maximumGap(new int[] { 3, 6, 9, 1 }));
	}

	public int maximumGap(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}

		Arrays.sort(nums);
		int res = 0;
		for (int i = 1; i < nums.length; i++) {
			res = Math.max(res, nums[i] - nums[i - 1]);
		}
		return res;
	}

}
