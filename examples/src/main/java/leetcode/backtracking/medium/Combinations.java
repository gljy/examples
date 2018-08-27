package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		Combinations s = new Combinations();
		s.combine(5, 3).forEach(System.out::println);
	}

	public List<List<Integer>> combine(int n, int k) {
		if (k == 0 || n < k) {
			return Collections.emptyList();
		}

		List<List<Integer>> res = new ArrayList<>();
		combine(res, new ArrayList<>(), n, k);
		return res;
	}

	void combine(List<List<Integer>> res, List<Integer> l, int n, int k) {
		if (k == 0) {
			res.add(l);
			return;
		}

		for (int i = l.isEmpty() ? 1 : l.get(l.size() - 1) + 1; i <= n; i++) {
			List<Integer> copy = new ArrayList<>(l);
			copy.add(i);
			combine(res, copy, n, k - 1);
		}
	}

}
