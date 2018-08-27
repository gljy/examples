package leetcode.backtracking.easy;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		LetterCasePermutation s = new LetterCasePermutation();
		s.letterCasePermutation("a1b2").forEach(System.out::println);
	}

	public List<String> letterCasePermutation(String S) {
		if (S.isEmpty()) {
			LinkedList<String> res = new LinkedList<>();
			res.add("");
			return res;
		}
		
		LinkedList<String> res = new LinkedList<>();
		for (char ch : S.toCharArray()) {
			push(res, ch);
		}
		return res;
	}
	
	private void push(LinkedList<String> res, char ch) {
		for (int i = 0, len = Math.max(res.size(), 1); i < len; i++) {
			String s = res.isEmpty() ? "" : res.pollLast();
			if (Character.isDigit(ch)) {
				res.push(s + ch);
			} else {
				res.push(s + Character.toUpperCase(ch));
				res.push(s + Character.toLowerCase(ch));
			}
		}
	}

}
