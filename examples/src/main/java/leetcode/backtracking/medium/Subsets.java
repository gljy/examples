package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		Subsets s = new Subsets();
		s.subsets(new int[] { 1, 2, 3 }).forEach(System.out::println);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int i = 1; i <= nums.length; i++) {
			List<List<Integer>> subs = combine(nums, i);
			if (!subs.isEmpty()) {
				res.addAll(subs);
			}
		}
		return res;
	}

	List<List<Integer>> combine(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<>();
		combine(res, new ArrayList<>(), nums, 0, k);
		return res;
	}

	void combine(List<List<Integer>> res, List<Integer> l, int[] nums, int start, int k) {
		if (k == 0) {
			res.add(l);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			List<Integer> copy = new ArrayList<>(l);
			copy.add(nums[i]);
			combine(res, copy, nums, i + 1, k - 1);
		}
	}

}
