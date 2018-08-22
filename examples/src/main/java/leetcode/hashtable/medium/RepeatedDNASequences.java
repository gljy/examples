package leetcode.hashtable.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		RepeatedDNASequences s = new RepeatedDNASequences();
		System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<>(), res = new HashSet<>();
		for (int i = 0, len = s.length() - 9; i < len; i++) {
			String sub = s.substring(i, i + 10);
			if (!set.add(sub)) {
				res.add(sub);
			}
		}
		return new ArrayList<>(res);
	}

}
