package leetcode.dynamicprogramming.medium;

import java.util.LinkedList;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * @author guild
 * @date 2018.8.16
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		LongestValidParentheses s = new LongestValidParentheses();
		System.out.println(s.longestValidParentheses("(()"));
		System.out.println(s.longestValidParentheses(")()())"));
		System.out.println(s.longestValidParentheses("("));
	}

	/*
	 * Example 1:
	 * Input: "(()" 
	 * Output: 2 
	 * Explanation: The longest valid parentheses substring is "()" 
	 * 
	 * Example 2:
	 * Input: ")()())" 
	 * Output: 4 
	 * Explanation: The longest valid parentheses substring is "()()"
	 */
	public int longestValidParentheses(String s) {
		int index = 0, max = 0;
		LinkedList<Integer> l = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				l.push(i);
			} else if (l.isEmpty()) {
				index = i + 1;
			} else {
				l.pop();
				max = l.isEmpty() ? Math.max(max, i - index + 1) : Math.max(max, i - l.peek());
			}
		}
		return max;
	}

}
