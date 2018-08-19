package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		FourSum s = new FourSum();
		System.out.println(s.fourSum(new int[] { 1, -2, -5, -4, -3, 3, 3, 5 }, -11));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0, len = nums.length; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int l = j + 1, r = len - 1;
				while (r > l) {
					long sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
					}
					if (sum > target) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		return res;
	}

}
