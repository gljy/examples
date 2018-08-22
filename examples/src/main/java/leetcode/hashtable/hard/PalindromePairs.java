package leetcode.hashtable.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromePairs {

	public static void main(String[] args) {
		PalindromePairs s = new PalindromePairs();
		System.out.println(s.palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(s.palindromePairs(new String[] { "a", "" }));
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		Map<String, Integer> map = IntStream.range(0, words.length)
				.mapToObj(Integer::valueOf)
				.collect(Collectors.toMap(i -> words[i], i -> i));
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0, len = word.length(); j < len * 2 + 1; j++) {
				String s = j <= len ? word.substring(0, j) : word.substring(j - len);
				Integer k = map.get(new StringBuilder(s).reverse().toString());
				if (k != null && k != i) {
					if (isPalindrome(j <= len ? word.substring(j) : word.substring(0, j - len))
							&& (j <= len && res.add(Arrays.asList(i, k)) || res.add(Arrays.asList(k, i)))) {
					}
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

}
