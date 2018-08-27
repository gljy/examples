package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		PermutationsII s = new PermutationsII();
		s.permuteUnique(new int[] { 3, 3, 0, 3 }).forEach(System.out::println);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		permuteUnique(res, new ArrayList<>(), nums);
		return res;
	}

	void permuteUnique(List<List<Integer>> res, List<Integer> l, int[] nums) {
		if (nums.length == 0) {
			if (!res.contains(l)) {
				res.add(l);
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			List<Integer> l2 = new ArrayList<>(l);
			l2.add(nums[i]);
			int[] nums2 = new int[nums.length - 1];
			if (nums2.length > 0 && i > 0) {
				System.arraycopy(nums, 0, nums2, 0, i);
			}
			if (nums2.length > 0 && i < nums.length - 1) {
				System.arraycopy(nums, i + 1, nums2, i, nums.length - 1 - i);
			}
			permuteUnique(res, l2, nums2);
		}
	}

}
