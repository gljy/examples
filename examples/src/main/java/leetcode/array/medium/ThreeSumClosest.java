package leetcode.array.medium;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		ThreeSumClosest s = new ThreeSumClosest();
		System.out.println(s.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		long res = nums[0] + nums[1] + nums[nums.length - 1];
		for (int i = 0, len = nums.length; i < len; i++) {
			int j = i + 1, k = len - 1;
			while (k > j) {
				long sum = nums[i] + nums[j] + nums[k];
				if (sum > target) {
					k--;
				} else {
					j++;
				}
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}
		return (int) res;
	}

}
