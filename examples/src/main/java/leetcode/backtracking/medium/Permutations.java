package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations s = new Permutations();
		s.permute(new int[] { 1, 2, 3 }).forEach(System.out::println);
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		permute(res, new ArrayList<>(), nums);
		return res;
	}

	void permute(List<List<Integer>> res, List<Integer> l, int[] nums) {
		if (nums.length == 0) {
			res.add(l);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			List<Integer> l2 = new ArrayList<>(l);
			l2.add(nums[i]);
			int[] nums2 = new int[nums.length - 1];
			if (nums2.length > 0 && i > 0) {
				System.arraycopy(nums, 0, nums2, 0, i);
			}
			if (nums2.length > 0 && i < nums.length - 1) {
				System.arraycopy(nums, i + 1, nums2, i, nums.length - 1 - i);
			}
			permute(res, l2, nums2);
		}
	}

}
